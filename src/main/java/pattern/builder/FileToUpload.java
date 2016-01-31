package pattern.builder;

public class FileToUpload {
	private final String fileName; // required
	private final String contentMimeType; // required
	private final byte[] fileContent; // optional
	private final String locale; // optional
	private final String existingFileIdToUpdate; // optional
	private final Boolean isPublicAvailable;
	private final Long fileSize;

	private FileToUpload(Builder builder) {
		this.fileName = builder.fileName;
		this.contentMimeType = builder.contentMimeType;
		this.fileContent = builder.fileContent;
		this.locale = builder.locale;
		this.existingFileIdToUpdate = builder.existingFileIdToUpdate;
		this.isPublicAvailable = builder.isPublicAvailable;
		this.fileSize = builder.fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public String getContentMimeType() {
		return contentMimeType;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public String getLocale() {
		return locale;
	}

	public String getExistingFileIdToUpdate() {
		return existingFileIdToUpdate;
	}

	public Boolean getIsPublicAvailable() {
		return isPublicAvailable;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public static class Builder {
		private final String fileName; // required
		private final String contentMimeType; // required
		private byte[] fileContent; // optional
		private final String locale; // optional
		private String existingFileIdToUpdate; // optional
		private Boolean isPublicAvailable;
		private Long fileSize;

		public Builder(String fileName, String contentMimeType, String locale) {
			this.fileName = fileName;
			this.contentMimeType = contentMimeType;
			this.locale = locale;
		}

		public Builder fileContent(byte[] fileContent) {
			this.fileContent = fileContent;
			return this;
		}

		public Builder existingFileIdToUpdate(String existingFileIdToUpdate) {
			this.existingFileIdToUpdate = existingFileIdToUpdate;
			return this;
		}

		public Builder isPublicAvailable(Boolean isPublicAvailable) {
			this.isPublicAvailable = isPublicAvailable;
			return this;
		}

		public Builder fileSize(Long fileSize) {
			this.fileSize = fileSize;
			return this;
		}
		
		public FileToUpload build() {
			if (fileName == null) {
				throw new IllegalArgumentException("Missing file name");
			}
			if (contentMimeType == null) {
				throw new IllegalArgumentException("Missing content mime type");
			}
			if (locale == null) {
				throw new IllegalArgumentException("Missing locale");
			}
			if (fileContent == null && fileSize == null) {
				throw new IllegalArgumentException("File content or fileSize should be specified");
			}
			if (fileContent != null && fileSize != null) {
				if (fileSize != fileContent.length) {
					throw new IllegalArgumentException("File size and file content length is not equal ");
				}
			}
			return new FileToUpload(this);
		}
	}
}
