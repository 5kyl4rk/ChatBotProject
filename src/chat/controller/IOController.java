package chat.controller;

import java.util.Calendar;
import java.util.Scanner;
import java.io.IOException; //java.io.* contains useful Classes for input/output
import java.io.File;
import java.io.PrintWriter;

public class IOController
{
	//static means that it only performs a single action, used for utilities
	public static void saveText(ChatController app, String path, String textToSave)
	{
		try 
		{
			//creates a file name using the date and time created
			String filename = path;
			Calendar date = Calendar.getInstance();
			filename += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH) + " ";
			filename += date.get(Calendar.HOUR) + "-" +date.get(Calendar.MINUTE);
			filename += " chatbot save.txt";
			
			//makes a new file using that name
			File saveFile = new File(filename);
			Scanner textScanner = new Scanner(textToSave);
			PrintWriter saveText = new PrintWriter(saveFile);
			
			//writes information to file
			while(textScanner.hasNext())
			{
				String currentLine = textScanner.nextLine();
				saveText.println(currentLine);
			}
			
			//closes Scanner and Writer to prevent leaks
			textScanner.close();
			saveText.close();
			
			
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
	}
	
	public static String loadfile(ChatController app, String path)
	{
		String contents = "";
		
		try
		{
			File saveFile = new File(path);
			Scanner fileScanner;
			if(saveFile.exists())
			{
				fileScanner = new Scanner(saveFile);
				while(fileScanner.hasNext())
				{
					contents += fileScanner.nextLine() + "\n";
				}
				fileScanner.close();
			}
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
		return contents;
	}
	
	
}
