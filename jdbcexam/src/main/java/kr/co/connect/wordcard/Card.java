package kr.co.connect.wordcard;

public class Card 
{
	private String word;
	private String description;
	
	public Card(){ }
	
	public Card(String word, String description) 
	{
		super();
		this.word = word;
		this.description = description;
	}
	
	public String getWord() { return word; }
	public void setWord(String word) { this.word = word; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	@Override
	public String toString() 
	{
		return "Role [roleId=" + word + ", description=" + description + "]";
	}
}