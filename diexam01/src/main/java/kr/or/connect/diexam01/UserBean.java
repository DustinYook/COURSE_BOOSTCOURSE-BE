package kr.or.connect.diexam01;

public class UserBean 
{
	private String name;
	private int age;
	private boolean male;
	
	public UserBean() { }
	
	public UserBean(String name, int age, boolean male) 
	{
		super();
		this.name = name;
		this.age = age;
		this.male = male;
	}

	/** Name Property */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	/** Age Property */
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	/** Male Property */
	public boolean isMale() { return male; }
	public void setMale(boolean male) { this.male = male; }
}