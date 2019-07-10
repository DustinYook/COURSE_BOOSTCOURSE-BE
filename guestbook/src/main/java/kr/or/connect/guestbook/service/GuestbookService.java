package kr.or.connect.guestbook.service;

import java.util.List;
import kr.or.connect.guestbook.dto.Guestbook;

public interface GuestbookService 
{
	public static final Integer LIMIT = 5;
	public List<Guestbook> getGuestbooks(Integer start);
	public int deleteGuestbook(Long id, String ip); // id에 해당 삭제
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public int getCount();
	
	// 방명록 정보를 페이지 별로 읽어오기
	// 페이징 처리를 위해서 전체 건 수 구하기
	// 방명록 저장하기
}