package controller;
import javax.swing.JOptionPane;

import model.Chatbot;

public class ChatController
{
	private Chatbot simpleBot;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
		
	}
	
	public void start()
	{	
		String userInput = "";
		boolean leaveChat = false;
		while(!leaveChat)
		{
			userInput = JOptionPane.showInputDialog(null, "...");
			if(userInput.equalsIgnoreCase("quit"))
			{
				leaveChat = true;
			}
		}
		
	}
	
	public String interactWithChatbot(String userInput)
	{
		return null;
	}

}
