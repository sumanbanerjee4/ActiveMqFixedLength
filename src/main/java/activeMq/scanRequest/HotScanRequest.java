package activeMq.scanRequest;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record(minOccurs = 1)
public class HotScanRequest {

	@Field(ordinal = 1, length = 3)
	private String streamId;
	@Field(ordinal = 2, length = 1)
	private String reqType;
	@Field(ordinal = 3, length = 22)
	private String trxRef;
	@Field(ordinal = 4, length = 1)
	private String fmtType;
	@Field(ordinal = 5, length = 19)
	private String charAmount;
	@Field(ordinal = 6, length = 3)
	private String currency;
	@Field(ordinal = 7, length = 3)
	private String service;
	@Field(ordinal = 8, length = 3)
	private String srcctry;
	@Field(ordinal = 9, length = 3)
	private String destctry;
	@Field(ordinal = 10, length = 3)
	private String criteriaSeq;
	@Field(ordinal = 11, length = 5)
	private String dataCount;
	@Field(ordinal = 12, length = 31999)
	private String dataStream;
	
	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getTrxRef() {
		return trxRef;
	}

	public void setTrxRef(String trxRef) {
		this.trxRef = trxRef;
	}

	public String getFmtType() {
		return fmtType;
	}

	public void setFmtType(String fmtType) {
		this.fmtType = fmtType;
	}

	public String getCharAmount() {
		return charAmount;
	}

	public void setCharAmount(String charAmount) {
		this.charAmount = charAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSrcctry() {
		return srcctry;
	}

	public void setSrcctry(String srcctry) {
		this.srcctry = srcctry;
	}

	public String getDestctry() {
		return destctry;
	}

	public void setDestctry(String destctry) {
		this.destctry = destctry;
	}

	public String getCriteriaSeq() {
		return criteriaSeq;
	}

	public void setCriteriaSeq(String criteriaSeq) {
		this.criteriaSeq = criteriaSeq;
	}

	public String getDataCount() {
		return dataCount;
	}

	public void setDataCount(String dataCount) {
		this.dataCount = dataCount;
	}

	public String getDataStream() {
		return dataStream;
	}

	public void setDataStream(String dataStream) {
		this.dataStream = dataStream;
	}

	public HotScanRequest() {
	
	}

	public HotScanRequest(String streamId, String reqType, String trxRef, String fmtType, String charAmount, String currency,
			String service, String srcctry, String destctry, String criteriaSeq, String dataCount, String dataStream) {
	
		this.streamId = streamId;
		this.reqType = reqType;
		this.trxRef = trxRef;
		this.fmtType = fmtType;
		this.charAmount = charAmount;
		this.currency = currency;
		this.service = service;
		this.srcctry = srcctry;
		this.destctry = destctry;
		this.criteriaSeq = criteriaSeq;
		this.dataCount = dataCount;
		this.dataStream = dataStream;
	}

	@Override
	public String toString() {
		return streamId +  reqType  + trxRef + fmtType + charAmount +  currency  + service +  srcctry + destctry +  criteriaSeq  + dataCount
				 + dataStream ;
	}

}