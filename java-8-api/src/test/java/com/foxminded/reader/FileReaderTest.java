package com.foxminded.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class FileReaderTest {
	
	FileReader fr = new FileReader();
	@Test
	void shouldVerifyCorrectedReturnedBufferedString() throws IOException {
		String excpected = "test\n";
		ByteArrayInputStream testByteArrayInputStream = new ByteArrayInputStream("test".getBytes());
		assertEquals (excpected, fr.getBufferedString(testByteArrayInputStream));
	}
	@Test
	void shouldVerifyCorrectFirstLineFromStreamReturned() throws IOException, URISyntaxException {
		Optional <String> expected = Optional.of(new String("Hello world!"));
		assertEquals(expected, fr.getStreamFromFile("test.txt").findFirst());
	}
	
	

}
