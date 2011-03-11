package serial.mock;

import java.io.InputStream;
import java.io.OutputStream;

public class SerialPort {
	/** RTS/CTS flow control on input. */
	public static final int FLOWCONTROL_RTSCTS_IN = 0;
	/** 8 data bit format. */
	public static final int DATABITS_8 = 0;
	/** Number of STOP bits - 1. */
	public static final int STOPBITS_1 = 0;
	/** No parity bit. */
	public static final int PARITY_NONE = 0;
	/** RTS/CTS flow control on output. */
	public static final int FLOWCONTROL_RTSCTS_OUT = 0;
	
	private final SerialPortHandler handler;
	
	public SerialPort(SerialPortHandler handler) {
		this.handler = handler;
	}
	
	public void addEventListener(SerialPortEventListener listener) {
	}	
	
	public void removeEventListener() {
	}
	
	public InputStream getInputStream() { return handler.getInputStream(); }
	public OutputStream getOutputStream() { return handler.getOutputStream(); }
	
	public void notifyOnDataAvailable(boolean b) {}
	public void setFlowControlMode(int i) {}
	public void setSerialPortParams(int a, int b, int c, int d) {}
	public void setInputBufferSize(int i) {}
	public void setOutputBufferSize(int i) {}
	public void enableReceiveTimeout(int i) {}
	public void notifyOnCTS(boolean b) {}
	
	public void close() {
		// TODO close the streams after this and stop them working!
	}
}
