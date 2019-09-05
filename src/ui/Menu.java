package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.ClubsManagementSystem;
import model.Club;
import model.Owner;
import model.Pet;

public class Menu{

//Attributes
	
	private ClubsManagementSystem clubsSystem;
	private Scanner scanner;
	
//Constructor
	
	public Menu(){
		
		clubsSystem = new ClubsManagementSystem();
		scanner = new Scanner(System.in);	
	}
	
//Methods

	public void systemMenu(){

		boolean running = true;
		int choice = 0;

		while(running){

			choice = systemOptionMenu();

			switch(choice){
			
			case 1:
				
				enterInAClubMenu();
				
				break;
				
			case 2:
				
				registerClubMenu();
				
				break;

			case 3:
				
				deleteClubMenu();

				break;

			case 4:
	
				running = false;

				break;
				
			}
		}	
	}


	public int systemOptionMenu(){

		boolean running = true;
		int choice = 0;

		while(running){

			System.out.println("1. Enter a club");
			System.out.println("2. Create a club");
			System.out.println("3. Delete a club");
			System.out.println("4. Exit");
						
			try{

				choice = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){

				scanner.next();
			}

			if(choice > 0 && choice < 5){

				running = false;
			}
			else{
				
				System.out.println("Please enter a correct value\n");
			}
		}

		return choice;
	}

	public void registerClubMenu(){

		String id, name, creationDate, petType;
		int day, month, year;

		System.out.println("Please enter the club's id");
		id = scanner.nextLine();

		System.out.println("Please enter the club's name");
		name = scanner.nextLine();

		System.out.println("Please enter the club creation's day (A number between 1 and 31)");
		day = validateInt(1, 31);	

		System.out.println("Please enter the club creation's month (A number between 1 and 12)");
		month = validateInt(1, 12);

		System.out.println("Please enter the club creation's year (Example: 2015)");
		year = validateInt(1700, 2300);

		creationDate = day + "/" + month + "/" + year; 
		
		System.out.println("Please enter the type of pet that the club prefers");
		petType = scanner.nextLine();

		System.out.println(clubsSystem.addClub(id, name, creationDate, petType) + "\n");
	}
	
	public void deleteClubMenu(){
		
		String arg;
		
		System.out.println("Please enter the id or the name of the club do you wish to delete");
		arg = scanner.nextLine();
		
		System.out.println(clubsSystem.deleteClub(arg) + "\n");
	}
	
	public void enterInAClubMenu(){
		
		String id;
		boolean running = true;
		Club club;
		
		while(running){
			
			System.out.println("Please enter the id of the club do you wish to enter");
			id = scanner.nextLine();
			
			if(clubsSystem.checkIfExistClubWithThisId(id)){
				
				club = clubsSystem.getClub(id);
				clubMenu(club);
				running = false;
				
			}
			else{
				
				System.out.println("The club could not be found, please try again\n");
			}
		}
	}
	
	public void clubMenu(Club club){

		boolean running = true;
		int choice = 0;

		while(running){

			choice = clubOptionMenu(club);

			switch(choice){
			
			case 1:
				
				enterInAClubMenu();
				
				break;
				
			case 2:
				
				registerOwnerMenu(club);
				
				break;

			case 3:
				
				deleteClubMenu();

				break;

			case 4:
	
				running = false;

				break;
				
			}
		}	
	}
	
	public int clubOptionMenu(Club club){

		boolean running = true;
		int choice = 0;

		while(running){
			
			System.out.println("You are in the club " + club.getId() + "\n");
			System.out.println("1. Enter a owner");
			System.out.println("2. Create a owner");
			System.out.println("3. Delete a owner");
			System.out.println("4. To return");
						
			try{

				choice = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){

				scanner.next();
			}

			if(choice > 0 && choice < 5){

				running = false;
			}
			else{
				
				System.out.println("Please enter a correct value\n");
			}
		}

		return choice;
	}
	
	public void registerOwnerMenu(Club club){
		
		String id, name, birthdate, favoritePet;
		int day, month, year;

		System.out.println("Please enter the owner's id");
		id = scanner.nextLine();

		System.out.println("Please enter the owner's name");
		name = scanner.nextLine();

		System.out.println("Please enter the owner's birth day (A number between 1 and 31)");
		day = validateInt(1, 31);	

		System.out.println("Please enter the owner's birth month (A number between 1 and 12)");
		month = validateInt(1, 12);

		System.out.println("Please enter the owner's birth year (Example: 2015)");
		year = validateInt(1700, 2300);

		birthdate = day + "/" + month + "/" + year; 
		
		System.out.println("Please enter the owner's favorite pet");
		favoritePet = scanner.nextLine();

		System.out.println();
			
	}

	public int validateInt(int minimum, int max){
	
		boolean running = true;
		int num = 0;
		
		while(running){
			
			try{

				num = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){
				
				scanner.next();
			}
			
			if(num >= minimum && num <= max){
				
				running = false;
				
			}
			else{
				
				System.out.print("Invalid number, please try again\n");
				
			}
			
		}
		
		return num;
	}
}
