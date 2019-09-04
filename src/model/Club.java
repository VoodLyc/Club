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
		catch(IllegalIdException e ){
			
			System.out.print(e.getMessage());
		}
		
		return msg;
	}
	
	/**
	 * 
	 *@param club 
	 *@param id The owner's identification.
	 *@param name The owner's name.
	 *@param birthdate The owner's birthdate.
	 *@param favoritePet The owner's favorite pet(Type).
	 *@return A message that indicates if the owner was added or if the owner can't be added. 
	 */
	
	public String addOwner(Club club, String id, String name, String birthdate, String favoritePet){
		
		String msg = club.addOwners(id, name, birthdate, favoritePet);
		
		return msg;	
	}
	
	/**
	 *<b>Description:</b> This method allows checking if already exist an owner with that id.<br>
	 * @param id The owner's name.
	 * @return A boolean true if an owner with that name exists and false if the owner doesn't exist.
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

		for(Owner owner : owners){

			try{

			file = new FileOutputStream("data/" + id + ".dat");
			output = new ObjectOutputStream(file);
			output.writeObject(owner);
			output.close();
			}
			catch(FileNotFoundException e){
				System.out.println("A saving error has occurred");
			}
			catch(IOException e){
				System.out.println("A saving error has occurred"); 
			}			
		}
	}
	
	/**
	 *<b>Description:</b> This method allows loading the club's owners.<br>
	 *<b>Pre:</b> The folder "data" with the program's data must exist<br>
	 *<b>Post:</b> The owners have been deserialized.<br>
	 */
	
	public void loadOwners(){
		
		FileInputStream file;
		ObjectInputStream input;
		File folder;
		String[] objects;
		Owner owner;
		
		try{
			
			folder = new File("data/" + id + "/");
			objects = folder.list();
			
			for(String object : objects){
				
				if(!object.equals(id + ".txt")){
					
					file = new FileInputStream("data/" + id + "/" + object);
					input = new ObjectInputStream(file);
					owner = (Owner) input.readObject();
					owners.add(owner);
				}
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
	 *<b>Description:</b> This method allows returning the attribute name<br>
	 * @return The attribute name.
	 */

	public String getName(){
		return name;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute id<br>
	 * @return The attribute id.
	 */

	public String getId(){
		return id;
	}
}
