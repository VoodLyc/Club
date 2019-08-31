package ui;
import model.ClubsManagementSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
*<b>Description:</b> The class Main in the package ui.<br>
*@author Johan Giraldo.
*/

public class Main {

//Attributes

	private ClubsManagementSystem clubsSystem;
	private Scanner scanner;

	public static void main(String[]args){
		
		Main main = new Main();
		main.menu();
	}

	public Main(){
		
		scanner = new Scanner(System.in);
		clubsSystem = new ClubsManagementSystem();
	}

	public void menu(){

		boolean running = true;
		int choice = 0;

		while(running){

			choice = PrincipalMenu();

			switch(choice){

				case 1:

				break;

				case 2:

				registerClubMenu();

				break;

				case 3:

				break;

				case 4:

				running = false;

				break;

				default:

				System.out.println("Please enter a correct value");
			}
		}	
	}

	public int PrincipalMenu(){

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
				System.out.println("Please enter a correct value\n");
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

		System.out.println("Please enter the club's Id");
		id = scanner.nextLine();

		System.out.println("Please enter the club's name");
		name = scanner.nextLine();

		System.out.println("Please enter the club creation's day (A number between 1 and 31)");
		day = validateInt(1, 31);

		System.out.println("Please enter the club creation's month (A number between 1 and 12)");
		month = validateInt(1, 12);

		System.out.println("Please enter the club creation's year (Example: 2015)");
		year = validateInt(1, 5000);

		creationDate = day + "/" + month + "/" + year; 
		
		System.out.println("Enter the type of pet that the club prefers");
		petType = scanner.nextLine();

		clubsSystem.addClub(id, name, creationDate, petType);
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
