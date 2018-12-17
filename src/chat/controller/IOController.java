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
			
			String filename = path;//gets path
			//creates a file name using the date and time created
			Calendar date = Calendar.getInstance();
			filename += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH) + " ";
			filename += date.get(Calendar.HOUR) + "-" +date.get(Calendar.MINUTE);
			filename += " chatbot save.txt";
			
			//makes a new file using that name and path
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
			File saveFile = new File(path); //retrieve file using path
			Scanner fileScanner;//scanner will read file's data
			
			if(saveFile.exists())//if file can be located...
			{
				fileScanner = new Scanner(saveFile);//use Scanner to read file
				while(fileScanner.hasNext())//while there's still more lines...
				{
					contents += fileScanner.nextLine() + "\n";//save each line and breaks it (.nextline() consumes the enter space)
				}
				fileScanner.close(); //close scanner
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
