package model;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import model.ClubNotFoundException;
import model.IllegalIdException;

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
	
//Methods
	
	/**
	 *<b>Description:</b> This method allows clubs to be loaded by reading the attributes that were saved in a text file and rebuilding them.<br>
	 *<b>Pre:</b> The folder "data" with the program's data must exist.<br>
	 *<b>Post:</b> The clubs are rebuilt.<br>
	 */
	
	public void loadClubs(){
		
		File folder;
		String[] names, attributes;
		FileReader file;
		BufferedReader reader;
		String line;
		
		try{
			
			folder = new File("data/");
			names = folder.list();
			
			for(String name : names){
				
				file = new FileReader("data/" + name + "/" + name + ".txt");
				reader = new BufferedReader(file);
				attributes = new String[4];
				
				for(int i = 0; (line = reader.readLine()) != null; i++){
					
					attributes[i] = line;
				}
				
				clubs.add(new Club(attributes[0], attributes[1], attributes[2], attributes[3]));
				reader.close();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("A loading error has occurred");
		}
		catch(IOException e){
			System.out.println("A loading error has occurred");
		}
	}
	
	/**
	 *<b>Description:</b> This method allows checking if already exist an Club with that id.<br>
	 * @param id The club's id.
	 * @return A true Boolean if there is a club with that identification and false if there is no club with that identification.
	 */
	
	public boolean checkIfExistClubWithThisId(String id){
		
		boolean exist = false;
		boolean running = true;
		
		for(int i = 0; i < clubs.size() && running; i++){
			
			if(clubs.get(i).getId().equals(id)){
				
				exist = true;
				running = false;
			}
		}
		
		return exist;
	}
	
	/**
	 *<b>Description:</b> This method allows adding clubs in the ArrayList of clubs if the club that will be added have a equals id that other club already added, the method throws an IllegalIdException.<br>
	 *@param id The club's identification.
	 *@param name The club's name.
	 *@param creationDate The club's creation date.
	 *@param petType The club's pets type.
	 * @return A message that indicates if the club was added or if the club can't be added.
	 */
	
	public String addClub(String id, String name, String creationDate, String petType){
		
		String msg = "The owner could not be added";
		
		try{
			
			if(checkIfExistClubWithThisId(id)){
				
				throw new IllegalIdException("An Club with this id already exists, please try again");
			}
			else{
				
				clubs.add(new Club(id, name, creationDate, petType));
			}
		}
		catch(IllegalIdException e){
			
			System.out.println(e.getMessage());
		}		
		
		return msg;
		
	}
	
	/**
	 *<b>Description:</b> This method allows deleting a club by the id or the name.<br> 
	 * @param arg The club's id or name;
	 * @return A message that indicates if the club was deleted or not.
	 */
	
	public String deleteClub(String arg){
		
		String msg = "The club could not be found, please try again";
		File dir;
		File[] files;
		boolean running = true;
		
		for(int i = 0; i < clubs.size() && running; i++){
			
			if(clubs.get(i).getId().equals(arg) || clubs.get(i).getName().equals(arg)){
				
				dir = new File("data/" + clubs.get(i).getId() + "/");
				files = dir.listFiles();
				
				for(File file : files){
					
					file.delete();
				}
				
				dir.delete();
				msg = "The club was deleted succesfully";
				running = false;
			}
		}
		
		return msg;
	}
	
	/**
	 *<b>Description:</b> This method allows getting a club by the id.<br>
	 * @param id The club's id.
	 * @return The club with this id.
	 */
	
	public Club getClub(String id) throws ClubNotFoundException{
		
		Club club = null;
		boolean running = true;
		
		for(int i = 0; i < clubs.size() && running; i++){
			
			if(clubs.get(i).getId().equals(id)){
				
				club = clubs.get(i);
				running = false;
			}
		}
		if(club == null){
			
			throw new ClubNotFoundException("The club could not be found, please try again");
		}
		
		return club;
	}
}
