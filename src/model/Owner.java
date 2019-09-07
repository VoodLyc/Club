package model;
import java.io.Serializable;
import java.util.ArrayList;
import model.IllegalIdException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
*<b>Description:</b> The class Owner in the package model.<br>
*@author Johan Giraldo.
*/

public class Owner implements Serializable {

//Attributes
	
	private static final long serialVersionUID = -3285705953533450841L;
	private String id;
	private String name;
	private String birthdate;
	private String favoritePet;
	private ArrayList<Pet> pets;

//Constructor

	/**
	*<b>Description:</b> The constructor of the class Owner.<br>
	*<b>Pre:</b> No one parameter can be null.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*@param id The owner's identification.
	*@param name The owner's name.
	*@param birthdate The owner's birthdate.
	*@param favoritePet The owner's favorite pet(Type).
	*/

	public Owner(String id, String name, String birthdate, String favoritePet){

		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.favoritePet = favoritePet;
		pets = new ArrayList<Pet>();
		loadPets();
	}
	
//Methods

	/**
	 *<b>Description:</b> This method allows loading the owner's pets.<br>
	 *<b>Pre:</b> The folder "data" with the program's data must exist<br>
	 *<b>Post:</b> The pets have been deserialized.<br>
	 */
	
	public void loadPets(){
		
		File file;
		FileInputStream fileInput;
		ObjectInputStream input;
		
		try{
			
			file = new File("data/" + id + ".pets");
			
			if(file.exists()){

				fileInput = new FileInputStream(file);
				input = new ObjectInputStream(fileInput);
				pets = (ArrayList<Pet>) input.readObject();
				input.close();
			}
			else{
				
				savePets();
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
	 *<b>Description:</b> This method allows pets of the pet ArrayList to be saved.<br>
	 *<b>Post:</b> The pets have serialized.<br>
	 */
	
	public void savePets(){
		
		FileOutputStream file; 
		ObjectOutputStream output;

		try{

		file = new FileOutputStream("data/" + id + ".pets");
		output = new ObjectOutputStream(file);
		output.writeObject(pets);
		output.close();
		}
		catch(FileNotFoundException e){
			System.out.println("A saving error has occurred");
		}
		catch(IOException e){
			System.out.println("A saving error has occurred"); 
		}
	}
	
	public String deletePet(String name){
		
		String msg = "The pet could not be found, please try again";
		
		if(removePet(name)){
			
			savePets();
			msg = "The pet was deleted succesfully";
		}
		
		return msg;
	}
	
	/**
	 *<b>Description:</b> This method allows removing a pet by the name.<br>
	 *@param name The pet's name.
	 *@return A boolean that indicates if the pet was deleted or not.
	 */
	
	public boolean removePet(String name){
		
		boolean removed = false;
		boolean running = true;
		
		for(int i = 0; i < pets.size() && running; i++){
			
			if(pets.get(i).getName().equals(name)){	
					
					pets.remove(i);
					removed = true;
					running = false;
			}
		}
		
		return removed;
	}
	
	/**
	 *<b>Description:</b> This method allows adding pets in the ArrayList of pets.<br>
	 *@param id The pet's identification.
	 *@param name The pet's name.
	 *@param birthdate The pet's birthdate.
	 *@param petType The pet's type.
	 *@return A message that indicates if the pet was added or if the pet can't be added.
	 *@throws IllegalIdException If the pet that will be added have a equals name that other pet already added.
	 */
	
	public String addPets(String id, String name, String birthdate, String petType){
		
		String msg = "";
		
		try{
			
			if(checkIfExistPetWithThisName(name)){
				
				throw new IllegalIdException("A pet with this name already exists, please try again");
			}
			else{
				
				pets.add(new Pet(id, name, birthdate, petType));
				savePets();
				msg = "The pet was added successfully";
				
			}
		}
		catch(IllegalIdException e){
			
			System.out.println(e.getMessage());
		}
		
		return msg;
	}
	
	/**
	 *<b>Description:</b> This method allows checking if already exist an pet with that name.<br>
	 * @param id The pet's name.
	 * @return A boolean true if an pet with that name exists and false if the pet doesn't exist.
	 */
	
	public boolean checkIfExistPetWithThisName(String name){
		
		boolean exist = false;
		boolean running = true;
		
		for(int i = 0; i < pets.size() && running; i++){
			
			if(pets.get(i).getName().equals(name)){
				
				exist = true;
				running = false;
			}
		}
		
		return exist;
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

	public String getId() {
		return id;
	}
}
