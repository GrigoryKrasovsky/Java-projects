package com.foxminded.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileReaderTest {
	
	FileReader fr = new FileReader();
	@Test
	void shouldVerifyCorrectedReturnedBufferedString() throws IOException {
		String excpected = "test\n";
		ByteArrayInputStream testByteArrayInputStream = new ByteArrayInputStream("test".getBytes());
		assertEquals (excpected, fr.getBufferedString(testByteArrayInputStream));
	}

}
