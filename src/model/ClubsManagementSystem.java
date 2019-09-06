package model;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		
		FileReader file;
		BufferedReader reader;
		String[] attributes;
		String line;
		
		try{
			
			file = new FileReader("data/Clubs.txt");
			reader = new BufferedReader(file);
			attributes = new String[4];
			
			while((line = reader.readLine()) != null){
				
					attributes[0] = line;
					attributes[1] = reader.readLine();
					attributes[2] = reader.readLine();
					attributes[3] = reader.readLine();
				
				createClub(attributes);
			}
			
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.println("A loading error has occurred");
		}
		catch(IOException e){
			System.out.println("A loading error has occurred");
		}
	}
	
	/**
	 *<b>Description:</b> This method allows adding clubs already saved in Clubs.txt to the ArrayList of clubs.<br>
	 *<b>Post:</b> The club was added in the ArrayList of clubs.<br>
	 *@param attributes.
	 */
	
	public void createClub(String[] attributes){
		
		Club club;
		
		club = new Club(attributes[0], attributes[1], attributes[2], attributes[3]);
		
		clubs.add(club);
	}
	
	/**
	 *<b>Description:</b> This method allows checking if already exist an Club with that id.<br>
	 *@param id The club's id.
	 *@return A true Boolean if there is a club with that identification and false if there is no club with that identification.
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
	 *<b>Description:</b> This method allows getting the index of the club with that id.<br> 
	 *@param id The club's id.
	 *@return A whole number with the index of the club who matches with that id.
	 */
	
	public int getClubIndex(String id){
		
		int index = -1;
		boolean running = true;
		
		for(int i = 0; i < clubs.size() && running; i++){
			
			if(clubs.get(i).getId().equals(id)){
	
				index = i;
				running = false;
			}
		}
		
		return index;
	}
	
	/**
	 *<b>Description:</b> This method allows getting a club by the index.<br>
	 * @param index The index where the club is in the clubs ArrayList.
	 * @return The club with this index.
	 */
	
	public Club getClub(int index){
		
		Club club = null;
		
		club = clubs.get(index);
		
		return club;
	}
			
	/**
	 *<b>Description:</b> This method allows adding clubs in the ArrayList of clubs if the club that will be added have a equals id that other club already added, the method throws an IllegalIdException.<br>
	 *@param id The club's identification.
	 *@param name The club's name.
	 *@param creationDate The club's creation date.
	 *@param petType The club's pets type.
	 *@return A message that indicates if the club was added or if the club can't be added.
	 */
	
	public String addClub(String id, String name, String creationDate, String petType){
		
		String msg = "";
		Club club = null;
		
		try{
			
			if(checkIfExistClubWithThisId(id)){
				
				throw new IllegalIdException("An Club with this id already exists, please try again");
			}
			else{
				
				club = new Club(id, name, creationDate, petType);
				clubs.add(club);
				club.saveClub();
				msg = "The club was added successfully";
			}
		}
		catch(IllegalIdException e){
			
			System.out.print(e.getMessage());
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
		String id = null;
		
		try{
			
			id = getClubId(arg);
			
			if(id != null){
				
				deleteClubsData(id);
				deleteOwners(id);
				msg = "The was club deleted succesfully";
			}
		
		}
		catch (FileNotFoundException e){
			System.out.println("A deleting error has occurred");
		}
		catch(IOException e){
			
			System.out.println("A deleting error has occurred");
		}
		
		return msg;
	}
	
	/**
	 *<b>Description:</b> This method allows deleting the owners of the club.<br>
	 *@param id The club's id.
	 *<b>Post:</b> The .owners file was deleted.<br>
	 */
	public void deleteOwners(String id){
		
		File file;
		
		file = new File("data/" + id + ".owners");
		
		file.delete();
	}
	
	/**
	*<b>Description:</b> This method allows you to read the data in Clubs.txt and not save the club that matches the name and identification.<br>
	*@return The Clubs.txt data without the club who match with the id and the name.
	*/
	
	public void deleteClubsData(String id) throws IOException, FileNotFoundException{
		
		String data = "";
		String line = "";
		PrintWriter writer;
		FileReader file;
		BufferedReader reader;
			
			file = new FileReader("data/Clubs.txt");
			reader = new BufferedReader(file);
			
			while((line = reader.readLine()) != null){
				
				if(!line.equals(id)){
					
					data += line + "\n";
				}
				else{
					
					reader.readLine();
					reader.readLine();
					reader.readLine();
				}
			}
			
			reader.close();
			writer = new PrintWriter("data/Clubs.txt");
			writer.write(data);
			writer.close();
	}
	
	/**
	 *<b>Description:</b> This method allows getting the id of a club by the argument and remove it from the ArrayList.<br>
	 * @param arg The name or the id of the club.
	 * @return The club's id.
	 */
	
	public String getClubId(String arg){
		
		String id = null;
		boolean running = true;
		
		for(int i = 0; i < clubs.size() && running; i++){
			
			if(clubs.get(i).getName().equals(arg) || clubs.get(i).getId().equals(arg)){	
					
					id = clubs.get(i).getId();
					clubs.remove(i);
					running = false;
			}
		}
		
		return id;
	}
}
