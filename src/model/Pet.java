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
	private char gender;
	private String petType;

//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class Pet.<br>
	*<b>Pre:</b> No one parameter can be null.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*@param id The pet's identification.
	*@param name The pet's name.
	*@param birthdate The pet's birthdate.
	*@param gender The pet's gender.
	*@param petType The pet's type.
	*/

	public Pet(String id, String name, String birthdate, char gender, String petType){

		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.petType = petType;
	}
	
//Methods
	
	/**
	 *<b>Description:</b> This method allows comparing a pet with other pet by the id.<br>
	 *@param pet The pet with which it compares.
	 *@return 0 if the IDs are equals, 1  if the pet's id is major than the pet's id which it compares, -1 if the pet's id is minor than the pet's id which it compares.
	 */

	public int compareById(Pet pet){
		
		int result = 0;
		int id = Integer.parseInt(this.id);
		int id2 = Integer.parseInt(pet.getId());
		
		if(id > id2){
			
			result = 1;
		}
		else if(id < id2){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a pet with other pet by the name.<br>
	 *@param pet The pet with which it compares.
	 *@return 0 if the names are equals, 1  if the pet's name is major than the pet's name which it compares, -1 if the pet's name is minor than the pet's name which it compares.
	 */
	
	public int compareByName(Pet pet){
		
		int result = 0;
		
		if(name.compareTo(pet.getName()) > 0){
			
			result = 1;
		}
		else if(name.compareTo(pet.getName()) < 0){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a pet with other pet by the birthdate.<br>
	 *@param pet The pet with which it compares.
	 *@return 0 if the birthdates are equals, 1  if the pet's birthdate is major than the pet's birthdate which it compares, -1 if the pet's birthdate is minor than the pet's birthdate which it compares.
	 */
	
	public int compareByBirthdate(Pet pet){
		
		int result = 0;
		int[] dates = splitDate(pet);
		
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
	 *<b>Description:</b> This method allows splitting and does the parseInt to the pet's birthdate and the to the pet's birthdate which it compares.<br>
	 *@param pet The pet with which it compares.
	 *@return An array of int that represents the dates of both pets.
	 */
	
	public int[] splitDate(Pet pet){
		
		String[] date = birthdate.split("/");
		String[] date2 = pet.getBirthdate().split("/");
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
	 *<b>Description:</b> This method allows comparing a pet with other pet by the gender.<br>
	 *@param pet The pet with which it compares.
	 *@return 0 if the genders are equals, 1  if the pet's gender is major than the pet's gender which it compares, -1 if the pet's gender is minor than the pet's gender which it compares.
	 */
	
	public int compareByGender(Pet pet){
		
		int result = 0;
		
		if(gender > pet.getGender()){
			
			result = 1;
		}
		else if(gender < pet.getGender()){
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a pet with other pet by the petType.<br>
	 *@param pet The pet with which it compares.
	 *@return 0 if the IDs are equals, 1  if the pet's type is major than the pet's type which it compares, -1 if the pet's type is minor than the pet's type which it compares.
	 */
	
	public int compareByPetType(Pet pet){
		
		int result = 0;
		
		if(petType.compareTo(pet.getPetType()) > 0){
			
			result = 1;
		}
		else if(petType.compareTo(pet.getPetType()) < 0){
			
			result = -1;
		}
		
		return result;
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
	 *<b>Description:</b> This method allows returning the attribute gender<br>
	 * @return The attribute gender.
	 */

	public char getGender(){
		return gender;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute petType.<br>
	 *@return The attribute type.
	 */

	public String getPetType(){
		return petType;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute id<br>
	 * @return The attribute id.
	 */

	public String getId() {
		return id;
	}
}
