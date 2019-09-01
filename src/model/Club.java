package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.IllegalNameException;

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
		saveClub();
	}
	
	/**
	*<b>Description:</b> This method allows saving the club's attributes (excluding the ArrayList of owners).<br>
	*<b>Post:</b> Club's attributes are saved in a .txt file.<br>
	*/
	
	public void saveClub(){
		
		String data = "";
		File file;
		File directory;

		try{

			directory = new File("data/" + name + "/");
			directory.mkdir();
			file = new File("data/" + name + "/" + name + ".txt");

			data += id + "\n";
			data += name + "\n";
			data += creationDate + "\n";
			data += petType;

			PrintWriter writer = new PrintWriter(file);
			writer.append(data);
			writer.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Save failed");
		}
	}
	
	/**
	*<b>Description:</b> This method allows adding owners in the ArrayList of owners, if the owner that will be added have a equals name that other owner already added, the method throws a IllegalNameException<br>
	*@param id The owner's identification.
	*@param name The owner's name.
	*@param birthdate The owner's birthdate.
	*@param favoritePet The owner's favorite pet(Type).
	*@return A message that indicates if the owner was added or if the owner can't be added.
	*/

	public String addOwners(String id, String name, String birthdate, String favoritePet){
		
		String msg = "The owner could not be added";
		
		try{
			if(checkIfExistOwnerWithThisName(name)){
				
				throw new IllegalNameException("An Owner with this name already exists, please try again");
			}
			else{
				
				owners.add(new Owner(id, name, birthdate, favoritePet));
				msg = "The owner was added successfully";
			}
		}
		catch(IllegalNameException e ){
			
			System.out.println(e.getMessage());
		}
		
		return msg;
	}
	
	/**
	 *<b>Description:</b> This method allows checking if the already exist a owner with that name<br>
	 * @param name The owner's name.
	 * @return A boolean true if an owner with that name exists and false if the owner doesn't exist.
	 */
	
	public boolean checkIfExistOwnerWithThisName(String name){
		boolean exist = false;
		
		for(Owner o : owners){
			
			if(o.getName().equals(name)){
				
				exist = true;
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

		for(Owner o : owners){

			try{

			file = new FileOutputStream("data/" + name + "/");
			output = new ObjectOutputStream(file);
			output.writeObject(o);
			output.close();
			}
			catch(FileNotFoundException e){
				System.out.println("Save failed");
			}
			catch(IOException e){
				System.out.println("Save failed"); 
			}			
		}
	}
	
	/**
	 *<b>Description:</b> This method allows loading the club's owners.<br>
	 *<b>Post:</b> The owners have been deserialized.<br>
	 */
	
	public void loadOwners(){
		
		FileInputStream file;
		ObjectInputStream input;
		File folder;
		String[] objects;
		Owner owner;
		
		try{
			
			folder = new File("data/" + name + "/");
			objects = folder.list();
			
			for(String o : objects){
				
				if(!o.equals(name + ".txt")){
					
					file = new FileInputStream("data/" + name + "/" + o);
					input = new ObjectInputStream(file);
					owner = (Owner) input.readObject();
					owners.add(owner);
				}
			}	
		}
		catch(FileNotFoundException e){
			
			System.out.println("Loading error");		
		} 
		catch(IOException e){
			
			System.out.println("Loading error");
		}
		catch(ClassNotFoundException e){
		
			System.out.println("Loading error");
		}
	}
}
