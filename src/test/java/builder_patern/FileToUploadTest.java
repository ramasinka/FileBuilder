package builder_patern;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import patternbuilder.FileToUpload;
import patternbuilder.UploadHandler;

public class FileToUploadTest {
	private static UploadHandler uploadHandler;
	private static FileToUpload fileToUpload;

	@BeforeClass
	public static void initUploadHandler() {
		uploadHandler = new UploadHandler();
		
	}

	@Test
	public void checkFileToUploadObjectValues() {
		long size = 3;
		byte[] fileContent = { 1, 2, 3 };
		fileToUpload = new FileToUpload.Builder("fileName", "contentMimeType", "locale").fileSize(size)
				.fileContent(fileContent).build();
		uploadHandler.doUpload(fileToUpload);
		assertEquals(fileToUpload.getFileName(), "fileName");
		assertEquals(fileToUpload.getContentMimeType(), "contentMimeType");
		assertEquals(fileToUpload.getLocale(), "locale");
	}

	@Test(expected = IllegalArgumentException.class)
	public void missingFileContentAndFileSize() {
		fileToUpload = new FileToUpload.Builder("fileName", "contentMimeType", "locale").build();
		uploadHandler.doUpload(fileToUpload);
	}

	@Test(expected = IllegalArgumentException.class)
	public void notEqualFileContentLengthAndFileSize() {
		long size = 3;
		byte[] fileContent = { 1, 2, 3, 4 };
		fileToUpload = new FileToUpload.Builder("fileName", "contentMimeType", "locale").fileSize(size)
				.fileContent(fileContent).build();
		uploadHandler.doUpload(fileToUpload);
	}
}
