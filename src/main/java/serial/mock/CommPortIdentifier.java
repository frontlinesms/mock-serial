package serial.mock;

import java.util.Enumeration;
import java.util.Iterator;

public class CommPortIdentifier {
	public static final int PORT_SERIAL = 0; // 0 should be default value for getPortType() called on mocks
	public static final int PORT_PARALLEL = 1;

	private final String name;
	private final SerialPortHandler handler;
	
	private String owner;
	
	public CommPortIdentifier(String name, SerialPortHandler handler) {
		this.name = name;
		this.handler = handler;
	}

	public synchronized String getCurrentOwner() {
		return this.owner;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getPortType() { return PORT_SERIAL; }
	
	public synchronized boolean isCurrentlyOwned() { return this.owner != null; }
	
	public synchronized SerialPort open(String appname, int timeout) throws PortInUseException {
		if(!MockSerial.isMultipleOwnershipAllowed() && isCurrentlyOwned()) {
			throw new PortInUseException("This port is already in use by: " + owner);
		} else {
			this.owner = appname;
			return new SerialPort(this.handler);
		}
	}
	
	public static CommPortIdentifier getPortIdentifier(String portName) throws NoSuchPortException {
		CommPortIdentifier cpi = MockSerial.getIdentifier(portName);
		if(cpi == null) {
			throw new NoSuchPortException(portName);
		} else {
			return cpi;
		}
	}
	
	public static Enumeration getPortIdentifiers() {
		return MockSerial.getPortIdentifiers();
	}
}
