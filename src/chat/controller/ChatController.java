package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;

import java.util.Random;

public class ChatController
{
	private Chatbot simpleBot;

	public ChatController()
	{
		simpleBot = new Chatbot("cats");

	}

	public void start()
	{
		//debugBot();
	
		String userInput = "Hi!";
		while (!simpleBot.getLeaveChat())
		{	
			userInput = interactWithChatbot(userInput);
			
		}

	}
	
	/**
	 * playing around with String methods
	 */
	public void debugBot()
	{
		Random pickRandom = new Random();
		String userInput = "";
		boolean leaveChat = false;
		String startup = "Hello! I'm DebugBot, enter a word and I'll tell you some information about it using methods found in the 'String' Class :)";
		String response;
		response = startup;
		while (!leaveChat)
		{
			userInput = JOptionPane.showInputDialog(null, response);
			if(userInput == null || userInput.trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Sorry but I can't do much if you don't enter anything");
			}
			else if (userInput.equalsIgnoreCase("quit"))
			{
				JOptionPane.showMessageDialog(null, "See ya!");
				leaveChat = true;
			}
			else
			{
				int indexBot = pickRandom.nextInt(userInput.length());
				
				String trimStatus = "\"" + userInput.trim() +"\"";
				if(userInput.equalsIgnoreCase(userInput.trim()))
				{
					trimStatus = "Nothing ;3";
				}
				String lengthStatus = "The length of this String is " + userInput.length() + " characters long";
				String charAtStatus = "The character in index " + indexBot + " is '" + userInput.charAt(indexBot)+"'";
				String upper = userInput.toUpperCase();
				String lower = userInput.toLowerCase();
				
				String subStatus; 
				int subIndex1 = pickRandom.nextInt(userInput.length());
				int subIndex2 = pickRandom.nextInt(userInput.length());
				String subIndexParam;
				if(subIndex1 == subIndex2)
				{
					subIndexParam = Integer.toString(subIndex1);
					subStatus = userInput.substring(subIndex1);
					
				}
				else if(subIndex1 > subIndex2)
				{
					subIndexParam = subIndex2 + ", " + subIndex1;
					subStatus = userInput.substring(subIndex2, subIndex1);
				}
				else
				{
					subIndexParam = subIndex1 + ", " + subIndex2;
					subStatus = userInput.substring(subIndex1, subIndex2);
				}
				response = "[DEBUG'S REPORT]\n[String: \"" + userInput +"\"]\n" + "[.length()]: " + lengthStatus +"\n"
						+ "[.charAt()]: " + charAtStatus + "\n" + "[.trim()]: "+ trimStatus + "\n" +"[.toUpperCase()]: \""
						+ upper + "\"\n" + "[.toLowerCase()]: \"" + lower + "\"\n" + "[.substring("+subIndexParam+")]: \"" + subStatus + "\"\n"
						+ "[.indexOf("+subStatus+")]: " + "\"" + subStatus + "\" starts at index " + userInput.indexOf(subStatus);
				
			}

		}
	}

	public String interactWithChatbot(String text)
	{
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, text);
		
		output = simpleBot.processText(userResponse);
		
		return output;
	}
	
	public String useChatbotCheckers(String input)
	{
		String output = "";
		if(simpleBot.spookyChecker(input)) 
		{
			output = "Happy Halloween bois";
		}
		return output;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}

	/**
	 * Wraps String to fit vertically
	 * 
	 * 
	 * @param sample
	 *            the String you want to format
	 * @return String that is vertically formatted
	 */
	public String fitString(String sample)
	{
		return fitString(sample, 140, 0);
	}

	/**
	 * Wraps String to fit vertically
	 * 
	 * 
	 * @param sample
	 *            The String you want to format
	 * @param characterLength
	 *            How many character per line until split (Default: 140 characters)
	 * @return String that is vertically formatted
	 */
	public String fitString(String sample, int characterLength)
	{
		return fitString(sample, characterLength, 0);

	}

	/**
	 * Wraps String to fit in column rather than across the screen
	 * 
	 * @param sample
	 *            The String you want to format
	 * @param characterLength
	 *            How long the String should go for each line (Default: 140
	 *            characters)
	 * @param splitType
	 *            Formatting type: 1 = split text with hyphen, 2 = splits text with
	 *            no format, 0 (default) = new line after word ends
	 * @return String that's vertically arranged
	 */
	public String fitString(String sample, int characterLength, int splitType)
	{
		String smallString = "";
		String splitString = "";
		int counter = 0;

		if (splitType == 1)
		{
			splitString = "-\n";// split text with hyphen
		}
		else if (splitType == 2)
		{
			splitString = "\n";// splits text
		}
		else
		{
			splitString = "\n";// splits text after word ends
		}

		if (characterLength <= 0)
		{
			characterLength = 140;
		}

		for (int index = 0; index < sample.length(); index += 1)
		{
			if (splitType == 1 || splitType == 2)
			{
				if (counter == characterLength && !sample.substring(index, index + 1).equals(" "))
				{
					smallString += splitString;
					counter = 0;
					smallString += sample.substring(index, index + 1);
				}
				else if (counter == characterLength && sample.substring(index, index + 1).equals(" "))
				{
					smallString += "\n";
					counter = 0;
				}
				else
				{
					counter++;
					smallString += sample.substring(index, index + 1);
				}

			}
			else if (splitType != 1 && splitType != 2)
			{
				if (sample.substring(index, index + 1).equals(" ") && counter > characterLength)
				{
					smallString += splitString;
					counter = 0;
				}
				else
				{
					smallString += sample.substring(index, index + 1);
					counter++;
				}
			}

		}

		return smallString;

	}

	
}
