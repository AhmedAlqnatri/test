package classes;

import java.util.Date;

public class VisaRequest {

	private long VisaId = 0;
	private String UserName = null;
	private UserName FullName = null;
	private String ToCountry = null;
	private Date ApplyDate = null;
	private Boolean Status = false;
	public long getVisaId() {
		return VisaId;
	}
	
	public void setVisaId(long visaId) {
		VisaId = visaId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public UserName getFullName() {
		return FullName;
	}
	public void setFullName(UserName fullName) {
		FullName = fullName;
	}
	public String getToCountry() {
		return ToCountry;
	}
	public void setToCountry(String toCountry) {
		ToCountry = toCountry;
	}
	public Date getApplyDate() {
		return ApplyDate;
	}
	public void setApplyDate(Date applyDate) {
		ApplyDate = applyDate;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	
	
}
