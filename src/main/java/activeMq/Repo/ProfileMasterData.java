package activeMq.Repo;

import java.sql.Timestamp;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity
public class ProfileMasterData {
	@Id
	private String profileId;
	
	@Column
	private String direction;
	
	@Column
	private String targetQMgr;
	
	@Column
	private String targetQ;
	
	@Column
	private String metaData;
	
	@Column
	private Timestamp created_TS;
	
	

	public ProfileMasterData() {
		
	}



	public ProfileMasterData(String profileId, String direction, String targetQMgr, String targetQ, String metaData,
			Timestamp created_TS) {
		super();
		this.profileId = profileId;
		this.direction = direction;
		this.targetQMgr = targetQMgr;
		this.targetQ = targetQ;
		this.metaData = metaData;
		this.created_TS = new Timestamp(System.currentTimeMillis());
	}



	public String getProfileId() {
		return profileId;
	}



	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}



	public String getDirection() {
		return direction;
	}



	public void setDirection(String direction) {
		this.direction = direction;
	}



	public String getTargetQMgr() {
		return targetQMgr;
	}



	public void setTargetQMgr(String targetQMgr) {
		this.targetQMgr = targetQMgr;
	}



	public String getTargetQ() {
		return targetQ;
	}



	public void setTargetQ(String targetQ) {
		this.targetQ = targetQ;
	}



	public String getMataData() {
		return metaData;
	}



	public void setMataData(String metaData) {
		this.metaData = metaData;
	}



	public Timestamp getCreated_TS() {
		return created_TS;
	}



	public void setCreated_TS(Timestamp created_TS) {
		this.created_TS = created_TS;
	} 
	
	

	
}
