package serial.mock;

import java.util.Map;

import serial.SerialClassFactory;

import static org.mockito.Mockito.*;

/**
 * This class is not thread-safe and should not be used in concurrent tests. FIXME make sure the POM is not set to run concurrent unit tests.
 */
public class MockSerial {
	@SuppressWarnings("unchecked")
	private static final Map<String, CommPortIdentifier> identifiers = mock(Map.class);
	
	public static void setIdentifier(String portName, CommPortIdentifier identifier) {
		when(identifiers.get(portName)).thenReturn(identifier);
	}

	public static CommPortIdentifier getIdentifier(String portName) {
		return identifiers.get(portName);
	}

	public static void init() {
		SerialClassFactory.init("serial.mock"); // FIXME make serial mock a separate maven package, include it as a test dependency, and possibly make the serial package attempt to load it before any other package
		assert(SerialClassFactory.getInstance().getSerialPackageName().equals("serial.mock"));
	}

	public static void clearIdentifiers() {
		when(identifiers.get(anyString())).thenReturn(null);
	}
	
	public static Map<String, CommPortIdentifier> getMock() {
		return identifiers;
	}
}
