package chat.model;

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
		this.joke = "What did the ghost eat for dinner?";// answer "Spooketi"
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
		responseList.add("wtf?");
		responseList.add("*Jumps out window*");
		responseList.add("1v1 me IRL");
		responseList.add("IT'S TIME TO D-D-DUEL!!!");
		responseList.add(0,"Hello");
		responseList.add("Sonic R is the best racing game, no doubts about it");
		responseList.add("Do you like jazz?");
		responseList.add(":D");
		
		
		spookyList.add("2spooky4me");
		spookyList.add("Halloween is just cosplay for normies");
		spookyList.add("*hyperrealistic eyes bleeds hyperreleastic blood*");
		spookyList.add("BEN DROWNED");
		spookyList.add("spoOoOoOky");
		spookyList.add("spoopy");
		spookyList.add("Whoa! I'm in Undertale!");
		spookyList.add("You're in for a bad time");
		spookyList.add("Look! It's the Great Pumpkin!");
		spookyList.add(0,"Halloween");

	}

	public Chatbot(String userInput)
	{
		content = userInput;
	}

	public void askName()
	{

	}

	public String processText(String userText)
	{
		String answer = "";

		answer += "You said: \"" + userText + "\"";
		answer += "\nChatbot says: \"" + userText +"\"";

		return answer;
	}
	
	public boolean legitimacyChecker(String input)
	{
		boolean legit = true;
		
		if(input == null)//input can't be null
		{
			legit = false;
		}
		else if(input.trim().length() < 2)//input can't be less than two chars and can't be empty spaces
		{
			legit = false;
		}
		else if(input.contains("sdf") || input.contains("jkl") || input.contains("cvb"))//input can't be keyboard smash (statement contains common smash sequences)
		{
			legit = false;
		}
		return legit;
	}

	// --[GET]--
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

	public ArrayList<String> getResponseList()
	{
		return responseList;
	}
	
	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}

	// --[SET]--
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
