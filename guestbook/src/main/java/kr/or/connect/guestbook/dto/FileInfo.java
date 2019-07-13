package kr.or.connect.guestbook.dto;

public class FileInfo 
{
	private Long fileId;
	private String fileName;
	private String saveName;
	private String contentType;
	private Long fileLength;
	
	public Long getFileId() { return fileId; }
	public void setFileId(Long fileId) { this.fileId = fileId; }
	
	public String getFileName() { return fileName; }
	public void setFileName(String fileName) { this.fileName = fileName; }
	
	public String getSaveName() { return saveName; }
	public void setSaveName(String saveFileName) { this.saveName = saveFileName; }
	
	public String getContentType() { return contentType; }
	public void setContentType(String contentType) { this.contentType = contentType; }
	
	public Long getFileLength() { return fileLength; }
	public void setFileLength(Long fileLength) { this.fileLength = fileLength; }
	
	@Override
	public String toString() 
	{
		return "FileInfo [fileId=" + fileId + ", fileName=" + fileName + ", saveName=" + saveName
				+ ", contentType=" + contentType + ", fileLength=" + fileLength + "]";
	}
}