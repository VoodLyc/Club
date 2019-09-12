package test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import model.Club;
import model.Owner;
import model.Pet;

class ClubTest {
	
	private Club club;
	private ArrayList<Owner> owners;
	
	private void setUpScenario1(){
		
		club = new Club ("","","","");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("6","","","");
		Owner o2 = new Owner("1","","","");
		Owner o3 = new Owner("4","","","");
		Owner o4 = new Owner("5","","","");
		Owner o5 = new Owner("3","","","");
		Owner o6 = new Owner("4","","","");
		
		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		
		club.setOwners(owners);
	}
	
	private void setUpScenario2(){
		
		club = new Club ("","","","");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("","Yui","","");
		Owner o2 = new Owner("","Alva","","");
		Owner o3 = new Owner("","Johan","","");
		Owner o4 = new Owner("","Juan","","");
		Owner o5 = new Owner("","Ariza","","");
		Owner o6 = new Owner("","Johan","","");
		
		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		
		club.setOwners(owners);
	}
	
	private void setUpScenario3(){
		
		club = new Club ("","","","");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("","","10/3/1998","");
		Owner o2 = new Owner("","","23/8/2014","");
		Owner o3 = new Owner("","","13/11/2007","");
		Owner o4 = new Owner("","","4/6/2003","");
		Owner o5 = new Owner("","","19/2/2014","");
		Owner o6 = new Owner("","","13/11/2007","");
		
		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		
		club.setOwners(owners);
	}
	
	private void setUpScenario4(){
		
		club = new Club ("","","","");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("","","","Vulture");
		Owner o2 = new Owner("","","","Cheetah");
		Owner o3 = new Owner("","","","Gecko");
		Owner o4 = new Owner("","","","Lion");
		Owner o5 = new Owner("","","","Flamingo");
		Owner o6 = new Owner("","","","Gecko");
		
		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		
		club.setOwners(owners);
	}
	
	private void setUpScenario5(){
		
		club = new Club ("","","","");
		owners = new ArrayList<Owner>();
		ArrayList<Pet> pets = new ArrayList<Pet>();
		
		Owner o1 = new Owner("","","","");
		Owner o2 = new Owner("","","","");
		Owner o3 = new Owner("","","","");
		Owner o4 = new Owner("","","","");
		Owner o5 = new Owner("","","","");
		Owner o6 = new Owner("","","","");
		Pet p1 = new Pet("","","","", "");
		Pet p2 = new Pet("","","","", "");
		Pet p3 = new Pet("","","","", "");
		Pet p4 = new Pet("","","","", "");
		Pet p5 = new Pet("","","","", "");
		Pet p6 = new Pet("","","","", "");
		Pet p7 = new Pet("","","","", "");
		Pet p8 = new Pet("","","","", "");
		Pet p9 = new Pet("","","","", "");
		Pet p10 = new Pet("","","","", "");
		Pet p11 = new Pet("","","","", "");
		Pet p12 = new Pet("","","","", "");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		
		o1.setPets(pets);
		pets = new ArrayList<Pet>();
		
		pets.add(p5);
		pets.add(p6);
		
		o4.setPets(pets);
		pets = new ArrayList<Pet>();
		
		pets.add(p7);
		pets.add(p8);
		pets.add(p9);
		
		o2.setPets(pets);
		pets = new ArrayList<Pet>();
		
		pets.add(p10);
		
		o6.setPets(pets);
		pets = new ArrayList<Pet>();
		
		pets.add(p11);
		pets.add(p12);
		
		o5.setPets(pets);
		
		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		
		club.setOwners(owners);
	}
	
	private void setUpScenario6(){
		
		club = new Club("", "", "", "");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("3", "", "", "");
		Owner o2 = new Owner("2", "", "", "");
		Owner o3 = new Owner("1", "", "", "");

		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
	
		club.setOwners(owners);
	}
	
	private void setUpScenario7(){
		
		club = new Club("", "", "", "");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("", "Mateo", "", "");
		Owner o2 = new Owner("", "Ariza", "", "");
		Owner o3 = new Owner("", "Ariza", "", "");
		Owner o4 = new Owner("", "Juan", "", "");
		Owner o5 = new Owner("", "Ariza", "", "");
		Owner o6 = new Owner("", "Johan", "", "");
		Owner o7 = new Owner("", "Ariza", "", "");
		Owner o8 = new Owner("", "Mateo", "", "");
		Owner o9 = new Owner("", "Ariza", "", "");

		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		owners.add(o7);
		owners.add(o8);
		owners.add(o9);
	
		club.setOwners(owners);
	}
	
	private void setUpScenario8(){
		
		club = new Club("", "", "", "");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("", "", "10/3/1998", "");
		Owner o2 = new Owner("", "", "23/8/2014", "");
		Owner o3 = new Owner("", "", "13/11/2007", "");
		Owner o4 = new Owner("", "", "4/8/2014", "");
		Owner o5 = new Owner("", "", "19/2/2014", "");
		Owner o6 = new Owner("", "", "13/11/2007", "");
		Owner o7 = new Owner("", "", "13/11/2007", "");
		Owner o8 = new Owner("", "", "13/11/2007", "");
		Owner o9 = new Owner("", "", "13/11/2007", "");

		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		owners.add(o7);
		owners.add(o8);
		owners.add(o9);
	
		club.setOwners(owners);
	}
	
	private void setUpScenario9(){
		
		club = new Club("", "", "", "");
		owners = new ArrayList<Owner>();
		
		Owner o1 = new Owner("", "", "", "Vulture");
		Owner o2 = new Owner("", "", "", "Cheetah");
		Owner o3 = new Owner("", "", "", "Gecko");
		Owner o4 = new Owner("", "", "", "Lion");
		Owner o5 = new Owner("", "", "", "Flamingo");
		Owner o6 = new Owner("", "", "", "Gecko");
		Owner o7 = new Owner("", "", "", "Gecko");
		Owner o8 = new Owner("", "", "", "Gecko");
		Owner o9 = new Owner("", "", "", "Gecko");

		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		owners.add(o5);
		owners.add(o6);
		owners.add(o7);
		owners.add(o8);
		owners.add(o9);
	
		club.setOwners(owners);
	}

	@Test
	void testOwnerSortListById() {
		
		setUpScenario1();
		
		club.ownerSortList(1);
		owners = club.getOwners();
		
		assertEquals(owners.get(0).getId(),"1");
		assertEquals(owners.get(1).getId(),"3");
		assertEquals(owners.get(2).getId(),"4");
		assertEquals(owners.get(3).getId(),"4");
		assertEquals(owners.get(4).getId(),"5");
		assertEquals(owners.get(5).getId(),"6");
	}
	
	@Test
	void testOwnerSortListByName() {
		
		setUpScenario2();
		
		club.ownerSortList(2);
		owners = club.getOwners();
		
		assertEquals(owners.get(0).getName(),"Alva");
		assertEquals(owners.get(1).getName(),"Ariza");
		assertEquals(owners.get(2).getName(),"Johan");
		assertEquals(owners.get(3).getName(),"Johan");
		assertEquals(owners.get(4).getName(),"Juan");
		assertEquals(owners.get(5).getName(),"Yui");
	}
	
	@Test
	void testOwnerSortListByCreationDate() {
		
		setUpScenario3();
		
		club.ownerSortList(3);
		owners = club.getOwners();
		
		assertEquals(owners.get(0).getBirthdate(),"10/3/1998");
		assertEquals(owners.get(1).getBirthdate(),"4/6/2003");
		assertEquals(owners.get(2).getBirthdate(),"13/11/2007");
		assertEquals(owners.get(3).getBirthdate(),"13/11/2007");
		assertEquals(owners.get(4).getBirthdate(),"19/2/2014");
		assertEquals(owners.get(5).getBirthdate(),"23/8/2014");
	}
	
	@Test
	void testOwnerSortListByPetFavoritePet() {
		
		setUpScenario4();
		
		club.ownerSortList(4);
		owners = club.getOwners();
		
		assertEquals(owners.get(0).getFavoritePet(),"Cheetah");
		assertEquals(owners.get(1).getFavoritePet(),"Flamingo");
		assertEquals(owners.get(2).getFavoritePet(),"Gecko");
		assertEquals(owners.get(3).getFavoritePet(),"Gecko");
		assertEquals(owners.get(4).getFavoritePet(),"Lion");
		assertEquals(owners.get(5).getFavoritePet(),"Vulture");
	}
	
	@Test
	void testOwnerSortListByNumberOfPets() {
		
		setUpScenario5();
		
		club.ownerSortList(5);
		owners = club.getOwners();
		
		assertEquals(owners.get(0).getNumberOfPets(), 0);
		assertEquals(owners.get(1).getNumberOfPets(), 1);
		assertEquals(owners.get(2).getNumberOfPets(), 2);
		assertEquals(owners.get(3).getNumberOfPets(), 2);
		assertEquals(owners.get(4).getNumberOfPets(), 3);
		assertEquals(owners.get(5).getNumberOfPets(), 4);
	}
	
	@Test
	void testOwnerSearchById() {
		
		setUpScenario6();	
		String list, id;
		String[] lines, idLine, idValue;
		
		list = club.ownerSearch(1, "1");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		assertEquals(id, "1");
		
		list = club.ownerSearch(1, "2");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		assertEquals(id, "2");
		
		list = club.ownerSearch(1, "3");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		assertEquals(id, "3");
		
		list = club.ownerSearch(1, "4");
		lines = list.split("\n");
		id = lines[0];
		
		assertEquals(id, "The owner with that id could not be found");
	}
	
	@Test
	void testOwnerSearchByName() {
		
		setUpScenario7();	
		String list, name, name2, name3, name4, name5;
		String[] lines, NameLine, NameValue;
		
		list = club.ownerSearch(2, "Ariza");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		NameLine = lines[7].split(":");
		NameValue = NameLine[1].split(" ");
		name2 = NameValue[1];
		
		NameLine = lines[13].split(":");
		NameValue = NameLine[1].split(" ");
		name3 = NameValue[1];
		
		NameLine = lines[19].split(":");
		NameValue = NameLine[1].split(" ");
		name4 = NameValue[1];
		
		NameLine = lines[25].split(":");
		NameValue = NameLine[1].split(" ");
		name5 = NameValue[1];

		assertEquals(name, "Ariza");
		assertEquals(name2, "Ariza");
		assertEquals(name3, "Ariza");
		assertEquals(name4, "Ariza");
		assertEquals(name5, "Ariza");
		
		list = club.ownerSearch(2, "Johan");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];

		assertEquals(name, "Johan");
		
		list = club.ownerSearch(2, "Mateo");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		NameLine = lines[7].split(":");
		NameValue = NameLine[1].split(" ");
		name2 = NameValue[1];
		
		assertEquals(name, "Mateo");
		assertEquals(name2, "Mateo");
		
		list = club.ownerSearch(2, "Juan");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		assertEquals(name, "Juan");
		
		list = club.ownerSearch(2, "Jalld");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The owner(s) with that name could not be found");
	}
	
	@Test
	void testOwnerSearchByBirthdate() {
		
		setUpScenario8();
		String list, date, date2, date3, date4, date5;
		String[] lines, DateLine, DateValue;
		
		list = club.ownerSearch(3, "13/11/2007");
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		DateLine = lines[8].split(":");
		DateValue = DateLine[1].split(" ");
		date2 = DateValue[1];
		
		DateLine = lines[14].split(":");
		DateValue = DateLine[1].split(" ");
		date3 = DateValue[1];
		
		DateLine = lines[20].split(":");
		DateValue = DateLine[1].split(" ");
		date4 = DateValue[1];
		
		DateLine = lines[26].split(":");
		DateValue = DateLine[1].split(" ");
		date5 = DateValue[1];
		
		assertEquals(date, "13/11/2007");
		assertEquals(date2, "13/11/2007");
		assertEquals(date3, "13/11/2007");
		assertEquals(date4, "13/11/2007");
		assertEquals(date5, "13/11/2007");
		
		list = club.ownerSearch(3, "10/3/1998"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "10/3/1998");
		
		list = club.ownerSearch(3, "23/8/2014"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "23/8/2014");
		
		list = club.ownerSearch(3, "4/8/2014"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "4/8/2014");
		
		list = club.ownerSearch(3, "19/2/2014"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		list = club.ownerSearch(3, "19/2/1700");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The owner(s) with that birthdate could not be found");
		
	}
	
	@Test
	void testOwnerSearchByFavoritePet() {
		
		setUpScenario9();
		String list, petType, petType2, petType3, petType4, petType5;
		String[] lines, petTypeLine, petTypeValue;
		
		list = club.ownerSearch(4, "Gecko");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		petTypeLine = lines[9].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType2 = petTypeValue[1];
		
		petTypeLine = lines[15].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType3 = petTypeValue[1];
		
		petTypeLine = lines[21].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType4 = petTypeValue[1];

		petTypeLine = lines[27].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType5 = petTypeValue[1];
		
		assertEquals(petType, "Gecko");
		assertEquals(petType2, "Gecko");
		assertEquals(petType3, "Gecko");
		assertEquals(petType4, "Gecko");
		assertEquals(petType5, "Gecko"); 
		
		list = club.ownerSearch(4, "Vulture");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Vulture");
		
		list = club.ownerSearch(4, "Cheetah");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Cheetah");
		
		list = club.ownerSearch(4, "Lion");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Lion");
		
		list = club.ownerSearch(4, "Flamingo");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Flamingo");
		
		list = club.ownerSearch(4, "Elephant");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The owner(s) with that favorite pet could not be found");
	}
}
