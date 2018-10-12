package model;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Chatbot
{
	private ArrayList<String> responseList = new ArrayList<String>();
	private ArrayList<String> spookyList = new ArrayList<String>();
	private String content = "";
	private String currentUser = "";
	private String joke = "";
	
	public Chatbot()
	{
		
	}
	
	public Chatbot(String userInput)
	{
		
	}
	
	public String askName()
	{
		
		return null;
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
