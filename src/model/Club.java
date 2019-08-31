package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
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
		saveClub();
	}

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
			e.printStackTrace();
		}
	}

	public void addOwners(String id, String name, String birthdate, String favoritePet){
	
		owners.add(new Owner(id, name, birthdate, favoritePet));
	}

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
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}			
		}
	}
}
