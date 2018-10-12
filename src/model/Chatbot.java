package model;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Chatbot
{
	private ArrayList<String> responseList;
	private ArrayList<String> spookyList = new ArrayList<String>();
	private String content = "";
	private String currentUser = "";
	private String joke = "";
	
	public Chatbot()
	{
		responseList = new ArrayList<String>();
	
	}
	
	public Chatbot(String userInput)
	{
		
	}
	
	public void askName()
	{
		String userInput = JOptionPane.showInputDialog(null, "Hello, I'm simpleBot, what's your name?");
		this.setCurrentUser(userInput);
	}
	//--[GET]--
	public String getContent()
	{
		return content;
	}
	
	public String getCurrentUser()
	{
		return currentUser;
	}
	
	public String getJoke()
	{
		return joke;
	}
	
	//--[SET]--
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public void setJoke(String joke)
	{
		this.joke = joke;
	}
	
	public void setCurrentUser(String userName)
	{
		currentUser = userName;
	}
	
}
