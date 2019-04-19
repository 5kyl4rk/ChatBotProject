package chat.view;

import chat.controller.ChatController;
import chat.controller.IOController;
import chat.utilities.TextPrompt;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
	private JButton tweetButton;
	private JButton searchTwitterButton;
	
	private ImageIcon saveIcon;
	
	private JTextField chatField;
	private TextPrompt fieldPrompt;
	private JTextArea chatArea;
	private JPanel buttonPanel;
	private JScrollPane chatPane;
	private boolean firstChat;
	private String recentPath;
	private String imagePath;
	
	
	public ChatPanel(ChatController appController)
	{
		super(); 
		
		this.appController = appController;
		
		imagePath = "/chat/view/images/chat.png";
		appLayout = new SpringLayout();
		chatButton = new JButton("Chat");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		checkerButton = new JButton("Check");
		resetButton = new JButton("Clear");
		tweetButton = new JButton("Send Tweet");
		searchTwitterButton = new JButton("Search Twitter");
		
		//saveIcon = new ImageIcon(getClass().getResource(imagePath + "save.png"));
		
		buttonPanel = new JPanel(new GridLayout(1,0));
		appLayout.putConstraint(SpringLayout.SOUTH, buttonPanel, -84, SpringLayout.SOUTH, this);
		
		chatField = new JTextField(50);
		fieldPrompt = new TextPrompt("Talk to bot here", chatField);
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();
		
	
		firstChat = true;
		recentPath = "./saves"; //default path is a folder called "saves" located with the project
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
		setupButtonPanel();
	}
	
	private String getPath(String choice)
	{
		String path = recentPath;
		int result = -99;
		JFileChooser fileChooser = new JFileChooser(path);
		//JOptionPane.showMessageDialog(this, "path: "+ path +"\nrecentPath:" + recentPath);
		if(choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();//path is the directory folder
				
				recentPath = fileChooser.getCurrentDirectory().getPath();//saves path to use for later
				
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
				recentPath = fileChooser.getCurrentDirectory().getPath();
			}
		}
		//JOptionPane.showMessageDialog(this, "path: "+ path +"\nrecentPath:" + recentPath);
		return path;
	}

	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024,768));
		this.setBackground(new Color(2, 70, 152));
		chatArea.setBackground(new Color(198, 199, 201));
		this.add(chatPane);
		buttonPanel.setPreferredSize(new Dimension(900,150));
		buttonPanel.setBackground(Color.CYAN);
		this.add(buttonPanel);
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
		appLayout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, chatPane);
		
	}
	
	private void setupButtonPanel()
	{
		buttonPanel.add(chatButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(checkerButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(tweetButton);
		buttonPanel.add(searchTwitterButton);
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
				if(firstChat)
				{
					chatArea.setText("");
					firstChat = false;
				}
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText = IOController.loadfile(appController, getPath("load"));
				chatArea.setText("Chat Loaded!\n" + loadedText);
				firstChat = false;
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String chatText = chatArea.getText();
				String path = getPath("save");
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat saved!");
				firstChat = true;
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
				chatArea.setText("Chat Area");
				firstChat = true;
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
