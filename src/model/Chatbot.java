package model;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Chatbot
{
	private ArrayList<String> responseList;
	private ArrayList<String> spookyList; 
	private String content;
	private String currentUser;
	private String joke;
	
	public Chatbot()
	{
		this.joke = "What did the ghost eat for dinner?";//answer "Spooketi"
		this.content = new String("");
		this.currentUser = "notHuman";
		
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		
		buildTheLists();
	
	}
	
	private void buildTheLists()
	{
		responseList.add("Hello! How are you?");
		responseList.add("lol wut?");
		responseList.add(">w<");
		responseList.add(":'(");
		responseList.add("welp...");
		responseList.add("FeelsBadMan");
		responseList.add("¯\\_(ツ)_/¯");
		responseList.add("no u");
		
		
	}
	
	public Chatbot(String userInput)
	{
		
	}
	
	public void askName()
	{
		
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
