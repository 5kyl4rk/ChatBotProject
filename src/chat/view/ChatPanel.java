package chat.view;

import chat.controller.ChatController;
import javax.swing.*;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JButton chatButton;
	private JButton CheckerButton;
	private JButton LoadButton;
	private JButton SaveButton;
	private JTextField ChatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	public ChatPanel(ChatController appController)
	{
		super(); 
		
		this.appController = appController;
		appLayout = new SpringLayout();
		chatButton = new JButton("<Button>");
		ChatField = new JTextField();
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
