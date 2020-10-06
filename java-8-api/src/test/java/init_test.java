import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

class init_test {
	

	@Test
	void test() {
		String excpectedData = "Hello world!";
		
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("/test.txt");
		//String data = readFromInputStream(inputStream);
	}

}
