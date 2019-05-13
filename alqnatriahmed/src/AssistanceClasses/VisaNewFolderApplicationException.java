package AssistanceClasses;

public class VisaNewFolderApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public VisaNewFolderApplicationException(String message) {
		this.message = message;
	}

	public String toString() {
		return "Visa New Folder Application Error [" + message + "]";
	}

}
