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
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
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
			
			msg = e.getMessage();
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
			e.printStackTrace();
		}
		catch(IOException e){
		
			e.printStackTrace();
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
	 *<b>Description:</b> This method allows sorting the clubs from minor to major by the id.<br>
	 *<b>Post:</b> The clubs are sorted by id from minor to major.<br>
	 */
	
	public void sortClubsById(){
		
		for(int i = 0; i < clubs.size() -1; i++){
			
			Club minor = clubs.get(i);
			int minorPos = i;
			
			for(int j = i + 1; j < clubs.size(); j++){
				
				Club actual = clubs.get(j);
				
				if(actual.compare(actual, minor) < 0){
					
					minor = actual;					
					minorPos = j;
				}
			}
			
			Club tmp = clubs.get(i);
			clubs.set(i, minor);
			clubs.set(minorPos, tmp);
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the clubs from minor to major by the name.<br>
	 *<b>Post:</b> The clubs are sorted by name from minor to major.<br>
	 */
	
	public void sortClubsByName(){
			
		for(int i = 1; i < clubs.size(); i++){
			for(int j = i - 1; j >= 0 && clubs.get(j).compare(clubs.get(i), clubs.get(j+1)) > 0; j--){
				
				Club one = clubs.get(j);
				Club two = clubs.get(j+1);
				
				clubs.set(j, two);
				clubs.set(j+1, one);
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the clubs from minor to major by the creationDate.<br>
	 *<b>Post:</b> The clubs are sorted by creationDate from minor to major.<br>
	 */
	
	public void sortClubsByCreationDate(){
		
		for(int i = clubs.size(); i > 0; i--){	
			for(int j = 0; j < i - 1; j++){
				
				if(clubs.get(j).compareByCreationDate(clubs.get(j+1)) > 0){
					
					Club tmp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, tmp);
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the clubs from minor to major by the petType.<br>
	 *<b>Post:</b> The clubs are sorted by petType from minor to major.<br>
	 */
	
	public void sortClubsByPetType(){
		
		for(int i = clubs.size(); i > 0; i--){	
			for(int j = 0; j < i - 1; j++){
				
				if(clubs.get(j).compareByPetType(clubs.get(j+1)) > 0){
					
					Club tmp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, tmp);
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows sorting the clubs from minor to major by the number of pets.<br>
	 *<b>Post:</b> The clubs are sorted by number of pets from minor to major.<br>
	 */
	
	public void sortClubsByNumberOfOwners(){
		
		for(int i = 1; i < clubs.size(); i++){
			for(int j = i - 1; j >= 0 && clubs.get(j).compareByNumberOfOwners(clubs.get(j+1)) > 0; j--){
				
				Club one = clubs.get(j);
				Club two = clubs.get(j+1);
				
				clubs.set(j, two);
				clubs.set(j+1, one);
			}
		}
	}
	
	
	/**
	 *<b>Description:</b> This method allows getting the id of a club by the argument and remove it from the ArrayList.<br>
	 * @param arg The id of the club.
	 * @return The club's id.
	 */
	
	public String getClubId(String arg){
		
		String id = null;
		boolean running = true;
		
		for(int i = 0; i < clubs.size() && running; i++){
			
			if(clubs.get(i).getId().equals(arg)){	
					
					id = clubs.get(i).getId();
					clubs.remove(i);
					running = false;
			}
		}
		
		return id;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the clubs sorted by the id.<br>
	 * @return A list wit the clubs sorted by id.
	 */
	
	public String clubsSortListById(){
		
		String list = "";
		
		sortClubsById();
		
		for(Club club : clubs){
			
			list += club.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the clubs sorted by the name.<br>
	 * @return A list wit the clubs sorted by name.
	 */
	
	public String clubsSortListByName(){
		
		String list = "";
		
		sortClubsByName();
		
		for(Club club : clubs){
			
			list += club.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the clubs sorted by the creationDate.<br>
	 * @return A list wit the clubs sorted by creationDate.
	 */
	
	public String clubsSortListByCreationDate(){
		
		String list = "";
		
		sortClubsByCreationDate();
		
		for(Club club : clubs){
			
			list += club.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the clubs sorted by the petType.<br>
	 * @return A list wit the clubs sorted by petType.
	 */
	
	public String clubsSortListByPetType(){
		
		String list = "";
		
		sortClubsByPetType();
		
		for(Club club : clubs){
			
			list += club.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows creating a list with the clubs sorted by the number of owners.<br>
	 * @return A list wit the clubs sorted by number of owners.
	 */
	
	public String clubsSortListByNumberOfOwners(){
		
		String list = "";
		
		sortClubsByNumberOfOwners();
		
		for(Club club : clubs){
			
			list += club.toString() + "\n";
		}
		
		return list;
	}
	
	/**
	 *<b>Description</b> This method allows showing a sort list of the clubs by whatever criterion.<br>
	 *@param typeOfList The criterion.
	 *@return A sort list of the clubs by the criterion.
	 */
	
	public String clubSortList(int typeOfList){
		
		String list = "";
		
		switch(typeOfList){
			
		case 1:
			
			list = clubsSortListById();
			
			break;
			
		case 2:
			
			list = clubsSortListByName();
			
			break;
			
		case 3:
			
			list = clubsSortListByCreationDate();
			
			break;
			
		case 4:
			
			list = clubsSortListByPetType();
			
			break;
			
		case 5:
			
			list = clubsSortListByNumberOfOwners();
			
			break;
		
		}
			
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a binary search for the clubs who match with the id.<br>
	 * @param id The club's id.
	 * @return A list with the clubs that match with the id.
	 */
	
	public String binarySearchById(String id){
	 
		boolean found = false;
		String list = "";
		int start = 0;
		int end = clubs.size() - 1;
		Club club = new Club(id, "", "", "");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if (clubs.get(middle).compare(clubs.get(middle), club) == 0){
				
				list += clubs.get(middle).toString() + "\n";
				found = true;
			}
			if(clubs.get(middle).compare(clubs.get(middle), club) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the clubs who match with the id.<br>
	 * @param id The club's id.
	 * @return A list with the clubs that match with the id.
	 */
	
	public void sequentialSearchById(String id){
		
		Club club;
		boolean running = true;
		club = new Club(id, "", "", "");
		
		for(int i = 0; i < clubs.size() - 1 && running; i++){
			
			if(clubs.get(i).compare(clubs.get(i),club) == 0){
				
				if(clubs.get(i+1).compare(clubs.get(i+1), club) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param club The club which it compares.
	 * @return A list with the clubs that match with the name.
	 */
	
	public String searchByNameLeft(int index, Club club){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i > 0 && is; i--){
			
			if(clubs.get(i).compare(clubs.get(i), club) != 0){
				
				is = false;
			}
			else{
				
				list += clubs.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param club The club which it compares.
	 * @return A list with the clubs that match with the name.
	 */
	
	public String searchByNameRight(int index, Club club){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i > clubs.size() && is; i++){
			
			if(clubs.get(i).compare(clubs.get(i), club) != 0){
				
				is = false;
			}
			else{
				
				list += clubs.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching for the clubs who match with the name.<br>
	 * @param name The club's name.
	 * @return A list with the clubs that match with the name.
	 */
	
	public String binarySearchByName(String name){
	
		boolean found = false;
		String list = "";
		int start = 0;
		int end = clubs.size() - 1;
		Club club = new Club("", name, "", "");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if (clubs.get(middle).compare(clubs.get(middle), club) == 0){
				
				list += clubs.get(middle).toString() + "\n";
				list += searchByNameLeft(middle, club);
				list += searchByNameRight(middle, club);
				found = true;
			}
			if(clubs.get(middle).compare(clubs.get(middle), club) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
		
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the clubs who match with the id.<br>
	 * @param name The club's name.
	 * @return A list with the clubs that match with the name.
	 */
	
	public void sequentialSearchByName(String name){
		
		Club club;
		boolean running = true;
		club = new Club("", name, "", "");
		
		for(int i = 0; i < clubs.size() - 1 && running; i++){
			
			if(clubs.get(i).compare(clubs.get(i), club) == 0){
				
				if(clubs.get(i+1).compare(clubs.get(i), club) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param club The club which it compares.
	 * @return A list with the clubs that match with the creationDate.
	 */
	
	public String searchByCreationDateLeft(int index, Club club){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i > 0 && is; i--){
			
			if(clubs.get(i).compareByCreationDate(club) != 0){
				
				is = false;
			}
			else{
				
				list += clubs.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param club The club which it compares.
	 * @return A list with the clubs that match with the creationDate.
	 */
	
	public String searchByCreationDateRight(int index, Club club){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i > clubs.size() && is; i++){
			
			if(clubs.get(i).compareByCreationDate(club) != 0){
				
				is = false;
			}
			else{
				
				list += clubs.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param creationDate The club's creationDate.
	 * @return A list with the clubs that match with the creationDate.
	 */
	
	public String binarySearchByCreationDate(String creationDate){
	
		boolean found = false;
		String list = "";
		int start = 0;
		int end = clubs.size() - 1;
		Club club = new Club("", "", creationDate , "");
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if (clubs.get(middle).compareByCreationDate(club) == 0){
				
				list += clubs.get(middle).toString() + "\n";
				list += searchByCreationDateLeft(middle, club);
				list += searchByCreationDateRight(middle, club);
				found = true;
			}
			if(clubs.get(middle).compareByCreationDate(club) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the clubs who match with the id.<br>
	 * @param creationDate The club's creationDate.
	 * @return A list with the clubs that match with the creationDate.
	 */
	
	public void sequentialSearchByCreationDate(String creationDate){
		
		Club club;
		boolean running = true;
		club = new Club("", "", creationDate, "");
		
		for(int i = 0; i < clubs.size() - 1 && running; i++){
			
			if(clubs.get(i).compareByCreationDate(club) == 0){
				
				if(clubs.get(i+1).compareByCreationDate(club) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the left of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param club The club which it compares.
	 * @return A list with the clubs that match with the petType.
	 */
	
	public String searchByPetTypeLeft(int index, Club club){
		
		String list = "";
		boolean is = true;
		
		for(int i = index - 1; i > 0 && is; i--){
			
			if(clubs.get(i).compareByPetType(club) != 0){
				
				is = false;
			}
			else{
				
				list += clubs.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param index The position in which the for was going.
	 * @param club The club which it compares.
	 * @return A list with the clubs that match with the petType.
	 */
	
	public String searchByPetTypeRight(int index, Club club){
		
		String list = "";
		boolean is = true;
		
		for(int i = index + 1; i > clubs.size() && is; i++){
			
			if(clubs.get(i).compareByPetType(club) != 0){
				
				is = false;
			}
			else{
				
				list += clubs.get(i).toString() + "\n";
			}
		}
		
		return list;
		
	}
	
	/**
	 *<b>Description:</b> This method allows searching in the right of the ArrayList from the index indicated.<br>
	 * @param petType The club's petType.
	 * @return A list with the clubs that match with the petType.
	 */
	
	public String binarySearchByPetType(String petType){
	
		boolean found = false;
		String list = "";
		int start = 0;
		int end = clubs.size() - 1;
		Club club = new Club("", "", "" , petType);
		
		while(start <= end && !found){
			
			int middle = ((start + end) / 2);
			
			if (clubs.get(middle).compareByPetType(club) == 0){
				
				list += clubs.get(middle).toString() + "\n";
				list += searchByPetTypeLeft(middle, club);
				list += searchByPetTypeRight(middle, club);
				found = true;
			}
			if(clubs.get(middle).compareByPetType(club) > 0){
				
				end = middle - 1;
			}
			else{
				
				start = middle + 1;
			}
		}	
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows doing a sequential search for the clubs who match with the id.<br>
	 * @param petType The club's petType.
	 * @return A list with the clubs that match with the petType.
	 */
	
	public void sequentialSearchByPetType(String petType){
		
		Club club;
		boolean running = true;
		club = new Club("", "", "", petType);
		
		for(int i = 0; i < clubs.size() - 1 && running; i++){
			
			if(clubs.get(i).compareByPetType(club) == 0){
				
				if(clubs.get(i+1).compareByPetType(club) != 0){
					
					running = false;
				}
			}
		}
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the clubs who match with the id.<br>
	 *@param arg The id of the club. 
	 *@return A list with the clubs that match with the id and the time that it took.
	 */
	
	public String searchById(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
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
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the clubs who match with the name.<br>
	 *@param arg The name of the club. 
	 *@return A list with the clubs that match with the name and the time that it took.
	 */
	
	public String searchByName(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
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
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the clubs who match with the creationDate.<br>
	 *@param arg The creationDate of the club. 
	 *@return A list with the clubs that match with the creationDate and the time that it took.
	 */
	
	public String searchByCreationDate(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
		t1 = System.nanoTime();
		list = binarySearchByCreationDate(arg) + "\n";
		t2 = System.nanoTime();
		delta1 = (t1 - t2);
		
		
		t1 = System.nanoTime();
		sequentialSearchByCreationDate(arg);
		t2 = System.nanoTime();
		delta2 = (t1 - t2);
		
		list += "The binary search took: " + delta1 + "ns" + "\n";
		list += "The sequantial search took: " + delta2 + "ns" + "\n";
		
		
		return list;
	}
	
	/**
	 *<b>Description:</b> This method allows calculating the time that took do a binary and sequential search for the clubs who match with the petType.<br>
	 *@param arg The petType of the club. 
	 *@return A list with the clubs that match with the petType and the time that it took.
	 */
	
	public String searchByPetType(String arg){
		
		String list = "";
		long t1, t2;
		long delta1, delta2;
		
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
	 *<b>Description:</b> This method allows showing the lists of the clubs who match with the arg, and the time that took do the binary and sequential search.<br> 
	 * @param typeOfSearch The type of search.
	 * @param arg The search criterion.
	 * @return A list with the clubs who match with the criterion.
	 */
	
	public String clubSearchTypes(int typeOfSearch, String arg){
		
		String list = "";
		
		switch(typeOfSearch){
		
		case 1:
			
			list = searchById(arg);
			
			break;
			
		case 2:
			
			list = searchByName(arg);
			
			break;
			
		case 3:
			
			list = searchByCreationDate(arg);
			
			break;
			
		case 4:
			
			list = searchByPetType(arg);
		}
		
		return list;
	}
}
