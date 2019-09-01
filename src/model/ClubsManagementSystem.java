package model;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
*<b>Description:</b> The class ClubsManagementSystem in the package model.<br>
*@author Johan Giraldo.
*/

public class ClubsManagementSystem {

//Attributes

	private ArrayList<Club> clubs;

//Constructor

	/**
	*<b>Description:</b> The constructor of the class ClubsManagementSystem.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*/

	public ClubsManagementSystem(){

		clubs = new ArrayList<Club>();
		loadClubs();
	}

	public void addClub(String id, String name, String creationDate, String petType){

		clubs.add(new Club(id, name, creationDate, petType));
	}
	
	/**
	 *<b>Description:</b> This method allows clubs to be loaded by reading the attributes that were saved in a text file and rebuilding them<br>
	 *<b>Pre:</b> The folder "data" with the program's data must exist.<br>
	 *<b>Post:</b> The clubs are rebuilt.<br>
	 */
	
	public void loadClubs(){
		
		File folder;
		String[] paths;
		String[] attributes;
		FileReader file;
		BufferedReader reader;
		String line;
		
		try{
			
			folder = new File("data/");
			paths = folder.list();
			
			for(String p : paths){
				
				file = new FileReader("data/" + p + "/" + p + ".txt");
				reader = new BufferedReader(file);
				attributes = new String[4];
				
				for(int i = 0; (line = reader.readLine()) != null; i++){
					
					attributes[i] = line;
				}
				
				addClub(attributes[0], attributes[1], attributes[2], attributes[3]);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Loading error");
		}
		catch(IOException e){
			System.out.println("Loading error");
		}
	}
}
