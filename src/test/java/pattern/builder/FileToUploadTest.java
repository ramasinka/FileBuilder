package pattern.builder;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import pattern.builder.FileToUpload;

public class FileToUploadTest {
	private static FileToUpload fileToUpload;

	@Test
	public void checkBuilderValues() {
		long size = 3;
		byte[] fileContent = { 1, 2, 3 };
		fileToUpload = new FileToUpload.Builder("fileName", "contentMimeType", "locale").fileSize(size)
				.fileContent(fileContent).build();
		assertEquals(fileToUpload.getFileName(), "fileName");
		assertEquals(fileToUpload.getContentMimeType(), "contentMimeType");
		assertEquals(fileToUpload.getLocale(), "locale");
	}

	@Test(expected = IllegalArgumentException.class)
	public void missingFileContentAndFileSize() {
		fileToUpload = new FileToUpload.Builder("fileName", "contentMimeType", "locale").build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void notEqualFileContentLengthAndFileSize() {
		long size = 3;
		byte[] fileContent = { 1, 2, 3, 4 };
		fileToUpload = new FileToUpload.Builder("fileName", "contentMimeType", "locale").fileSize(size)
				.fileContent(fileContent).build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void missingFileName() {
		fileToUpload = new FileToUpload.Builder(null, "contentMimeType", "locale").build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void missingContentMimeType() {
		fileToUpload = new FileToUpload.Builder("fileName", null, "locale").build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void missingLocale() {
		fileToUpload = new FileToUpload.Builder("fileName", "contentMimeType", null).build();
	}
}
