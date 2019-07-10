package kr.or.connect.mvcexam.dto;

public class User // DTO 클래스
{
	// 주의) 태그의 name속성값과 필드의 이름이 반드시 일치해야 한다 
	private String name; 
	private String email;
	private int age;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	@Override
	public String toString() // 들어있는 값들을 확인할 때 편리!
	{
		return "User [name=" + name + ", email=" + email + ", age=" + age + "]";
	}
}