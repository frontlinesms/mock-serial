package serial.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import serial.NoSuchPortException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CommPortIdentifierIntegrationTest {
	private CommPortIdentifier a;
	
	@Before
	public void setUp() {
		MockSerial.init();
		
		a = mock(CommPortIdentifier.class);
		MockSerial.setIdentifier("a", a);
	}
	
	@After
	public void tearDown() {
		a = null;
	}
	
	@Test
	public void testGetIdentifier() throws NoSuchPortException {
		assertEquals(a, serial.CommPortIdentifier.getPortIdentifier("a").getRealObject());
	}
	
	@Test
	public void testGetBadIdentifier() {
		try {
			serial.CommPortIdentifier.getPortIdentifier("b");
			fail("Expected no such port exception for non-existent port.");
		} catch(NoSuchPortException e) {
			// expected
		}
	}
}
