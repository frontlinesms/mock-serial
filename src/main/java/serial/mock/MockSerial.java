package serial.mock;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import serial.SerialClassFactory;

/**
 * This class is not thread-safe and should not be used in concurrent tests. FIXME make sure the POM is not set to run concurrent unit tests.
 */
public class MockSerial {
	@SuppressWarnings("unchecked")
	private static final Map<String, CommPortIdentifier> identifiers = new java.util.HashMap();
	
	private static boolean multipleOwnershipAllowed;
	
	public static void setMultipleOwnershipAllowed(boolean multipleOwnershipAllowed) {
		MockSerial.multipleOwnershipAllowed = multipleOwnershipAllowed;
	}
	
	public static boolean isMultipleOwnershipAllowed() {
		return multipleOwnershipAllowed;
	}
	
	public static void setIdentifier(String portName, CommPortIdentifier identifier) {
		identifiers.put(portName, identifier);
	}

	public static CommPortIdentifier getIdentifier(String portName) {
		return identifiers.get(portName);
	}

	public static void init() {
		SerialClassFactory.init("serial.mock"); // FIXME make serial mock a separate maven package, include it as a test dependency, and possibly make the serial package attempt to load it before any other package
		assert(SerialClassFactory.getInstance().getSerialPackageName().equals("serial.mock"));
	}
	
	public static void reset() {
		clearIdentifiers();
		init();
	}

	public static void clearIdentifiers() {
		identifiers.clear();
	}
	
	public static Map<String, CommPortIdentifier> getMock() {
		return identifiers;
	}

	public static Enumeration getPortIdentifiers() {
		return new IteratorEnumeration(identifiers.values());
	}
}

class IteratorEnumeration implements Enumeration {
	private final Iterator i;
    public IteratorEnumeration(Iterable iterable) {
        this.i = iterable.iterator();
    }

    public boolean hasMoreElements() {
    	return i.hasNext();
    }
    
    public Object nextElement() {
    	return i.next();
    }
}
