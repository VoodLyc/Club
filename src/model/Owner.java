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

public class Owner implements Serializable, Comparable<Owner> {

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
			
			e.printStackTrace();		
		} 
		catch(IOException e){
			
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
		
			e.printStackTrace();
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
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 *<b>Description:</b> This method allows deleting a pet of the pets ArrayList by the name.<br>
	 *@param id The pet's id.
	 *@return A message that indicates if the owner was deleted or not.
	 */
	
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
	
	public String addPets(String id, String name, String birthdate, String gender, String petType){
		
		String msg = "";
		
		try{
			
			if(checkIfExistPetWithThisName(name)){
				
				throw new IllegalIdException("A pet with this name already exists, please try again");
			}
			else{
				
				pets.add(new Pet(id, name, birthdate, gender, petType));
				savePets();
				msg = "The pet was added successfully";
				
			}
		}
		catch(IllegalIdException e){
			
			msg = e.getMessage();
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
	 *<b>Description:</b> This method allows comparing a owner with other owner by the id.<br>
	 *@param owner The owner with which it compares.
	 *@return 0 if the IDs are equals, 1  if the owner's id is major than the owner's id which it compares, -1 if the owner's id is minor than the owner's id which it compares.
	 */
	
	@Override
	public int compareTo(Owner owner){
		
		int result = 0;
		int id = Integer.parseInt(this.id);
		int id2 = Integer.parseInt(owner.getId());
		
		if(id > id2){
			
			result = 1;
		}
		else if(id < id2){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a owner with other owner by the name.<br>
	 *@param owner The owner with which it compares.
	 *@return 0 if the names are equals, 1  if the owner's name is major than the owner's name which it compares, -1 if the owner's name is minor than the owner's name which it compares.
	 */
	
	public int compareByName(Owner owner){
		
		int result = 0;
		
		if(name.compareTo(owner.getName()) > 0){
			
			result = 1;
		}
		else if(name.compareTo(owner.getName()) < 0){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a owner with other owner by the birthdate.<br>
	 *@param owner The owner with which it compares.
	 *@return 0 if the birthdates are equals, 1  if the onwer's birthdate is major than the owner's birthdate which it compares, -1 if the owner's birthdate is minor than the owner's birthdate which it compares.
	 */
	
	public int compareByBirthdate(Owner owner){
		
		int result = 0;
		int[] dates = splitDate(owner);
		
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
	 *<b>Description:</b> This method allows splitting and does the parseInt to the onwer's birthdate and the to the owner's birthdate which it compares.<br>
	 *@param owner The owner with which it compares.
	 *@return An array of int that represents the dates of both owners.
	 */
	
	public int[] splitDate(Owner owner){
		
		String[] date = birthdate.split("/");
		String[] date2 = owner.getBirthdate().split("/");
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
	 *<b>Description:</b> This method allows comparing a owner with other owner by the favoritePet.<br>
	 *@param owner The owner with which it compares.
	 *@return 0 if the favoritePets are equals, 1  if the owner's favoritePet is major than the owner's favoritePet which it compares, -1 if the owner's favoritePet is minor than the owner's favoritePet which it compares.
	 */
	
	public int compareByFavoritePet(Owner owner){
		
		int result = 0;
		
		if(favoritePet.compareTo(owner.getFavoritePet()) > 0){
			
			result = 1;
		}
		else if(favoritePet.compareTo(owner.getFavoritePet()) < 0){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a pet with other pet by the number of pets.<br>
	 *@param pet The pet with which it compares.
	 *@return 0 if the number of pets is equals, 1  if the owner's number of pets is major than the owner's number of pets which it compares, -1 if the owner's number of pets is minor than the owner's number of pets which it compares.
	 */
	
	public int compareByNumberOfPets(Owner owner){
		
		int result = 0;
		
		if(getNumberOfPets() > owner.getNumberOfPets()){
			
			result = 1;
		}
		else if(getNumberOfPets() < owner.getNumberOfPets()){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows getting the owner's number of pets.<br>
	 *@return A int with the number of pets.
	 */
	
	public int getNumberOfPets(){
		
		int numberOfPets = 0;
		
		numberOfPets = pets.size();
		
		return numberOfPets;
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the pets from minor to major by the id.<br>
	 *<b>Post:</b> The owners are sorted by id from minor to major.<br>
	 */
	
	public void sortPetsById(){
		
		for(int i = pets.size(); i > 0; i--){	
			for(int j = 0; j < i - 1; j++){
				
				if(pets.get(j).compareById(pets.get(j+1)) > 0){
					
					Pet tmp = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, tmp);
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the pets from minor to major by the name.<br>
	 *<b>Post:</b> The owners are sorted by name from minor to major.<br>
	 */
	
	public void sortPetsByName(){
		
		for(int i = 0; i < pets.size() -1; i++){
			
			Pet minor = pets.get(i);
			int minorPos = i;
			
			for(int j = i + 1; j < pets.size(); j++){
				
				Pet actual = pets.get(j);
				
				if(actual.compareTo(minor) < 0){
					
					minor = actual;					
					minorPos = j;
				}
			}
			
			Pet tmp = pets.get(i);
			pets.set(i, minor);
			pets.set(minorPos, tmp);
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the pets from minor to major by the birthdate.<br>
	 *<b>Post:</b> The owners are sorted by name from minor to major.<br>
	 */
	
	public void sortPetsByBirthdate(){
		
		for(int i = pets.size(); i > 0; i--){	
			for(int j = 0; j < i - 1; j++){
				
				if(pets.get(j).compareByBirthdate(pets.get(j+1)) > 0){
					
					Pet tmp = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, tmp);
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the pets from minor to major by the gender.<br>
	 *<b>Post:</b> The owners are sorted by gender from minor to major.<br>
	 */
	
	public void sortPetsByGender(){
		
		for(int i = 0; i < pets.size() -1; i++){
			
			Pet minor = pets.get(i);
			int minorPos = i;
			
			for(int j = i + 1; j < pets.size(); j++){
				
				Pet actual = pets.get(j);
				
				if(actual.compareByGender(minor) < 0){
					
					minor = actual;					
					minorPos = j;
				}
			}
			
			Pet tmp = pets.get(i);
			pets.set(i, minor);
			pets.set(minorPos, tmp);
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the pets from minor to major by the petType.<br>
	 *<b>Post:</b> The owners are sorted by petType from minor to major.<br>
	 */
	
	public void sortPetsByPetType(){
		
		for(int i = 1; i < pets.size(); i++){
			for(int j = i - 1; j >= 0 && pets.get(j).compareByPetType(pets.get(j+1)) > 0; j--){
				
				Pet one = pets.get(j);
				Pet two = pets.get(j+1);
				
				pets.set(j, two);
				pets.set(j+1, one);
			}
		}
	}
	
	/**
	*<b>Description:</b> This method allows converting the owner's attributes in a String.<br>
	*@return A String with owner's attributes.
	*/
	
	public String toString(){
		
		String toString = "";
		
		toString += "ID: " + id + "\n";
		toString += "Full name: " + name + "\n";
		toString += "Birthdate: " + birthdate + "\n";
		toString += "Favorite pet: " + favoritePet + "\n";
		toString += "Number of pets: " + pets.size() + "\n";
		
		return toString;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the pets sorted by the id.<br>
	 * @return A list wit the pets sorted by id.
	 */
	
	public String petsSortListById(){
		
		String list = "";
		
		sortPetsById();
		
		for(Pet pet : pets){
			
			list += pet.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the pets sorted by the name.<br>
	 * @return A list wit the pets sorted by name.
	 */
	
	public String petsSortListByName(){
		
		String list = "";
		
		sortPetsByName();
		
		for(Pet pet : pets){
			
			list += pet.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the pets sorted by the birthdate.<br>
	 * @return A list wit the pets sorted by birthdate.
	 */
	
	public String petsSortListByBirthdate(){
		
		String list = "";
		
		sortPetsByBirthdate();
		
		for(Pet pet : pets){
			
			list += pet.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the pets sorted by the gender.<br>
	 * @return A list wit the pets sorted by gender.
	 */
	
	public String petsSortListByGender(){
		
		String list = "";
		
		sortPetsByGender();
		
		for(Pet pet : pets){
			
			list += pet.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the pets sorted by the petType.<br>
	 * @return A list wit the pets sorted by petType.
	 */
	
	public String petsSortListByPetType(){
		
		String list = "";
		
		sortPetsByPetType();
		
		for(Pet pet : pets){
			
			list += pet.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description</b> This method allows showing a sort list of the pets by whatever criterion.<br>
	 *@param typeOfList The criterion.
	 *@return A sort list of the pets by the criterion.
	 */
	
	public String petsSortList(int typeOfList){
		
		String list = "";
		
		switch(typeOfList){
			
		case 1:
			
			list = petsSortListById();
			
			break;
			
		case 2:
			
			list = petsSortListByName();
			
			break;
			
		case 3:
			
			list = petsSortListByBirthdate();
			
			break;
			
		case 4:
			
			list = petsSortListByGender();
			
			break;
			
		case 5:
			
			list = petsSortListByPetType();
			
			break;
		
		}
			
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the id.
	 */
	
	public String searchByIdLeft(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i >= 0 && is; i--){
			
			if(pets.get(i).compareById(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the id.
	 */
	
	public String searchByIdRight(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i < pets.size() && is; i++){
			
			if(pets.get(i).compareById(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the pets who match with the id.<br>
	 * @param pet The pet's id.
	 * @return A list with the pets that match with the id.
	 */
	
	public String binarySearchById(String id){
	
		boolean found = false;
		String list = "The pet(s) with that id could not be found";
		int start = 0;
		int end = pets.size() - 1;
		Pet pet = new Pet(id, "", "", "", "");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(pets.get(middle).compareById(pet) == 0){
				
				list = pets.get(middle).toString() + "\n";
				list += searchByIdLeft(middle, pet);
				list += searchByIdRight(middle, pet);
				found = true;
			}
			if(pets.get(middle).compareById(pet) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the pets who match with the id.<br>
	 * @param id The pet's id.
	 * @return A list with the pets that match with the id.
	 */
	
	public void sequentialSearchById(String id){
		
		Pet pet;
		boolean running = true;
		pet = new Pet(id, "", "", "", "");
		
		for(int i = 0; i < pets.size() && running; i++){
			
			if(pets.get(i).compareById(pet) == 0){
				
				running = false;
			}
		}
	}	
	
	/**
	 *<b>Description:</b> This method allows searching for the pets who match with the name.<br>
	 * @param name The pet's name.
	 * @return A list with the pets that match with the name.
	 */
	
	public String binarySearchByName(String name){
	 
		boolean found = false;
		String list = "The pet(s) with that name could not be found";
		int start = 0;
		int end = pets.size() - 1;
		Pet pet = new Pet("", name, "","","");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(pets.get(middle).compareTo(pet) == 0){
				
				list = pets.get(middle).toString() + "\n";
				found = true;
			}
			if(pets.get(middle).compareTo(pet) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the pets who match with the name.<br>
	 * @param name The pet's name.
	 * @return A list with the pets that match with the name.
	 */
	
	public void sequentialSearchByName(String name){
		
		Pet pet;
		boolean running = true;
		pet = new Pet("", name, "", "", "");
		
		for(int i = 0; i < pets.size() - 1 && running; i++){
			
			if(pets.get(i).compareTo(pet) == 0){
				
				running = false;
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the birthdate.
	 */
	
	public String searchByBirthdateLeft(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i >= 0 && is; i--){
			
			if(pets.get(i).compareByBirthdate(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the birthdate.
	 */
	
	public String searchByBirthdateRight(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i < pets.size() && is; i++){
			
			if(pets.get(i).compareByBirthdate(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the pets who match with the birthdate.<br>
	 * @param birthdate The pet's birthdate.
	 * @return A list with the pets that match with the birthdate.
	 */
	
	public String binarySearchByBirthdate(String birthdate){
	 
		boolean found = false;
		String list = "The pet(s) with that birthdate could not be found";
		int start = 0;
		int end = pets.size() - 1;
		Pet pet = new Pet("", "", birthdate,"","");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(pets.get(middle).compareByBirthdate(pet) == 0){
				
				list = pets.get(middle).toString() + "\n";
				list += searchByBirthdateLeft(middle, pet);
				list += searchByBirthdateRight(middle, pet);
				found = true;
			}
			if(pets.get(middle).compareByBirthdate(pet) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the pets who match with the birthdate.<br>
	 * @param birthdate The pet's birhdate.
	 * @return A list with the pets that match with the birhdate.
	 */
	
	public void sequentialSearchByBirthdate(String birthdate){
		
		Pet pet;
		boolean running = true;
		pet = new Pet("", "", birthdate, "", "");
		
		for(int i = 0; i < pets.size() - 1 && running; i++){
			
			if(pets.get(i).compareByBirthdate(pet) == 0){
				
				if(pets.get(i+1).compareByBirthdate(pet) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the gender.
	 */
	
	public String searchByGenderLeft(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i >= 0 && is; i--){
			
			if(pets.get(i).compareByGender(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the gender.
	 */
	
	public String searchByGenderRight(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i < pets.size() && is; i++){
			
			if(pets.get(i).compareByGender(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the pets who match with the petType.<br>
	 * @param petType The pet's gender.
	 * @return A list with the pets that match with the gender.
	 */
	
	public String binarySearchByGender(String gender){
	 
		boolean found = false;
		String list = "The pet(s) with that gender could not be found";
		int start = 0;
		int end = pets.size() - 1;
		Pet pet = new Pet("", "", "", gender,"");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(pets.get(middle).compareByGender(pet) == 0){
				
				list = pets.get(middle).toString() + "\n";
				list += searchByGenderLeft(middle, pet);
				list += searchByGenderRight(middle, pet);
				found = true;
			}
			if(pets.get(middle).compareByGender(pet) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the pets who match with the gender.<br>
	 * @param gender The pet's gender.
	 * @return A list with the pets that match with the gender.
	 */
	
	public void sequentialSearchByGender(String gender){
		
		Pet pet;
		boolean running = true;
		pet = new Pet("", "", "", gender, "");
		
		for(int i = 0; i < pets.size() - 1 && running; i++){
			
			if(pets.get(i).compareByGender(pet) == 0){
				
				if(pets.get(i+1).compareByGender(pet) != 0){
					
					running = false;
				}
			}
		}
	}
	
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the petType.
	 */
	
	public String searchByPetTypeLeft(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i >= 0 && is; i--){
			
			if(pets.get(i).compareByPetType(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param pet The pet which it compares.
	 * @return A list with the pets that match with the petType.
	 */
	
	public String searchByPetTypeRight(int index, Pet pet){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i < pets.size() && is; i++){
			
			if(pets.get(i).compareByPetType(pet) != 0){
				
				is = false;
			}
			else{
				
				list += pets.get(i).toString() + "\n";
			}
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the pets who match with the petType.<br>
	 * @param petType The pet's type.
	 * @return A list with the pets that match with the petType.
	 */
	
	public String binarySearchByPetType(String petType){
	 
		boolean found = false;
		String list = "The pet(s) with that petType could not be found";
		int start = 0;
		int end = pets.size() - 1;
		Pet pet = new Pet("", "", "", "", petType);
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(pets.get(middle).compareByPetType(pet) == 0){
				
				list = pets.get(middle).toString() + "\n";
				list += searchByPetTypeLeft(middle, pet);
				list += searchByPetTypeRight(middle, pet);
				found = true;
			}
			if(pets.get(middle).compareByPetType(pet) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the pets who match with the petType.<br>
	 * @param petType The pet's type.
	 * @return A list with the pets that match with the petType.
	 */
	
	public void sequentialSearchByPetType(String petType){
		
		Pet pet;
		boolean running = true;
		pet = new Pet("", "", "", "", petType);
		
		for(int i = 0; i < pets.size() - 1 && running; i++){
			
			if(pets.get(i).compareByPetType(pet) == 0){
				
				if(pets.get(i+1).compareByPetType(pet) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the pets who match with the id.<br>
	 *@param arg The id of the pet. 
	 *@return A list with the pets that match with the id and the time that it took.
	 */
	
	public String searchById(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortPetsById();
		
		t1 = System.nanoTime();
		list = binarySearchById(arg) + "\n";
		t2 = System.nanoTime();
		delta1 = (t1 - t2);
		
		t1 = System.nanoTime();
		sequentialSearchById(arg);
		t2 = System.nanoTime();
		delta2 = (t1 - t2);
		
		list += "The binary search took: " + delta1 + "ns" + "\n";
		list += "The sequantial search took: " + delta2 + "ns" + "\n";
		
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the pets who match with the name.<br>
	 *@param arg The name of the pet. 
	 *@return A list with the pets that match with the name and the time that it took.
	 */
	
	public String searchByName(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortPetsByName();
		
		t1 = System.nanoTime();
		list = binarySearchByName(arg) + "\n";
		t2 = System.nanoTime();
		delta1 = (t1 - t2);
		
		t1 = System.nanoTime();
		sequentialSearchByName(arg);
		t2 = System.nanoTime();
		delta2 = (t1 - t2);
		
		list += "The binary search took: " + delta1 + "ns" + "\n";
		list += "The sequantial search took: " + delta2 + "ns" + "\n";
		
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the pets who match with the birthdate.<br>
	 *@param arg The birthdate of the pets. 
	 *@return A list with the pets that match with the birthdate and the time that it took.
	 */
	
	public String searchByBirthdate(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortPetsByBirthdate();
		
		t1 = System.nanoTime();
		list = binarySearchByBirthdate(arg) + "\n";
		t2 = System.nanoTime();
		delta1 = (t1 - t2);
		
		
		t1 = System.nanoTime();
		sequentialSearchByBirthdate(arg);
		t2 = System.nanoTime();
		delta2 = (t1 - t2);
		
		list += "The binary search took: " + delta1 + "ns" + "\n";
		list += "The sequantial search took: " + delta2 + "ns" + "\n";
		
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the pets who match with the gender.<br>
	 *@param arg The gender of the pet. 
	 *@return A list with the pets that match with the gender and the time that it took.
	 */
	
	public String searchByGender(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortPetsByGender();
		
		t1 = System.nanoTime();
		list = binarySearchByGender(arg) + "\n";
		t2 = System.nanoTime();
		delta1 = (t1 - t2);
		
		t1 = System.nanoTime();
		sequentialSearchByGender(arg);
		t2 = System.nanoTime();
		delta2 = (t1 - t2);
		
		list += "The binary search took: " + delta1 + "ns" + "\n";
		list += "The sequantial search took: " + delta2 + "ns" + "\n";
		
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the pets who match with the petType.<br>
	 *@param arg The petType of the pet. 
	 *@return A list with the pets that match with the petType and the time that it took.
	 */
	
	public String searchByPetType(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortPetsByPetType();
		
		t1 = System.nanoTime();
		list = binarySearchByPetType(arg) + "\n";
		t2 = System.nanoTime();
		delta1 = (t1 - t2);
		
		t1 = System.nanoTime();
		sequentialSearchByPetType(arg);
		t2 = System.nanoTime();
		delta2 = (t1 - t2);
		
		list += "The binary search took: " + delta1 + "ns" + "\n";
		list += "The sequantial search took: " + delta2 + "ns" + "\n";
		
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows showing the lists of the pets who match with the arg, and the time that took do the binary and sequential search.<br> 
	 * @param typeOfSearch The type of search.
	 * @param arg The search criterion.
	 * @return A list with the pets who match with the criterion.
	 */
	
	public String petsSearch(int typeOfSearch, String arg){
		
		String list = "";
		
		switch(typeOfSearch){
		
		case 1:
			
			list = searchById(arg);
			
			break;
			
		case 2:
			
			list = searchByName(arg);
			
			break;
			
		case 3:
			
			list = searchByBirthdate(arg);
			
			break;
			
		case 4:
			
			list = searchByGender(arg);
			
			break;
			
		case 5:
			
			list = searchByPetType(arg);
			
			break;
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows getting the attribute pets.<br>
	 *@return The attribute pets.
	 */
	
	public ArrayList<Pet> getPets() {
		return pets;
	}
	
	/**
	 *<b>Description:</b> This method allows setting the attribute clubs.<br>
	 */

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}


	
	/**
	 *<b>Description:</b> This method allows returning the attribute name<br>
	 * @return The attribute name.
	 */

	public String getName(){
		return name;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute birthdate<br>
	 * @return The attribute birthdate.
	 */

	public String getBirthdate(){
		return birthdate;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute favoritePet<br>
	 * @return The attribute favoritePet.
	 */

	public String getFavoritePet(){
		return favoritePet;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute id<br>
	 * @return The attribute id.
	 */

	public String getId() {
		return id;
	}
}
