package activeMq.serviceProvider;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.activemq.Message;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class FinalConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(FinalConsumer.class);


		@JmsListener(destination = "Q4")
		public void receive(Message message) throws JmsException, JMSException {
			LOGGER.info("-------------------------------FinalConsumer---------------------------------");
			LOGGER.info("Listening on Q4");
			LOGGER.info("Received message='{}'", message);
			StreamFactory factory = StreamFactory.newInstance();
			StreamBuilder builder = new StreamBuilder("Tm")
					.format("fixedlength")
					.parser(new FixedLengthParserBuilder())
					.addRecord(HotScanResponse.class);
		     
			factory.define(builder);
			   Unmarshaller unmarshaller = factory.createUnmarshaller("Tm");
			   TextMessage textMessage = (TextMessage) message;
			      String text = textMessage.getText();
			
			   HotScanResponse response =  (HotScanResponse) unmarshaller.unmarshal(text);
			   LOGGER.info("Response TrxRefNo "+response.getHs_rply_trx_ref());
	           LOGGER.info("Response OperationID "+response.getHs_rply_oper_id());
		}
}
