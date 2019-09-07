package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
*<b>Description:</b> The class Club in the package model.<br>
*@author Johan Giraldo.
*/

public class Club {

//Attributes

	private String id;
	private String name;
	private String creationDate;
	private String petType;
	private ArrayList<Owner> owners;

//Constructor

	/**
	*<b>Description:</b> The constructor of the class Club.<br>
	*<b>Pre:</b> No one parameter can be null.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*@param id The club's identification.
	*@param name The club's name.
	*@param creationDate The club's creation date.
	*@param petType The club's pets type.
	*/

	public Club(String id, String name, String creationDate, String petType){

		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.petType = petType;
		owners = new ArrayList<Owner>();
		loadOwners();
	}
	
//Methods
	
	/**
	*<b>Description:</b> This method allows saving the club's attributes (excluding the ArrayList of owners).<br>
	*<b>Post:</b> Club's attributes are saved in a .txt file.<br>
	*/
	
	public void saveClub(){
		
		String data = "";
		File file;

		try{
			
			file = new File("data/Clubs.txt");
			
			data += readClubsData();
			data += toString();

			PrintWriter writer = new PrintWriter(file);
			writer.append(data);
			writer.close();
		}
		catch (FileNotFoundException e){
			System.out.println("A saving error has occurred");
		}
		catch(IOException e){
			
			System.out.println("A saving error has occurred");
		}
	}
	
	/**
	*<b>Description:</b> This method allows converting the club's attributes in a String.<br>
	*@return A String with the company's attributes.
	*/
	
	public String toString(){
		
		String toString = "";
		
		toString += id + "\n";
		toString += name + "\n";
		toString += creationDate + "\n";
		toString += petType;
		
		return toString;
	}
	
	/**
	*<b>Description:</b> This method allows reading the data in Clubs.txt.<br>
	*@return The data in the Clubs.txt. 
	*/
	
	public String readClubsData() throws IOException, FileNotFoundException{
		
		String data = "";
		String line;

		FileReader file;
		BufferedReader reader;
			
			file = new FileReader("data/Clubs.txt");
			reader = new BufferedReader(file);
			
			while((line = reader.readLine()) != null){
				
				data += line + "\n";
			}
			
			reader.close();
		
		return data;
	}
	
	/**
	*<b>Description:</b> This method allows adding owners in the ArrayList of owners.<br>
	*@param id The owner's identification.
	*@param name The owner's name.
	*@param birthdate The owner's birthdate.
	*@param favoritePet The owner's favorite pet(Type).
	*@return A message that indicates if the owner was added or if the owner can't be added.
	*@throws IllegalIdException If the owner that will be added have a equals id that other owner already added.
	*/

	public String addOwners(String id, String name, String birthdate, String favoritePet){
		
		String msg = "";
		
		try{
			if(checkIfExistOwnerWithThisId(id)){
				
				throw new IllegalIdException("An Owner with this id already exists, please try again");
			}
			else{
				
				owners.add(new Owner(id, name, birthdate, favoritePet));
				saveOwners();
				msg = "The owner was added successfully";
			}
		}
		catch(IllegalIdException e){
			
			System.out.print(e.getMessage());
		}
		
		return msg;
	}
	
	/**
	 *<b>Description:</b> This method allows checking if already exist an owner with that id.<br>
	 * @param id The owner's id.
	 * @return A boolean true if an owner with that id exists and false if the owner doesn't exist.
	 */
	
	public boolean checkIfExistOwnerWithThisId(String id){
		
		boolean exist = false;
		boolean running = true;
		
		for(int i = 0; i < owners.size() && running; i++){
			
			if(owners.get(i).getId().equals(id)){
				
				exist = true;
				running = false;
			}
		}
		return exist;
	}
	
	/**
	 *<b>Description:</b> This method allows owners of the owner ArrayList to be saved.<br>
	 *<b>Post:</b> The owners have serialized.<br>
	 */

	public void saveOwners(){

		FileOutputStream file; 
		ObjectOutputStream output;

		try{

		file = new FileOutputStream("data/" + id + ".owners");
		output = new ObjectOutputStream(file);
		output.writeObject(owners);
		output.close();
		}
		catch(FileNotFoundException e){
			System.out.println("A saving error has occurred");
		}
		catch(IOException e){
			System.out.println("A saving error has occurred"); 
		}			
	}
	
	/**
	 *<b>Description:</b> This method allows loading the club's owners.<br>
	 *<b>Pre:</b> The folder "data" with the program's data must exist<br>
	 *<b>Post:</b> The owners have been deserialized.<br>
	 */
	
	public void loadOwners(){
		
		File file;
		FileInputStream fileInput;
		ObjectInputStream input;
		
		try{
			
			file = new File("data/" + id + ".owners");
			
			if(file.exists()){

				fileInput = new FileInputStream(file);
				input = new ObjectInputStream(fileInput);
				owners = (ArrayList<Owner>) input.readObject();
				input.close();
				
				for(Owner o : owners){
					
					o.loadPets();
				}
			}
			else{
				
				saveOwners();
			}
			
		}
		catch(FileNotFoundException e){
			
			System.out.println("A loading error has occurred");		
		} 
		catch(IOException e){
			
			System.out.println("A loading error has occurred");
		}
		catch(ClassNotFoundException e){
		
			System.out.println("A loading error has occurred");
		}
	}
	
	/**
	 *<b>Description:</b> This method allows deleting an owner of the owners ArrayList by the id.<br>
	 *@param id The owner's id.
	 *@return A message that indicates if the owner was deleted or not.
	 */
	
	public String deleteOwner(String id){
		
		String msg = "The owner could not be found, please try again";
		
		if(removeOwner(id)){
			
			saveOwners();
			msg = "The owner was deleted succesfully";
		}
		
		return msg;
	}
	
	/**
	 *<b>Description:</b> This method allows removing an owner of the owners ArrayList by the id.<br>
	 *@param id The owner's id.
	 *@return A boolean that indicates if the owner was removed or not.
	 */
	
	public boolean removeOwner(String id){
		
		boolean removed = false;
		boolean running = true;
		
		for(int i = 0; i < owners.size() && running; i++){
			
			if(owners.get(i).getId().equals(id)){	
					
					owners.remove(i);
					removed = true;
					running = false;
			}
		}
		
		return removed;
	}
	
	/**
	 *<b>Description:</b> This method allows getting the index of the owner with that id.<br> 
	 *@param id The owner's id.
	 *@return A whole number with the index of the owner who matches with that id.
	 */
	
	public int getOwnerIndex(String id){
		
		int index = -1;
		boolean running = true;
		
		for(int i = 0; i < owners.size() && running; i++){
			
			if(owners.get(i).getId().equals(id)){
	
				index = i;
				running = false;
			}
		}
		
		return index;
	}
	
	/**
	 *<b>Description:</b> This method allows getting a owner by the index.<br>
	 * @param index The index where the owner is in the owners ArrayList.
	 * @return The owner with this index.
	 */
	
	public Owner getOwner(int index){
		
		Owner owner = null;
		
		owner = owners.get(index);
		
		return owner;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a club with other club by the name.<br>
	 *@param club The club with which it compares.
	 *@return 0 if the names are equals, 1  if the club's name is major than the club's name which it compares, -1 if the club's name is minor than the club's name which it compares.
	 */
	
	public int compareByName(Club club){
		
		int result = 0;
		
		if(name.compareTo(club.getName()) > 0){
			
			result = 1;
		}
		else if(name.compareTo(club.getName()) < 0){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a club with other club by the id.<br>
	 *@param club The club with which it compares.
	 *@return 0 if the IDs are equals, 1  if the club's id is major than the club's id which it compares, -1 if the club's id is minor than the club's id which it compares.
	 */
	
	public int compareById(Club club){
		
		int result = 0;
		int id = Integer.parseInt(this.id);
		int id2 = Integer.parseInt(club.getId());
		
		if(id > id2){
			
			result = 1;
		}
		else if(id < id2){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a club with other club by the creationDate.<br>
	 *@param club The club with which it compares.
	 *@return 0 if the creationDates are equals, 1  if the club's creationDate is major than the club's creationDate which it compares, -1 if the club's creationDate is minor than the club's creationDate which it compares.
	 */
	
	public int compareByCreationDate(Club club){
		
		int result = 0;
		int[] dates = splitDate(club);
		
		if(dates[0] > dates[1]){
			
			result = 1;
		}
		else if(dates[0] < dates[1]){
			
			result = -1;
		}
		else if(dates[0] == dates[1]){
			
			if(dates[2] > dates[3]){
				
				result = 1;
			}
			
			else if(dates[2] < dates[3]){
				
				result = -1;
			}
			else if(dates[2] == dates[3]){
				
				if(dates[4] > dates [5]){
					
					result = 1;
				}
				else if(dates[4] < dates[5]){
					
					result = -1;
				}
				
			}
		}	
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows splitting and does the parseInt to the club's creationDate and the to the club's creationDate which it compares.<br>
	 *@param club The club with which it compares.
	 *@return An array of int that represents the dates of both clubs.
	 */
	
	public int[] splitDate(Club club){
		
		String[] date = creationDate.split("/");
		String[] date2 = club.getCreationDate().split("/");
		int[] dates = new int[6];
		
		dates[0] = Integer.parseInt(date[2]);
		dates[1] = Integer.parseInt(date2[2]);
		dates[2] = Integer.parseInt(date[1]);
		dates[3] = Integer.parseInt(date2[1]);
		dates[4] = Integer.parseInt(date[0]);
		dates[5] = Integer.parseInt(date2[0]);
		
		return dates;
	}

	/**
	 *<b>Description:</b> This method allows comparing a club with other club by the id.<br>
	 *@param club The club with which it compares.
	 *@return 0 if the IDs are equals, 1  if the club's id is major than the club's id which it compares, -1 if the club's id is minor than the club's id which it compares.
	 */
	
	public int compareByPetType(Club club){
		
		int result = 0;
		
		if(petType.compareTo(club.getPetType()) > 0){
			
			result = 1;
		}
		else if(petType.compareTo(club.getPetType()) < 0){
			
			result = -1;
		}
		
		return result;
	}

	/**
	 *<b>Description:</b> This method allows returning the attribute name.<br>
	 *@return The attribute name.
	 */

	public String getName(){
		return name;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute id<br>
	 *@return The attribute id.
	 */

	public String getId(){
		return id;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute petType.<br>
	 *@return The attribute type.
	 */

	public String getPetType(){
		return petType;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute creationDate<br>
	 *@return The attribute creationDate.
	 */

	public String getCreationDate(){
		return creationDate;
	}
}
