package model;
import java.util.ArrayList;

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
	}

	public void addClub(String id, String name, String creationDate, String petType){

		clubs.add(new Club(id, name, creationDate, petType));
	}
}
