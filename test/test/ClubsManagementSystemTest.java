package test;
import model.ClubsManagementSystem;
import model.Club;
import model.Owner;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



class ClubsManagementSystemTest {
	
	private ClubsManagementSystem clubSystem;
	private ArrayList<Club> clubs;
	
	private void setUpScenario1(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("6", "", "", "");
		Club c2 = new Club("1", "", "", "");
		Club c3 = new Club("4", "", "", "");
		Club c4 = new Club("5", "", "", "");
		Club c5 = new Club("3", "", "", "");
		Club c6 = new Club("4", "", "", "");
		
		
		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
	
		clubSystem.setClubs(clubs);	
	}
	
	private void setUpScenario2(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("", "YuiClub", "", "");
		Club c2 = new Club("", "AlvaClub", "", "");
		Club c3 = new Club("", "JohanClub", "", "");
		Club c4 = new Club("", "JuanClub", "", "");
		Club c5 = new Club("", "ArizaClub", "", "");
		Club c6 = new Club("", "JohanClub", "", "");
		
		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
	
		clubSystem.setClubs(clubs);
		
	}
	
	private void setUpScenario3(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("", "", "10/3/1998", "");
		Club c2 = new Club("", "", "23/8/2014", "");
		Club c3 = new Club("", "", "13/11/2007", "");
		Club c4 = new Club("", "", "4/6/2003", "");
		Club c5 = new Club("", "", "19/2/2014", "");
		Club c6 = new Club("", "", "13/11/2007", "");
		
		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
	
		clubSystem.setClubs(clubs);
		
	}
	
	private void setUpScenario4(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("", "", "", "Vulture");
		Club c2 = new Club("", "", "", "Cheetah");
		Club c3 = new Club("", "", "", "Gecko");
		Club c4 = new Club("", "", "", "Lion");
		Club c5 = new Club("", "", "", "Flamingo");
		Club c6 = new Club("", "", "", "Gecko");
		
		
		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
	
		clubSystem.setClubs(clubs);	
	}
	
	private void setUpScenario5(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		ArrayList<Owner> owners = new ArrayList<Owner>();
		
		Club c1 = new Club("", "", "", "");
		Club c2 = new Club("", "", "", "");
		Club c3 = new Club("", "", "", "");
		Club c4 = new Club("", "", "", "");
		Club c5 = new Club("", "", "", "");
		Club c6 = new Club("", "", "", "");
		Owner o1 =  new Owner("114242", "", "", "");
		Owner o2 =  new Owner("121233", "", "", "");
		Owner o3 =  new Owner("341243", "", "", "");
		Owner o4 =  new Owner("344513", "", "", "");
		Owner o5 =  new Owner("45123", "", "", "");
		Owner o6 =  new Owner("31232", "", "", "");
		Owner o7 =  new Owner("13123", "", "", "");
		Owner o8 =  new Owner("13424", "", "", "");
		Owner o9 =  new Owner("31321", "", "", "");
		Owner o10 =  new Owner("45253", "", "", "");
		Owner o11 =  new Owner("14214", "", "", "");
		Owner o12 =  new Owner("12412", "", "", "");
		
		owners.add(o1);
		owners.add(o2);
		owners.add(o3);
		owners.add(o4);
		
		c1.setOwners(owners);		
		owners = new ArrayList<Owner>();
		
		owners.add(o5);
		owners.add(o6);
		
		c4.setOwners(owners);
		owners = new ArrayList<Owner>();
		
		owners.add(o7);
		owners.add(o8);
		owners.add(o9);
		
		c2.setOwners(owners);
		owners = new ArrayList<Owner>();
		
		owners.add(o10);
		
		c6.setOwners(owners);
		owners = new ArrayList<Owner>();
		
		owners.add(o11);
		owners.add(o12);
		
		c5.setOwners(owners);
		
		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
	
		clubSystem.setClubs(clubs);
	}
	
	private void setUpScenario6(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("3", "", "", "");
		Club c2 = new Club("2", "", "", "");
		Club c3 = new Club("1", "", "", "");

		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
	
		clubSystem.setClubs(clubs);	
	}
	
	private void setUpScenario7(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("", "MateoClub", "", "");
		Club c2 = new Club("", "ArizaClub", "", "");
		Club c3 = new Club("", "ArizaClub", "", "");
		Club c4 = new Club("", "JuanClub", "", "");
		Club c5 = new Club("", "ArizaClub", "", "");
		Club c6 = new Club("", "JohanClub", "", "");
		Club c7 = new Club("", "ArizaClub", "", "");
		Club c8 = new Club("", "MateoClub", "", "");
		Club c9 = new Club("", "ArizaClub", "", "");
		

		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
		clubs.add(c7);
		clubs.add(c8);
		clubs.add(c9);
	
		clubSystem.setClubs(clubs);	
	}
	
	private void setUpScenario8(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("", "", "10/3/1998", "");
		Club c2 = new Club("", "", "23/8/2014", "");
		Club c3 = new Club("", "", "13/11/2007", "");
		Club c4 = new Club("", "", "4/8/2014", "");
		Club c5 = new Club("", "", "19/2/2014", "");
		Club c6 = new Club("", "", "13/11/2007", "");
		Club c7 = new Club("", "", "13/11/2007", "");
		Club c8 = new Club("", "", "13/11/2007", "");
		Club c9 = new Club("", "", "13/11/2007", "");
		

		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
		clubs.add(c7);
		clubs.add(c8);
		clubs.add(c9);
	
		clubSystem.setClubs(clubs);	
	}
	
	private void setUpScenario9(){
		
		clubSystem = new ClubsManagementSystem();
		clubs = new ArrayList<Club>();
		
		Club c1 = new Club("", "", "", "Vulture");
		Club c2 = new Club("", "", "", "Cheetah");
		Club c3 = new Club("", "", "", "Gecko");
		Club c4 = new Club("", "", "", "Lion");
		Club c5 = new Club("", "", "", "Flamingo");
		Club c6 = new Club("", "", "", "Gecko");
		Club c7 = new Club("", "", "", "Gecko");
		Club c8 = new Club("", "", "", "Gecko");
		Club c9 = new Club("", "", "", "Gecko");
		

		clubs.add(c1);
		clubs.add(c2);
		clubs.add(c3);
		clubs.add(c4);
		clubs.add(c5);
		clubs.add(c6);
		clubs.add(c7);
		clubs.add(c8);
		clubs.add(c9);
	
		clubSystem.setClubs(clubs);	
	}
	
	@Test
	void testClubSortListById() {
		
		setUpScenario1();
		
		clubSystem.clubSortList(1);
		clubs = clubSystem.getClubs();
	
		assertEquals(clubs.get(0).getId(),"1");
		assertEquals(clubs.get(1).getId(),"3");
		assertEquals(clubs.get(2).getId(),"4");
		assertEquals(clubs.get(3).getId(),"4");
		assertEquals(clubs.get(4).getId(),"5");
		assertEquals(clubs.get(5).getId(),"6");
	}
	
	@Test
	void testClubSortListByName() {
		
		setUpScenario2();
		
		clubSystem.clubSortList(2);
		clubs = clubSystem.getClubs();
	
		assertEquals(clubs.get(0).getName(), "AlvaClub");
		assertEquals(clubs.get(1).getName(), "ArizaClub");
		assertEquals(clubs.get(2).getName(), "JohanClub");
		assertEquals(clubs.get(3).getName(), "JohanClub");
		assertEquals(clubs.get(4).getName(), "JuanClub");
		assertEquals(clubs.get(5).getName(), "YuiClub");
	}
	
	@Test
	void testClubSortListByCreationDate(){
		
		setUpScenario3();
		
		clubSystem.clubSortList(3);
		clubs = clubSystem.getClubs();		
		
		assertEquals(clubs.get(0).getCreationDate(), "10/3/1998");
		assertEquals(clubs.get(1).getCreationDate(), "4/6/2003");
		assertEquals(clubs.get(2).getCreationDate(), "13/11/2007");
		assertEquals(clubs.get(3).getCreationDate(), "13/11/2007");
		assertEquals(clubs.get(4).getCreationDate(), "19/2/2014");
		assertEquals(clubs.get(5).getCreationDate(), "23/8/2014");
	}
	
	@Test
	void testClubSortListByPetType(){
		
		setUpScenario4();
		
		clubSystem.clubSortList(4);
		clubs = clubSystem.getClubs();
	
		assertEquals(clubs.get(0).getPetType(), "Cheetah");
		assertEquals(clubs.get(1).getPetType(), "Flamingo");
		assertEquals(clubs.get(2).getPetType(), "Gecko");
		assertEquals(clubs.get(3).getPetType(), "Gecko");
		assertEquals(clubs.get(4).getPetType(), "Lion");
		assertEquals(clubs.get(5).getPetType(), "Vulture");
	}
	
	@Test
	void testClubSortListByNumberOfOwners(){
		
		setUpScenario5();
		
		clubSystem.clubSortList(5);
		clubs = clubSystem.getClubs();
	
		assertEquals(clubs.get(0).getNumberOfOwners(), 0);
		assertEquals(clubs.get(1).getNumberOfOwners(), 1);
		assertEquals(clubs.get(2).getNumberOfOwners(), 2);
		assertEquals(clubs.get(3).getNumberOfOwners(), 2);
		assertEquals(clubs.get(4).getNumberOfOwners(), 3);
		assertEquals(clubs.get(5).getNumberOfOwners(), 4);
	}
	
	@Test
	void testClubSearchById(){
		
		setUpScenario6();
		String list, id;
		String[] lines, idLine, idValue;
		
		list = clubSystem.clubSearch(1, "1");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		assertEquals(id, "1");
		
		list = clubSystem.clubSearch(1, "2");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		assertEquals(id, "2");
		
		list = clubSystem.clubSearch(1, "3");
		lines = list.split("\n");
		idLine = lines[0].split(":");
		idValue = idLine[1].split(" ");
		id = idValue[1];
		
		assertEquals(id, "3");
		
		list = clubSystem.clubSearch(1, "4");
		lines = list.split("\n");
		id = lines[0];
		
		assertEquals(id , "The club with that id could not be found");
		
		clubs = clubSystem.getClubs();			
	}
	
	@Test
	void testClubSearchByName(){
		
		setUpScenario7();
		String list, name, name2, name3, name4, name5;
		String[] lines, NameLine, NameValue;
		
		list = clubSystem.clubSearch(2, "ArizaClub");
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

		assertEquals(name, "ArizaClub");
		assertEquals(name2, "ArizaClub");
		assertEquals(name3, "ArizaClub");
		assertEquals(name4, "ArizaClub");
		assertEquals(name5, "ArizaClub");
		
		list = clubSystem.clubSearch(2, "JohanClub");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];

		assertEquals(name, "JohanClub");
		
		list = clubSystem.clubSearch(2, "MateoClub");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		NameLine = lines[7].split(":");
		NameValue = NameLine[1].split(" ");
		name2 = NameValue[1];
		
		assertEquals(name, "MateoClub");
		assertEquals(name2, "MateoClub");
		
		list = clubSystem.clubSearch(2, "JuanClub");
		lines = list.split("\n");
		NameLine = lines[1].split(":");
		NameValue = NameLine[1].split(" ");
		name = NameValue[1];
		
		assertEquals(name, "JuanClub");
		
		list = clubSystem.clubSearch(2, "ddads");
		lines = list.split("\n");
		
		assertEquals(lines[0], "The club(s) with that name could not be found");
	}
	
	@Test
	void testClubSearchByCreationDate(){
		
		setUpScenario8();
		String list, date, date2, date3, date4, date5;
		String[] lines, DateLine, DateValue;
		
		list = clubSystem.clubSearch(3, "13/11/2007");
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
		
		list = clubSystem.clubSearch(3, "10/3/1998"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "10/3/1998");
		
		list = clubSystem.clubSearch(3, "23/8/2014"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "23/8/2014");
		list = clubSystem.clubSearch(3, "4/8/2014"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "4/8/2014");
		
		list = clubSystem.clubSearch(3, "19/2/2014"); 
		lines = list.split("\n");
		DateLine = lines[2].split(":");
		DateValue = DateLine[1].split(" ");
		date = DateValue[1];
		
		assertEquals(date, "19/2/2014");	
	}
	
	@Test
	void testClubSearchByPetType(){
		
		setUpScenario9();
		String list, petType, petType2, petType3, petType4, petType5;
		String[] lines, petTypeLine, petTypeValue;
		
		list = clubSystem.clubSearch(4, "Gecko");
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
		
		list = clubSystem.clubSearch(4, "Vulture");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Vulture");
		
		list = clubSystem.clubSearch(4, "Cheetah");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Cheetah");
		
		list = clubSystem.clubSearch(4, "Lion");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Lion");
		
		list = clubSystem.clubSearch(4, "Flamingo");
		lines = list.split("\n");
		petTypeLine = lines[3].split(":");
		petTypeValue = petTypeLine[1].split(" ");
		petType = petTypeValue[1];
		
		assertEquals(petType, "Flamingo");
		
	}
}
