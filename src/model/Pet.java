package model;
import java.io.Serializable;

/**
*<b>Description:</b> The class Pet in the package model.<br>
*@author Johan Giraldo.
*/

public class Pet implements Serializable {

//Attributes

	private static final long serialVersionUID = -8399330065765763732L;
	private String id;
	private String name;
	private String birthdate;
	private String petType;

//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class Pet.<br>
	*<b>Pre:</b> No one parameter can be null.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*@param id The pet's identification.
	*@param name The pet's name.
	*@param birthdate The pet's birthdate.
	*@param petType The pet's type.
	*/

	public Pet(String id, String name, String birthdate, String petType){

		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.petType = petType;
	}

	public String getName() {
		return name;
	}
}
