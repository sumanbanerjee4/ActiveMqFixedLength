package activeMq.Repo;


import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ScanRequestModel {

	@Id
	private String txnSrcRef;

	@Column
	private String msg_id;

	@Column
	private String correl_id;

	@Column
	private String profile_id;

	@Column
	private String res_type;

	@Column
	private String metaData;

	@Column
	private Timestamp create_ts;

	public String getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getCorrel_id() {
		return correl_id;
	}

	public void setCorrel_id(String correl_id) {
		this.correl_id = correl_id;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getTxn_src_ref() {
		return txnSrcRef;
	}

	public void setTxn_src_ref(String txnSrcRef) {
		this.txnSrcRef = txnSrcRef;
	}

	public String getRes_type() {
		return res_type;
	}

	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public Timestamp getCreate_ts() {
		return create_ts;
	}

	public void setCreate_ts(Timestamp create_ts) {
		this.create_ts = create_ts;
	}


	public ScanRequestModel() {

	}

	public ScanRequestModel(String msg_id, String correl_id, String profile_id, String txnSrcRef, String res_type,
			String metaData, Timestamp create_ts) {
		super();
		this.msg_id = msg_id;
		this.correl_id = correl_id;
		this.profile_id = profile_id;
		this.txnSrcRef = txnSrcRef;
		this.res_type = res_type;
		this.metaData = metaData;
		this.create_ts = create_ts;
	}





}
