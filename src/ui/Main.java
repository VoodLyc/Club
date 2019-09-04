package ui;

/**
*<b>Description:</b> The class Main in the package ui.<br>
*@author Johan Giraldo.
*/

public class Main {

//Attributes

	private Menu menu;

	public static void main(String[]args){
		
		Main m = new Main();
	}
	
	public Main(){
		
		menu = new Menu();
		menu.systemMenu();
	}
}
