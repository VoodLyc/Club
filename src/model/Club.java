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
import java.util.Comparator;

/**
*<b>Description:</b> The class Club in the package model.<br>
*@author Johan Giraldo.
*/

public class Club implements Comparable <Club>, Comparator<Club>{

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
			data += getData();

			PrintWriter writer = new PrintWriter(file);
			writer.append(data);
			writer.close();
		}
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
	
	/**
	*<b>Description:</b> This method allows converting the club's attributes in a String.<br>
	*@return A String with the company's attributes.
	*/
	
	public String getData(){
		
		String data = "";
		
		data += id + "\n";
		data += name + "\n";
		data += creationDate + "\n";
		data += petType;
		
		return data;
	}
	
	/**
	*<b>Description:</b> This method allows converting the club's attributes in a String.<br>
	*@return A String with the company's attributes.
	*/
	
	public String toString(){
		
		String toString = "";
		
		toString += "ID: " + id + "\n";
		toString += "Name: " + name + "\n";
		toString += "Creation date: " + creationDate + "\n";
		toString += "Pet type: " + petType + "\n";
		toString += "Number Of Owners: " + owners.size() + "\n";
		
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
				
				throw new IllegalIdException("An Owner with this id already exists");
			}
			else{
				
				owners.add(new Owner(id, name, birthdate, favoritePet));
				saveOwners();
				msg = "The owner was added successfully";
			}
		}
		catch(IllegalIdException e){
			
			msg = e.getMessage();
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
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace(); 
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
	 *<b>Description:</b> This method allows comparing a club with other club by the id.<br>
	 *@param club The club with which it compares.
	 *@return 0 if the IDs are equals, 1  if the club's id is major than the club's id which it compares, -1 if the club's id is minor than the club's id which it compares.
	 */
	
	@Override
	public int compareTo(Club club){
		
		int result = 0;
		int id = Integer.parseInt(getId());
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
	 *<b>Description:</b> This method allows comparing a club with other club by the name.<br>
	 *@param club The club with which it compares.
	 *@return 0 if the names are equals, 1  if the club's name is major than the club's name which it compares, -1 if the club's name is minor than the club's name which it compares.
	 */
	
	public int compare(Club club, Club club2){
		
		int result = 0;
		
		if(club.getName().compareTo(club2.getName()) > 0){
			
			result = 1;
		}
		else if(club.getName().compareTo(club2.getName()) < 0){
			
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
	 *<b>Description:</b> This method allows comparing a club with other club by the number of owners.<br>
	 *@param club The club with which it compares.
	 *@return 0 if the number of owners is equals, 1  if the club's number of owners is major than the club's number of owners which it compares, -1 if the club's number of owners is minor than the club's number of owners which it compares.
	 */
	
	public int compareByNumberOfOwners(Club club){
		
		int result = 0;
		
		if(getNumberOfOwners() > club.getNumberOfOwners()){
			
			result = 1;
		}
		else if(getNumberOfOwners() < club.getNumberOfOwners()){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows getting the club's number of owners.<br>
	 *@return A int with the number of owners.
	 */
	
	public int getNumberOfOwners(){
		
		int numberOfOwners = 0; 
		
		numberOfOwners = owners.size();
		
		return numberOfOwners;
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the owners from minor to major by the id.<br>
	 *<b>Post:</b> The owners are sorted by id from minor to major.<br>
	 */
	
	public void sortOwnersById(){
		
		for(int i = 1; i < owners.size(); i++){
			for(int j = i - 1; j >= 0 && owners.get(j).compareTo(owners.get(j+1)) > 0; j--){
				
				Owner one = owners.get(j);
				Owner two = owners.get(j+1);
				
				owners.set(j, two);
				owners.set(j+1, one);
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the owners from minor to major by the name.<br>
	 *<b>Post:</b> The owners are sorted by name from minor to major.<br>
	 */
	
	public void sortOwnersByName(){
		
		for(int i = 0; i < owners.size() -1; i++){
			
			Owner minor = owners.get(i);
			int minorPos = i;
			
			for(int j = i + 1; j < owners.size(); j++){
				
				Owner actual = owners.get(j);
				
				if(actual.compareByName(minor) < 0){
					
					minor = actual;					
					minorPos = j;
				}
			}
			
			Owner tmp = owners.get(i);
			owners.set(i, minor);
			owners.set(minorPos, tmp);
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the owners from minor to major by the birthdate.<br>
	 *<b>Post:</b> The owners are sorted by birthdate from minor to major.<br>
	 */
	
	public void sortOwnersByBirthdate(){
		
		for(int i = owners.size(); i > 0; i--){	
			for(int j = 0; j < i - 1; j++){
				
				if(owners.get(j).compareByBirthdate(owners.get(j+1)) > 0){
					
					Owner tmp = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, tmp);
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the owners from minor to major by the favoritePet.<br>
	 *<b>Post:</b> The owners are sorted by favoritePet from minor to major.<br>
	 */
	
	public void sortOwnersByFavoritePet(){
		
		for(int i = 1; i < owners.size(); i++){
			for(int j = i - 1; j >= 0 && owners.get(j).compareByFavoritePet(owners.get(j+1)) > 0; j--){
				
				Owner one = owners.get(j);
				Owner two = owners.get(j+1);
				
				owners.set(j, two);
				owners.set(j+1, one);
			}
		}
	}
	
	
	/**
	 *<b>Description:</b> This method allows sorting the owners from minor to major by the number of pets.<br>
	 *<b>Post:</b> The owners are sorted by number of pets from minor to major.<br>
	 */
	
	public void sortOwnersByNumberOfPets(){
		
		for(int i = 1; i < owners.size(); i++){
			for(int j = i - 1; j >= 0 && owners.get(j).compareByNumberOfPets(owners.get(j+1)) > 0; j--){
				
				Owner one = owners.get(j);
				Owner two = owners.get(j+1);
				
				owners.set(j, two);
				owners.set(j+1, one);
			}
		}
	}
	
	
	/**
	 *<b>Description:</b> This method allows creating a list with the owners sorted by the id.<br>
	 * @return A list wit the owners sorted by id.
	 */
	
	public String ownersSortListById(){
		
		String list = "";
		
		sortOwnersById();
		
		for(Owner owner : owners){
			
			list += owner.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the owners sorted by the name.<br>
	 * @return A list wit the owners sorted by name.
	 */
	
	public String ownersSortListByName(){
		
		String list = "";
		
		sortOwnersByName();
		
		for(Owner owner : owners){
			
			list += owner.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the owners sorted by the birthdate.<br>
	 * @return A list wit the owners sorted by birthdate.
	 */
	
	public String ownersSortListByBirthdate(){
		
		String list = "";
		
		sortOwnersByBirthdate();
		
		for(Owner owner : owners){
			
			list += owner.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the owners sorted by the favoritePet.<br>
	 * @return A list wit the owners sorted by favoritePet.
	 */
	
	public String ownersSortListByFavoritePet(){
		
		String list = "";
		
		sortOwnersByFavoritePet();
		
		for(Owner owner : owners){
			
			list += owner.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the owners sorted by the number of pets.<br>
	 * @return A list wit the owners sorted by number of pets.
	 */
	
	public String ownersSortListByNumberOfPets(){
		
		String list = "";
		
		sortOwnersByFavoritePet();
		
		for(Owner owner : owners){
			
			list += owner.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description</b> This method allows showing a sort list of the owners by whatever criterion.<br>
	 *@param typeOfList The criterion.
	 *@return A sort list of the owners by the criterion.
	 */
	
	public String ownerSortList(int typeOfList){
		
		String list = "";
		
		switch(typeOfList){
			
		case 1:
			
			list = ownersSortListById();
			
			break;
			
		case 2:
			
			list = ownersSortListByName();
			
			break;
			
		case 3:
			
			list = ownersSortListByBirthdate();
			
			break;
			
		case 4:
			
			list = ownersSortListByFavoritePet();
			
			break;
			
		case 5:
			
			list = ownersSortListByNumberOfPets();
			
			break;
		
		}
			
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the owners who match with the id.<br>
	 * @param id The owner's id.
	 * @return A list with the owners that match with the id.
	 */
	
	public String binarySearchById(String id){
	 
		boolean found = false;
		String list = "The owner(s) with that id could not be found";
		int start = 0;
		int end = owners.size() - 1;
		Owner owner = new Owner(id, "", "", "");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(owners.get(middle).compareTo(owner) == 0){
				
				list = owners.get(middle).toString() + "\n";
				found = true;
			}
			if(owners.get(middle).compareTo(owner) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the owners who match with the id.<br>
	 * @param id The owner's id.
	 * @return A list with the owners that match with the id.
	 */
	
	public void sequentialSearchById(String id){
		
		Owner owner;
		boolean running = true;
		owner = new Owner(id, "", "", "");
		
		for(int i = 0; i < owners.size() - 1 && running; i++){
			
			if(owners.get(i).compareTo(owner) == 0){
				
				if(owners.get(i+1).compareTo(owner) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param owner The owner which it compares.
	 * @return A list with the owners that match with the name.
	 */
	
	public String searchByNameLeft(int index, Owner owner){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i >= 0 && is; i--){
			
			if(owners.get(i).compareByName(owner) != 0){
				
				is = false;
			}
			else{
				
				list += owners.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param owner The owner which it compares.
	 * @return A list with the owners that match with the name.
	 */
	
	public String searchByNameRight(int index, Owner owner){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i > owners.size() && is; i++){
			
			if(owners.get(i).compareByName(owner) != 0){
				
				is = false;
			}
			else{
				
				list += owners.get(i).toString() + "\n";
			}
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the owners who match with the name.<br>
	 * @param name The ownwer's name.
	 * @return A list with the owners that match with the name.
	 */
	
	public String binarySearchByName(String name){
	
		boolean found = false;
		String list = "The owner(s) with that name could not be found";
		int start = 0;
		int end = owners.size() - 1;
		Owner owner = new Owner("", name, "", "");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(owners.get(middle).compareByName(owner) == 0){
				
				list = owners.get(middle).toString() + "\n";
				list += searchByNameLeft(middle, owner);
				list += searchByNameRight(middle, owner);
				found = true;
			}
			if(owners.get(middle).compareByName(owner) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the owners who match with the name.<br>
	 * @param name The owner's name.
	 * @return A list with the owners that match with the name.
	 */
	
	public void sequentialSearchByName(String name){
		
		Owner owner;
		boolean running = true;
		owner = new Owner("", name, "", "");
		
		for(int i = 0; i < owners.size() - 1 && running; i++){
			
			if(owners.get(i).compareByName(owner) == 0){
				
				if(owners.get(i+1).compareByName(owner) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param owner The owner which it compares.
	 * @return A list with the owners that match with the birthdate.
	 */
	
	public String searchByBirthdateLeft(int index, Owner owner){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i >= 0 && is; i--){
			
			if(owners.get(i).compareByBirthdate(owner) != 0){
				
				is = false;
			}
			else{
				
				list += owners.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param owner The owner which it compares.
	 * @return A list with the owners that match with the birthdate.
	 */
	
	public String searchByBirthdateRight(int index, Owner owner){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i > owners.size() && is; i++){
			
			if(owners.get(i).compareByBirthdate(owner) != 0){
				
				is = false;
			}
			else{
				
				list += owners.get(i).toString() + "\n";
			}
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the owners who match with the birthdate.<br>
	 * @param birthdate The ownwer's birthdate.
	 * @return A list with the owners that match with the birthdate.
	 */
	
	public String binarySearchByBirthdate(String birthdate){
	
		boolean found = false;
		String list = "The owner(s) with that birthdate could not be found";
		int start = 0;
		int end = owners.size() - 1;
		Owner owner = new Owner("", "", birthdate, "");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(owners.get(middle).compareByBirthdate(owner) == 0){
				
				list = owners.get(middle).toString() + "\n";
				list += searchByBirthdateLeft(middle, owner);
				list += searchByBirthdateRight(middle, owner);
				found = true;
			}
			if(owners.get(middle).compareByBirthdate(owner) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the owners who match with the birthdate.<br>
	 * @param birthdate The owner's birhtdate.
	 * @return A list with the owners that match with the birthdate.
	 */
	
	public void sequentialSearchByBirthdate(String birthdate){
		
		Owner owner;
		boolean running = true;
		owner = new Owner("", "", birthdate, "");
		
		for(int i = 0; i < owners.size() - 1 && running; i++){
			
			if(owners.get(i).compareByBirthdate(owner) == 0){
				
				if(owners.get(i+1).compareByBirthdate(owner) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param owner The owner which it compares.
	 * @return A list with the owners that match with the favoritePet.
	 */
	
	public String searchByFavoritePetLeft(int index, Owner owner){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i >= 0 && is; i--){
			
			if(owners.get(i).compareByFavoritePet(owner) != 0){
				
				is = false;
			}
			else{
				
				list += owners.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param owner The owner which it compares.
	 * @return A list with the owners that match with the favoritePet.
	 */
	
	public String searchByFavoritePetRight(int index, Owner owner){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i > owners.size() && is; i++){
			
			if(owners.get(i).compareByFavoritePet(owner) != 0){
				
				is = false;
			}
			else{
				
				list += owners.get(i).toString() + "\n";
			}
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the owners who match with the favoritePet.<br>
	 * @param birthdate The ownwer's favoritePet.
	 * @return A list with the owners that match with the favoritePet.
	 */
	
	public String binarySearchByFavoritePet(String favoritePet){
	
		boolean found = false;
		String list = "The owner(s) with that favorite pet could not be found";
		int start = 0;
		int end = owners.size() - 1;
		Owner owner = new Owner("", "", "", favoritePet);
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if(owners.get(middle).compareByFavoritePet(owner) == 0){
				
				list = owners.get(middle).toString() + "\n";
				list += searchByFavoritePetLeft(middle, owner);
				list += searchByFavoritePetRight(middle, owner);
				found = true;
			}
			if(owners.get(middle).compareByFavoritePet(owner) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the owners who match with the favoritePet.<br>
	 * @param id The owner's id.
	 * @return A list with the owners that match with the favoritePet.
	 */
	
	public void sequentialSearchByFavoritePet(String favoritePet){
		
		Owner owner;
		boolean running = true;
		owner = new Owner("", "", "", favoritePet);
		
		for(int i = 0; i < owners.size() - 1 && running; i++){
			
			if(owners.get(i).compareByFavoritePet(owner) == 0){
				
				if(owners.get(i+1).compareByFavoritePet(owner) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the owners who match with the id.<br>
	 *@param arg The id of the owner. 
	 *@return A list with the owners that match with the id and the time that it took.
	 */
	
	public String searchById(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortOwnersById();
		
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
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the owners who match with the name.<br>
	 *@param arg The name of the owner. 
	 *@return A list with the owners that match with the name and the time that it took.
	 */
	
	public String searchByName(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortOwnersByName();
		
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
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the owners who match with the birthdate.<br>
	 *@param arg The birthdate of the owner. 
	 *@return A list with the clubs that match with the birthdate and the time that it took.
	 */
	
	public String searchByBirthdate(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortOwnersByBirthdate();
		
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
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the owners who match with the favoritePet.<br>
	 *@param arg The favoritePet of the owner. 
	 *@return A list with the clubs that match with the favoritePet and the time that it took.
	 */
	
	public String searchByFavoritePet(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		sortOwnersByFavoritePet();
		
		t1 = System.nanoTime();
		list = binarySearchByFavoritePet(arg) + "\n";
		t2 = System.nanoTime();
		delta1 = (t1 - t2);
		
		t1 = System.nanoTime();
		sequentialSearchByFavoritePet(arg);
		t2 = System.nanoTime();
		delta2 = (t1 - t2);
		
		list += "The binary search took: " + delta1 + "ns" + "\n";
		list += "The sequantial search took: " + delta2 + "ns" + "\n";
		
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows showing the lists of the clubs who match with the arg, and the time that took do the binary and sequential search.<br> 
	 * @param typeOfSearch The type of search.
	 * @param arg The search criterion.
	 * @return A list with the clubs who match with the criterion.
	 */
	
	public String ownerSearch(int typeOfSearch, String arg){
		
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
			
			list = searchByFavoritePet(arg);
		}
		
		return list;
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
