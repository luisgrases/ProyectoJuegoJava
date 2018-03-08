package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
	
	private static final Charset ENCODING = StandardCharsets.UTF_8;
	
	static String[] readTextFile(String relativePath) throws IOException {
	 String filePath = new File("").getAbsolutePath();
	 Path path = Paths.get(filePath.concat(relativePath));
	 return (String[]) Files.readAllLines(path, ENCODING).toArray(new String[0]);
  }
}
