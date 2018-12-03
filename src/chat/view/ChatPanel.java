package chat.view;

import chat.controller.ChatController;
import javax.swing.*;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	public ChatPanel(ChatController appController)
	{
		super(); 
		
		this.appController = appController;
		appLayout = new SpringLayout();
		chatButton = new JButton("<Button>");
		inputField = new JTextField();
		chatArea = new JTextArea();
		chatPane = new JScrollPane();
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupLayout()
	{
		//INSERT CODE DUMP HERE
	}
	
	private void setupListeners()
	{
	
	}
	
	private void setupScrollPane()
	{
		
	}
}
