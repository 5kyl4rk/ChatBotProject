package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton resetButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	public ChatPanel(ChatController appController)
	{
		super(); 
		
		this.appController = appController;
		
		appLayout = new SpringLayout();
		chatButton = new JButton("Chat");
		saveButton = new JButton("Save");
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 336, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -19, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -176, SpringLayout.EAST, this);
		loadButton = new JButton("Load");
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 168, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -19, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -80, SpringLayout.WEST, saveButton);
		checkerButton = new JButton("Check Text");
		resetButton = new JButton("Clear");
		appLayout.putConstraint(SpringLayout.NORTH, resetButton, 16, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, resetButton, 100, SpringLayout.EAST, checkerButton);
		
		chatField = new JTextField("Talk to bot here", 50);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 91, SpringLayout.SOUTH, chatField);
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();
	
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(600, 600));
		this.setBackground(new Color(2, 70, 152));
		chatArea.setBackground(new Color(198, 199, 201));
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(resetButton);
		this.add(chatField);
	}
	
	private void setupLayout()
	{
		//INSERT CODE DUMP HERE
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 30, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 456, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -85, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -443, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -85, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 25, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 25, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatPane);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output =  appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//do something here
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//do something cool here
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//check something here
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText("");
			}
		});
		
	}
	
	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
}
