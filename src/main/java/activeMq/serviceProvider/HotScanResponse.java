package activeMq.serviceProvider;

import java.util.Date;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record(minOccurs = 1)
public class HotScanResponse {
	@Field(ordinal = 1, length = 1)
	private String hs_rply_resp_type;
	@Field(ordinal = 2, length = 22)
	private String hs_rply_trx_ref;
	@Field(ordinal = 3, length = 1)
	private String hs_rply_req_type;
	@Field(ordinal = 4, length = 1)
	private String hs_rply_process_type;
	@Field(ordinal = 5, length = 1)
	private String hs_rply_bypass_type;
	@Field(ordinal = 6,format="MMddyyyy", length = 14)
	private Date hs_rply_date;
	@Field(ordinal = 7, length = 11)
	private String hs_rply_oper_id;
	
	public HotScanResponse() {
		
	}

	public HotScanResponse(String hs_rply_resp_type, String hs_rply_trx_ref, String hs_rply_req_type,
			String hs_rply_process_type, String hs_rply_bypass_type, Date hs_rply_date, String hs_rply_oper_id) {
		super();
		this.hs_rply_resp_type = hs_rply_resp_type;
		this.hs_rply_trx_ref = hs_rply_trx_ref;
		this.hs_rply_req_type = hs_rply_req_type;
		this.hs_rply_process_type = hs_rply_process_type;
		this.hs_rply_bypass_type = hs_rply_bypass_type;
		this.hs_rply_date = hs_rply_date;
		this.hs_rply_oper_id = hs_rply_oper_id;
	}

	public String getHs_rply_resp_type() {
		return hs_rply_resp_type;
	}

	public void setHs_rply_resp_type(String hs_rply_resp_type) {
		this.hs_rply_resp_type = hs_rply_resp_type;
	}

	public String getHs_rply_trx_ref() {
		return hs_rply_trx_ref;
	}

	public void setHs_rply_trx_ref(String hs_rply_trx_ref) {
		this.hs_rply_trx_ref = hs_rply_trx_ref;
	}

	public String getHs_rply_req_type() {
		return hs_rply_req_type;
	}

	public void setHs_rply_req_type(String hs_rply_req_type) {
		this.hs_rply_req_type = hs_rply_req_type;
	}

	public String getHs_rply_process_type() {
		return hs_rply_process_type;
	}

	public void setHs_rply_process_type(String hs_rply_process_type) {
		this.hs_rply_process_type = hs_rply_process_type;
	}

	public String getHs_rply_bypass_type() {
		return hs_rply_bypass_type;
	}

	public void setHs_rply_bypass_type(String hs_rply_bypass_type) {
		this.hs_rply_bypass_type = hs_rply_bypass_type;
	}

	public Date getHs_rply_date() {
		return hs_rply_date;
	}

	public void setHs_rply_date(Date hs_rply_date) {
		this.hs_rply_date = hs_rply_date;
	}

	public String getHs_rply_oper_id() {
		return hs_rply_oper_id;
	}

	public void setHs_rply_oper_id(String hs_rply_oper_id) {
		this.hs_rply_oper_id = hs_rply_oper_id;
	}


	
}
