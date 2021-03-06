package pattern;

import pattern.builder.FileToUpload;

public class UploadHandler {
	public void doUpload(FileToUpload fileToUpload) {
		if (fileToUpload.getFileName() == null) {
			throw new IllegalArgumentException("Missing file name");
		}
		if (fileToUpload.getContentMimeType() == null) {
			throw new IllegalArgumentException("Missing content mime type");
		}
		if (fileToUpload.getLocale() == null) {
			throw new IllegalArgumentException("Missing locale");
		}
		if (fileToUpload.getFileContent() == null && fileToUpload.getFileSize() == null) {
			throw new IllegalArgumentException("File content or fileSize should be specified");
		}
		if (fileToUpload.getFileContent() != null && fileToUpload.getFileSize() != null) {
			if (fileToUpload.getFileSize() != fileToUpload.getFileContent().length) {
				throw new IllegalArgumentException("File size and file content length is not equal ");
			}
		}
	}
}
