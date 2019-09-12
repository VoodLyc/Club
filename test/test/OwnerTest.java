package test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import model.Owner;
import model.Pet;

class OwnerTest {

	private Owner owner;
	private ArrayList<Pet> pets;
	
	
	private void setUpScenario1() {
		
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("6","","","", "");
		Pet p2 = new Pet("1","","","", "");
		Pet p3 = new Pet("4","","","", "");
		Pet p4 = new Pet("5","","","", "");
		Pet p5 = new Pet("3","","","", "");
		Pet p6 = new Pet("4","","","", "");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		
		owner.setPets(pets);
		
	}
	
	private void setUpScenario2() {
		
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("","Yui","","","");
		Pet p2 = new Pet("","Alva","","","");
		Pet p3 = new Pet("","Johan","","","");
		Pet p4 = new Pet("","Juan","","","");
		Pet p5 = new Pet("","Ariza","","","");
		Pet p6 = new Pet("","Johon","","","");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		
		owner.setPets(pets);
		
	}
	
	private void setUpScenario3() {
	
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("","","10/3/1998","","");
		Pet p2 = new Pet("","","23/8/2014","","");
		Pet p3 = new Pet("","","13/11/2007","","");
		Pet p4 = new Pet("","","4/6/2003","","");
		Pet p5 = new Pet("","","19/2/2014","","");
		Pet p6 = new Pet("","","13/11/2007","","");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		
		owner.setPets(pets);
	}
	
	private void setUpScenario4() {
		
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("","","","F","");
		Pet p2 = new Pet("","","","M","");
		Pet p3 = new Pet("","","","M","");
		Pet p4 = new Pet("","","","M","");
		Pet p5 = new Pet("","","","F","");
		Pet p6 = new Pet("","","","M","");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);	
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		
		owner.setPets(pets);
		
	}
	private void setUpScenario5() {
		
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("","","","","Vulture");
		Pet p2 = new Pet("","","","","Cheetah");
		Pet p3 = new Pet("","","","","Gecko");
		Pet p4 = new Pet("","","","","Lion");
		Pet p5 = new Pet("","","","","Flamingo");
		Pet p6 = new Pet("","","","","Gecko");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		
		owner.setPets(pets);
		
	}
	
	private void setUpScenario6() {
	
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("6","","","", "");
		Pet p2 = new Pet("1","","","", "");
		Pet p3 = new Pet("4","","","", "");
		Pet p4 = new Pet("5","","","", "");
		Pet p5 = new Pet("3","","","", "");
		Pet p6 = new Pet("4","","","", "");
		Pet p7 = new Pet("10","","","", "");
		Pet p8 = new Pet("1","","","", "");
		Pet p9 = new Pet("1","","","", "");
		Pet p10 = new Pet("4","","","", "");
		Pet p11 = new Pet("4","","","", "");
		Pet p12 = new Pet("1","","","", "");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		pets.add(p7);
		pets.add(p8);
		pets.add(p9);
		pets.add(p10);
		pets.add(p11);
		pets.add(p12);
		
		owner.setPets(pets);
		
	}
	private void setUpScenario7() {
		
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("","Sasu","","", "");
		Pet p2 = new Pet("","Rei","","", "");
		Pet p3 = new Pet("","Neko","","", "");
		
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		
		owner.setPets(pets);
		
	}
	private void setUpScenario8() {
	
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("", "", "10/3/1998", "","");
		Pet p2 = new Pet("", "", "23/8/2014", "","");
		Pet p3 = new Pet("", "", "13/11/2007", "","");
		Pet p4 = new Pet("", "", "4/8/2014", "","");
		Pet p5 = new Pet("", "", "19/2/2014", "","");
		Pet p6 = new Pet("", "", "13/11/2007", "","");
		Pet p7 = new Pet("", "", "13/11/2007", "","");
		Pet p8 = new Pet("", "", "13/11/2007", "","");
		Pet p9 = new Pet("", "", "13/11/2007", "","");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		pets.add(p7);
		pets.add(p8);
		pets.add(p9);
		
		owner.setPets(pets);
		
	}
	private void setUpScenario9() {
		
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("", "", "", "F","");
		Pet p2 = new Pet("", "", "", "M","");
		Pet p3 = new Pet("", "", "", "F","");
		Pet p4 = new Pet("", "", "", "F","");
		Pet p5 = new Pet("", "", "", "M","");
		Pet p6 = new Pet("", "", "", "F","");
		Pet p7 = new Pet("", "", "", "M","");
		Pet p8 = new Pet("", "", "", "M","");
		Pet p9 = new Pet("", "", "", "F","");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		pets.add(p7);
		pets.add(p8);
		pets.add(p9);
		
		owner.setPets(pets);
		
	}
	
	private void setUpScenario10() {
		
		owner = new Owner ("","","","");
		pets = new ArrayList<Pet>();
		
		Pet p1 = new Pet("", "", "", "","Vulture");
		Pet p2 = new Pet("", "", "", "","Cheetah");
		Pet p3 = new Pet("", "", "", "","Gecko");
		Pet p4 = new Pet("", "", "", "","Lion");
		Pet p5 = new Pet("", "", "", "","Flamingo");
		Pet p6 = new Pet("", "", "", "","Gecko");
		Pet p7 = new Pet("", "", "", "","Gecko");
		Pet p8 = new Pet("", "", "", "","Gecko");
		Pet p9 = new Pet("", "", "", "","Gecko");
		
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		pets.add(p4);
		pets.add(p5);
		pets.add(p6);
		pets.add(p7);
		pets.add(p8);
		pets.add(p9);
		
		owner.setPets(pets);
		
	}
	
	@Test
	void testPetSortListById() {
	
		setUpScenario1();
		
		owner.petsSortList(1);
		pets = owner.getPets();
				
		assertEquals(pets.get(0).getId(),"1");
		assertEquals(pets.get(1).getId(),"3");
		assertEquals(pets.get(2).getId(),"4");
		assertEquals(pets.get(3).getId(),"4");
		assertEquals(pets.get(4).getId(),"5");
		assertEquals(pets.get(5).getId(),"6");
		
	}
	
	@Test
	void testPetSortListByName() {
		
		setUpScenario2();
		
		owner.petsSortList(2);
		pets = owner.getPets();
				
		assertEquals(pets.get(0).getName(),"Alva");
		assertEquals(pets.get(1).getName(),"Ariza");
		assertEquals(pets.get(2).getName(),"Johan");
		assertEquals(pets.get(3).getName(),"Johon");
		assertEquals(pets.get(4).getName(),"Juan");
		assertEquals(pets.get(5).getName(),"Yui");
		
	
	}
	
	@Test
	void testPetSortListByBirthdate() {
	
		setUpScenario3();
		
		owner.petsSortList(3);
		pets = owner.getPets();
				
		assertEquals(pets.get(0).getBirthdate(),"10/3/1998");
		assertEquals(pets.get(1).getBirthdate(),"4/6/2003");
		assertEquals(pets.get(2).getBirthdate(),"13/11/2007");
		assertEquals(pets.get(3).getBirthdate(),"13/11/2007");
		assertEquals(pets.get(4).getBirthdate(),"19/2/2014");
		assertEquals(pets.get(5).getBirthdate(),"23/8/2014");
		
	}
	
	@Test
	void testPetSortListByGender() {
	
		setUpScenario4();
		
		owner.petsSortList(4);
		pets = owner.getPets();
				
		assertEquals(pets.get(0).getGender(),"F");
		assertEquals(pets.get(1).getGender(),"F");
		assertEquals(pets.get(2).getGender(),"M");
		assertEquals(pets.get(3).getGender(),"M");
		assertEquals(pets.get(4).getGender(),"M");
		assertEquals(pets.get(5).getGender(),"M");
		
	}
	
	@Test
	void testPetSortListByPetType() {
	
		setUpScenario5();
		
		owner.petsSortList(5);
		pets = owner.getPets();
				
		assertEquals(pets.get(0).getPetType(),"Cheetah");
		assertEquals(pets.get(1).getPetType(),"Flamingo");
		assertEquals(pets.get(2).getPetType(),"Gecko");
		assertEquals(pets.get(3).getPetType(),"Gecko");
		assertEquals(pets.get(4).getPetType(),"Lion");
		assertEquals(pets.get(5).getPetType(),"Vulture");
		
	}
	
	@Test
	void testPetSearchById() {
	
		setUpScenario6();	
		String list, id, id2, id3;
		String[] lines, idLine, idValue;
		
		list = owner.petsSearch(1, "4");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		idLine = lines[6].split(":");
		idValue = idLine[1].split(" ");
		id2 = idValue[1];
		
		assertEquals(id, "4");
		assertEquals(id2, "4");
		
		list = owner.petsSearch(1, "1");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		idLine = lines[6].split(":");
		idValue = idLine[1].split(" ");
		id2 = idValue[1];
		
		idLine = lines[12].split(":");
		idValue = idLine[1].split(" ");
		id3 = idValue[1];
		
		assertEquals(id, "1");
		assertEquals(id2, "1");
		assertEquals(id3, "1");
		
		list = owner.petsSearch(1, "10");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		assertEquals(id, "10");
		
		list = owner.petsSearch(1, "13");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The pet(s) with that id could not be found");
	}
	
	@Test
	void testPetSearchByName() {
	
		setUpScenario7();	
		String list, name, name2, name3, name4, name5;
		String[] lines, NameLine, NameValue;
		
		list = owner.petsSearch(2, "Neko");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		assertEquals(name, "Neko");
		
		list = owner.petsSearch(2, "Sasu");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		assertEquals(name, "Sasu");
		
		list = owner.petsSearch(2, "Rei");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		assertEquals(name, "Rei");
		
		list = owner.petsSearch(2, "Jarl");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The pet(s) with that name could not be found");
		
	}

	@Test
	void testPetSearchByBirthdate() {
		
		setUpScenario8();
		String list, date, date2, date3, date4, date5;
		String[] lines, DateLine, DateValue;
		
		list = owner.petsSearch(3, "13/11/2007");
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
		
		list = owner.petsSearch(3, "23/8/2014");
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];

		assertEquals(date, "23/8/2014");
		
		list = owner.petsSearch(3, "4/8/2014");
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "4/8/2014");
		
		list = owner.petsSearch(3, "10/3/1998");
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "10/3/1998");
		
		list = owner.petsSearch(3, "19/2/2014");
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "19/2/2014");
		
		list = owner.petsSearch(3, "19/2/1400");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The pet(s) with that birthdate could not be found");
		
	}

	@Test
	void testPetSearchByGender() {
		
		setUpScenario9();
		String list, gender, gender2, gender3, gender4, gender5;
		String[] lines, GenderLine, GenderValue;
		
		list = owner.petsSearch(4, "F");
		lines = list.split("\n");
		
		GenderLine = lines[3].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender = GenderValue[1];
		
		GenderLine = lines[9].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender2 = GenderValue[1];
		
		GenderLine = lines[15].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender3 = GenderValue[1];
		
		GenderLine = lines[21].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender4 = GenderValue[1];
		
		GenderLine = lines[27].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender5 = GenderValue[1];
		
		assertEquals(gender, "F");
		assertEquals(gender2, "F");
		assertEquals(gender3, "F");
		assertEquals(gender4, "F");
		assertEquals(gender5, "F");
		
		list = owner.petsSearch(4, "M");
		lines = list.split("\n");
		
		GenderLine = lines[3].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender = GenderValue[1];
		
		GenderLine = lines[9].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender2 = GenderValue[1];
		
		GenderLine = lines[15].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender3 = GenderValue[1];
		
		GenderLine = lines[21].split(":");
		GenderValue = GenderLine[1].split(" ");
		gender4 = GenderValue[1];
		
		assertEquals(gender, "M");
		assertEquals(gender2, "M");
		assertEquals(gender3, "M");
		assertEquals(gender4, "M");
	}

	@Test
	void testPetSearchByPetType () {
		
		setUpScenario10();
		
		String list, petType, petType2, petType3, petType4, petType5;
		String[] lines, petTypeLine, petTypeValue;
		
		list = owner.petsSearch(5, "Gecko");
		lines = list.split("\n");
		petTypeLine = lines[4].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		petTypeLine = lines[10].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType2 = petTypeValue[1];
		
		petTypeLine = lines[16].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType3 = petTypeValue[1];
		
		petTypeLine = lines[22].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType4 = petTypeValue[1];
		
		petTypeLine = lines[28].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType5 = petTypeValue[1];
		
		assertEquals(petType, "Gecko");
		assertEquals(petType2, "Gecko");
		assertEquals(petType3, "Gecko");
		assertEquals(petType4, "Gecko");
		assertEquals(petType5, "Gecko");
		
		list = owner.petsSearch(5, "Cheetah");
		lines = list.split("\n");
		petTypeLine = lines[4].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Cheetah");
		
		list = owner.petsSearch(5, "Lion");
		lines = list.split("\n");
		petTypeLine = lines[4].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Lion");
		
		list = owner.petsSearch(5, "Flamingo");
		lines = list.split("\n");
		petTypeLine = lines[4].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Flamingo");
		
		list = owner.petsSearch(5, "Raccoon");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The pet(s) with that petType could not be found");
	}


}
