package M12Spring.exceptions;

public class MissingSalariesException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public MissingSalariesException(String errorMessage, Throwable causeErr) {
		super(errorMessage, causeErr);
	}
	
	public MissingSalariesException(String errorMessage) {
		super(errorMessage);
	}
	
	public MissingSalariesException()  {
		this("There is different number of entries for position roles than salaries asigned for those positions.");
	}

}
