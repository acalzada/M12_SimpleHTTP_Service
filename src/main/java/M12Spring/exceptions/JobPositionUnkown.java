package M12Spring.exceptions;

public class JobPositionUnkown extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public JobPositionUnkown(String errorMessage, Throwable causeErr) {
		super(errorMessage, causeErr);
	}
	
	public JobPositionUnkown(String errorMessage) {
		super(errorMessage);
	}
	
	public JobPositionUnkown()  {
		this("Unkown Job Position requested.");
	}
}
