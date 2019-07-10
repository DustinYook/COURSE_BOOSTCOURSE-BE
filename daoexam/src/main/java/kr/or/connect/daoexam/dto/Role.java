package kr.or.connect.daoexam.dto;

public class Role 
{
	private int roleId; // 반드시 케멜 표기법을 준수해야 매핑에 문제 발생하지 않음
	private String description;
	
	public int getRoleId() { return roleId; }
	public void setRoleId(int roleId) { this.roleId = roleId; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	/** DTO 객체에 값 제대로 들어있는지 확인하는데 좋음 */ 
	@Override
	public String toString() 
	{
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
}