package serial.mock;

@SuppressWarnings("serial")
public class PortInUseException extends Exception {

	public PortInUseException(String message) {
		super(message);
	}

}
