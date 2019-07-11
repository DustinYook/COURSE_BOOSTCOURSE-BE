// 헤더의 정보를 담아줄 클래스 
package kr.or.connect.guestbook.argumentresolver;

import java.util.HashMap;
import java.util.Map;

public class HeaderInfo 
{
	// Map을 직접 사용할 수 없기 때문에 필드로 Map을 하나 가짐
	private Map<String, String> map;
	
	public HeaderInfo()
	{
		map = new HashMap<String, String>(); // Map생성
	}
	
	public void put(String name, String value)
	{
		map.put(name, value); // 값 넣음
	}
	
	public String get(String name)
	{
		return map.get(name); // 값 꺼냄
	}
}