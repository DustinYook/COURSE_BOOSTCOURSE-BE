package kr.co.connect.wordcard;

public class NoMoreQuestionException extends Exception 
{
	public NoMoreQuestionException() 
	{
		super("No question left!");
	}
	
	public NoMoreQuestionException(String message) 
	{
		super(message);
	}
}