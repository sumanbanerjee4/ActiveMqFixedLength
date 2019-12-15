package activeMq.serviceProvider;

import java.sql.Timestamp;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.activemq.Message;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import activeMq.Repo.ScanRequestModel;
import activeMq.Repo.ScanRequestRepo;
import activeMq.scanRequest.HotScanRequest;

public class ServiceRequest {
	@Autowired
	ScanRequestRepo scanRequestRepo;
	@Autowired
	private JmsTemplate jmsTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRequest.class);

	@JmsListener(destination = "Q1")
	public void receive(Message message) throws JmsException, JMSException {

		LOGGER.info("-------------------------------Request Flow---------------------------------");
		LOGGER.info("Listening on Q1");
		LOGGER.info("Request Recieved from System ", message);
	

		StreamFactory factory = StreamFactory.newInstance();
		StreamBuilder builder = new StreamBuilder("Tm")
				.format("fixedlength")
				.parser(new FixedLengthParserBuilder())
				.addRecord(HotScanRequest.class);
		factory.define(builder);
		Unmarshaller unmarshaller = factory.createUnmarshaller("Tm");
		
		 TextMessage textMessage = (TextMessage) message;
	      String text = textMessage.getText();
	
		System.out.println(text);
		HotScanRequest scanRequest =  (HotScanRequest) unmarshaller.unmarshal(text);
		
		LOGGER.info("Persisting Request data in DB ");

		String messageId = message.getStringProperty("JmsMessageId");
		System.out.println(messageId);
		String profileId="PROFILE_AA";
		scanRequestRepo.save(new ScanRequestModel(messageId,scanRequest.getTrxRef(),profileId,
				scanRequest.getTrxRef(),"FIXDLNT","MetaData",new Timestamp(System.currentTimeMillis())));

		String msg = profileId;

		LOGGER.info("Sending message to Q2='{}'", msg + "    TransRef :  " +scanRequest.getTrxRef());

		jmsTemplate.convertAndSend("Q2", msg, m -> {

			LOGGER.info("setting standard JMS headers before sending");
			m.setJMSCorrelationID(String.valueOf(scanRequest.getTrxRef()));
			return m;
		});
	}

}
