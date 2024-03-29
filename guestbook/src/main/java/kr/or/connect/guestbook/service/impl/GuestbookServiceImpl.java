package kr.or.connect.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook.dao.GuestbookDao;
import kr.or.connect.guestbook.dao.LogDao;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.dto.Log;
import kr.or.connect.guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService
{
	@Autowired
	GuestbookDao guestbookDao; // DAO를 사용하기 위함
	
	@Autowired
	LogDao logDao; // DAO를 사용하기 위함
	
	@Override
	@Transactional // 읽기만 하는 메소드에 붙임 : 내부적으로 readOnly로 Connection을 사용
	public List<Guestbook> getGuestbooks(Integer start) // guestbook 목록 가져옴
	{	
		// 첫 번째 인자 : 시작, 두 번째 인자 : 몇 개 
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT); 
		return list;
	}

	@Override
	@Transactional(readOnly=false) // readOnly=false로 해야 수정가능
	public int deleteGuestbook(Long id, String ip) // 방명록 삭제
	{
		int deleteCount = guestbookDao.deleteById(id);
		
		// 로그생성
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("DELETE");
		log.setRegdate(new Date());
		
		// DB의 log테이블에 삽입
		logDao.insert(log); 
		
		return deleteCount;
	}

	@Override
	@Transactional(readOnly = false) // @Transactional : 메소드 전체가 성공이 되야지만 commit, 아니면 rollback
	public Guestbook addGuestbook(Guestbook guestbook, String ip) // 방명록 삽입 - Guestbook은 컨트롤러에서 받음
	{
		guestbook.setRegdate(new Date()); // 날짜 설정
		
		// DB의 guestbook테이블에 삽입
		Long id = guestbookDao.insert(guestbook); // 로그 작성위해 ID받음
		guestbook.setId(id); // 원래는 log테이블에 반영하기 위해 존재했음
		
		// 로그생성
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("INSERT");
		log.setRegdate(new Date());
		
		// DB의 log테이블에 삽입		
		logDao.insert(log);
		
		return guestbook;
	}

	@Override
	public int getCount() // 페이징 처리 위해 전체 몇 건인지 받아옴
	{
		return guestbookDao.selectCount();
	}
}