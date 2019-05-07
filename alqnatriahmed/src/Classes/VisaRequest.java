package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VisaRequest {

	private long VisaId = 0;
	private String UserName = null;
	private UserName FullName = null;
	private String ToCountry = null;
	private String ApplyDate = null;
	private boolean Status = false;
	private String Description = "Waitting";
	//hash map of every visa request <Filetype , username>
	private Map<String, String> VisaFiles = new HashMap<String, String>();

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

	public String getApplyDate() {
		return ApplyDate;
	}

	public void setApplyDate(String applyDate) {
		ApplyDate = applyDate;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public Map<String, String> getVisaFiles() {
		return VisaFiles;
	}

	public void setVisaFiles(Map<String, String> visaFiles) {
		VisaFiles = visaFiles;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
