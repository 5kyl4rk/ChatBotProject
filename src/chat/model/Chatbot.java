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
	private String response;
	private boolean leaveChat;

	public Chatbot()
	{
		this.joke = "What did the ghost eat for dinner?";// answer "Spooketi"
		this.content = new String("banana");
		this.currentUser = "notHuman";
		this.response = "Hi!";
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		this.leaveChat = false;
		buildTheLists();

	}
	/**
	 * 
	 * @param sample
	 */
	public Chatbot(String sample)
	{
		this.joke = "What did the ghost eat for dinner?";// answer "Spooketi"
		this.content = sample;
		this.currentUser = "notHuman";
		this.response = "Hi!";
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		this.leaveChat = false;
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
		responseList.add("Jake was here");
		
		
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

	public void askName()
	{

	}

	public String processText(String userText)
	{
		String answer;
		
		if(legitimacyChecker(userText))
		{
			userText = userText.trim();
			if(userText.equalsIgnoreCase("quit"))
			{
				JOptionPane.showMessageDialog(null, "See ya!");
				this.leaveChat = true;
			}
			answer = "You said: \"" + userText + "\"";
			answer += "\nChatbot says: \"" + userText +"\"";
			
			if(contentChecker(userText))
			{
				answer = "You said the special words";
			}
			if(spookyChecker(userText))
			{
				answer = "You're scaring me";
			}
			
			
		}
		else
		{
			answer = "You said: NOTHING";
			answer += "\nChatbot says: \"lol what was that?\"";
		}
		
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
		else if(input.contains("sdf") || input.contains("jkl") || input.contains("cvb") || input.contains("sfk"))//input can't be keyboard smash (statement contains common smash sequences)
		{
			legit = false;
		}
		return legit;
	}
	
	public boolean spookyChecker(String input)
	{
		boolean isSpooky = false;
		for(String currentString : spookyList)
		{
			if(input.indexOf(currentString) >= 0)
			{
				isSpooky = true;
			}
		}
		return isSpooky;
	}
	/**
	 * checks to see if content appears isolated in a given input
	 * @param phrase the original string that you want to check to see if it contains content
	 * @return a boolean value determining whether or not content appears in the phrase
	 */
	public boolean contentChecker(String phrase)
	{
		boolean isContent = false;
		/**
		 * checks first to see if the phrase by itself is the same as content
		 */
		if(phrase.equals(content))
		{
			isContent = true;
		}
		/**
		 * else, checks to see if the phrase at least contains content
		 */
		else if(phrase.contains(content))
		{
			int contentLength = content.length();
			int contentIndex = phrase.indexOf(content);//position of where content is located
			//if content is found at the beginning of the phrase
			if(contentIndex == 0)
			{
				//check to see if the word is by itself	
				if(phrase.substring(0,contentLength+1).equals(content+" "))
				{
					isContent = true;
				}
			}
			//if content is found someplace other than the beginning
			else if(contentIndex > 0)
			{
				/**
				 * checks if content is located at the last possible index
				 * (Ex: content = "cats"        content.length() = 4
				 * 		phrase = "I like cats"  phrase.length() = 11
				 * 
				 * 		in order for content to be the last word, it's index
				 * 		would have to be '7' because that's the last possible index
				 * 		it can fit in without exceeding the phrase length)
				 */
				if(contentIndex == (phrase.length() - contentLength))
				{
					//checks to see if the index before the word is a space since it has to be by itself
					if(phrase.substring(contentIndex -1).equals(" " + content))
					{
						isContent = true;
					}
				}
				//else checks to see if the index before and after the word has a space
				else if(phrase.substring(contentIndex - 1,contentIndex + contentLength + 1).equals(" " + content + " "))
				{
					isContent = true;
				}
			}
		}
		
		return isContent;
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
	
	public String getResponse()
	{
		return response;
	}

	public ArrayList<String> getResponseList()
	{
		return responseList;
	}
	
	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}
	
	public boolean getLeaveChat()
	{
		return leaveChat;
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
	
	public void setResponse(String response) 
	{
		this.response = response;
	}

	public void setCurrentUser(String userName)
	{
		currentUser = userName;
	}

}
