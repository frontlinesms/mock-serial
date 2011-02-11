package serial.mock;

@SuppressWarnings("serial")
public class NoSuchPortException extends Exception {
	public NoSuchPortException(String portName) {
		super("No serial.mock.CommPortIdentifier for port: " + portName);
	}
}
