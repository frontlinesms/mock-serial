package serial.mock;

import java.io.InputStream;
import java.io.OutputStream;

public interface SerialPortHandler {
	InputStream getInputStream();
	OutputStream getOutputStream();
}
