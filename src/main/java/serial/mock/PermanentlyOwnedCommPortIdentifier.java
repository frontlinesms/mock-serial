package serial.mock;

public class PermanentlyOwnedCommPortIdentifier extends CommPortIdentifier {	
	public PermanentlyOwnedCommPortIdentifier(String name, String owner) {
		super(name, null);
		setOwner(owner);
	}

	public synchronized String getCurrentOwner() {
		return super.getCurrentOwner();
	}

	public String getName() {
		return super.getName();
	}

	public int getPortType() { return super.getPortType(); }

	public synchronized boolean isCurrentlyOwned() { return true; }
	
	public synchronized SerialPort open(String appname, int timeout) throws PortInUseException {
		throw new PortInUseException("This port is already in use by: " + getCurrentOwner());
	}
}
