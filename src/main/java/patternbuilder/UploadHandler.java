package patternbuilder;

public class UploadHandler {
	public void doUpload(FileToUpload fileToUpload) {
		if (fileToUpload.getFileName() == null) {
			throw new IllegalArgumentException("Missing file name");
		}
		if (fileToUpload.getContentMimeType() == null) {
			throw new IllegalArgumentException("Missingcontent mime type");
		}
		if (fileToUpload.getContentMimeType() == null) {
			throw new IllegalArgumentException("Missing locale");
		}
		if (fileToUpload.getFileContent() == null && fileToUpload.getFileSize() == null) {
			throw new IllegalArgumentException("Missing file content and filesize");
		}
		if (fileToUpload.getFileContent() != null && fileToUpload.getFileSize() != null) {
			if (fileToUpload.getFileSize() != fileToUpload.getFileContent().length) {
				throw new IllegalArgumentException("File size and file content length is not equal ");
			}
		}
	}
}
