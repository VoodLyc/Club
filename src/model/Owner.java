package model;
import java.io.Serializable;
import java.util.ArrayList;

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
	}
	
//Methods
	
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
