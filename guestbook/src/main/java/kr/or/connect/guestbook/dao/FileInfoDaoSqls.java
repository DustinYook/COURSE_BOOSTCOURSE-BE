package kr.or.connect.guestbook.dao;

public class FileInfoDaoSqls 
{
	public static final String SELECT_BY_ID = "SELECT file_id, file_name, save_name, content_type, file_length FROM file_info WHERE file_id = :file_id ORDER BY file_id";
	public static final String SELECT_ALL = "SELECT file_id, file_name, save_name, content_type, file_length FROM file_info ORDER BY file_id";
}