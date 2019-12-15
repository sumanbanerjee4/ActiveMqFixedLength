package activeMq.serviceProvider;

import javax.jms.JMSException;


import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import activeMq.Repo.ProfileMasterData;
import activeMq.Repo.ProfileMasterDataRepo;
import activeMq.Repo.ScanRequestModel;
import activeMq.Repo.ScanRequestRepo;

@Component
public class ServiceResponse {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceResponse.class);

	@Autowired
	ScanRequestRepo scanRequestRepo;

	@Autowired
	ScanRequestModel ScanRequestModel;

	@Autowired
	ProfileMasterData QModel;

	@Autowired
	ProfileMasterDataRepo QRepo;

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "Q3")
	public void receive(Message message) throws JmsException, JMSException {
		
		LOGGER.info("-------------------------------Response Flow---------------------------------");
		LOGGER.info("Listening on Q3");
		LOGGER.info("Received Q3 message='{}'", message);
		LOGGER.info("CorrelationID of Request : ",message.getJMSCorrelationID());
		String transRef = message.getJMSCorrelationID();
		ScanRequestModel = scanRequestRepo.findByTxnSrcRef(transRef);
		LOGGER.info("ProfileId of the Requested System : ",ScanRequestModel.getProfile_id());
		String profileId = ScanRequestModel.getProfile_id();
		QModel = QRepo.findByProfileId(profileId.trim());
		
		LOGGER.info("Sending Data to designated Queue");
		LOGGER.info(QModel.getTargetQ().trim());
		jmsTemplate.convertAndSend(QModel.getTargetQ().trim(), message);

	}

}
