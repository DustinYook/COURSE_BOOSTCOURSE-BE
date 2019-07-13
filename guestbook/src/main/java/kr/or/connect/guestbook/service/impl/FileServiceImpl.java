package kr.or.connect.guestbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook.dao.FileInfoDao;
import kr.or.connect.guestbook.dto.FileInfo;
import kr.or.connect.guestbook.service.FileService;

@Service // 서비스로 등록
public class FileServiceImpl implements FileService // 서비스 인터페이스 구현
{
	@Autowired // 의존성 주입
	FileInfoDao fileInfoDao; // DAO를 사용하기 위함
	
	@Override
	@Transactional(readOnly = false) // @Transactional : 메소드 전체가 성공이 되야지만 commit, 아니면 rollback
	public FileInfo addFileInfo(FileInfo fileInfo) 
	{
		// DB의 file_info테이블에 삽입
		Long fileId = fileInfoDao.insert(fileInfo);
		fileInfo.setFileId(fileId);
		
		return fileInfo;
	}

	@Override
	@Transactional
	public List<FileInfo> getFileInfos() 
	{
		List<FileInfo> list = fileInfoDao.selectAll(); 
		return list;
	}

	@Override
	@Transactional
	public FileInfo getFileInfo(Long fileId) 
	{
		FileInfo fileInfo = fileInfoDao.selectById(fileId);
		return fileInfo;
	}
}