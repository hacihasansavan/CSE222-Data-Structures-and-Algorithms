package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import hmw1.*;

public class TestHmw {

	public static void main(String[] args) {
		
		double startTime,endTime,executionTime;
		
		//Menu();
		startTime = System.nanoTime();
		Driver();
		endTime = System.nanoTime();
		executionTime = endTime - startTime;
		
		System.out.println("\nExecution Time: "+ executionTime/1000000);
				
	}
	private static void Driver() {/*Theta(N^3)*/
		
		
		Street_AList kemerSokak = new Street_AList(120);/*Constant Time*/
		kemerSokak.setRigthBuildings(new ArrayList<Structure>());/*Constant Time*/
		kemerSokak.setLeftBuildings(new ArrayList<Structure>());/*Constant Time*/
				
		
		
		
		/*----------------------------------------------------------------------*/
		
		System.out.println("\n");
		/*vvv Adding new element (IN CORRECT FORM) vvv*/
		System.out.println("Adding new Elements: ");
		try {
			
			for(int i=0; i<10; i++)
				kemerSokak.getRigthBuildings().add(new House(0, 1, 14, "Elon Husky", 10, "Bed"));	 /*O(1)*/
				
			

		}

		catch(Exception  s){
			System.out.print(s.getMessage());
		}
		/*^^^ Adding new element (IN CORRECT FORM) ^^^*/
		
		//Current state of street
		System.out.println("\n##");
		System.out.println("Current state of Street: \n");
		kemerSokak.displayBuildingList();				 /*Theta(N)*/
		System.out.println("##\n");
		
		System.out.println("---------------------------------------------------");
		
		/*vvv Deleting an element (IN CORRECT FORM) vvv*/
		try {
			/*O(N)*/
			System.out.println("deleted: "+ kemerSokak.getRigthBuildings().remove(0).toString());
			System.out.println("deleted: "+ kemerSokak.getLeftBuildings().remove(0).toString());

		}
		catch(Exception  s){
			System.out.print(s.getMessage());
		}
		/*^^^ Deleting an element (IN CORRECT FORM ^^^*/
		
		//Current state of street
		System.out.println("\n##");
		System.out.println("Current state of Street: ");
		kemerSokak.displayBuildingList();				/*Theta(N)*/
		System.out.println("##\n");
		
		/*------------------------------------------------------------------------*/
		
		System.out.println("\n");
		/*vvv Adding new element (IN WRONG FORM) vvv*/
		System.out.println("Adding new Elements: ");
		try {
			
			Office s = new Office(0, 8, 20, "Behcet nahlet", "mafya");
			Market ss = new Market(19, 12, 30, "Kemal Yilan", "06.00","23.00");
			System.out.println("added: "+ s.toString());
			System.out.println("added: "+ ss.toString());
			kemerSokak.getRigthBuildings().add(s);	 
			kemerSokak.getLeftBuildings().add(ss);
		}

		catch(Exception  s){
			System.out.print(s.getMessage());
		}
		/*^^^ Adding new element (IN WRONG FORM) ^^^*/
		
		/*vvv Viewing Mode Functions vvv*/
		
		System.out.println("\nDisplay Remaining length of lands");
		kemerSokak.displayRemainingLands();				/*Theta(N)*/
		
		System.out.println("\nDisplay List of Building");
		kemerSokak.displayBuildingList();				/*Theta(N)*/
		
		System.out.println("\nDisplay the number and ratio of lenth of playgrounds in the street.");
		kemerSokak.displayPlayGNumberAndRatio();		/*Theta(N)*/
		
		System.out.println("\nTotal length of street occupied by the markets, houses or offices.");
		System.out.println("Total: "+kemerSokak.getOccupiedLengths());		/*Theta(N)*/
		

		System.out.println("\nSkyline silhouette of the street: ");
		System.out.println("It's not similur to the example in pdf because we deleted some of them above: ");
		kemerSokak.DrawSilhouette();			/*Theta(N^3)*/
		
		/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/

		/*vvv Focusing vvv*/
		
		System.out.println("\nFocusing on buildings: ");
		for(int i=0; i<kemerSokak.getRigthBuildings().size();++i) 	/*Theta(N)*/
			kemerSokak.getRigthBuildings().get(i).presentInfo();
		
		for(int i=0; i<kemerSokak.getLeftBuildings().size();++i)	/*Theta(N)*/
			kemerSokak.getLeftBuildings().get(i).presentInfo();
		
		/*O(N^2)*/
		System.out.println("\nCotrolling that There is a building in 10!!");
		if(!Street_AList.isValidPlace(kemerSokak.getLeftBuildings(),10,30))
			System.out.println("There is already a building!!");

		/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/
		
		
	}
	/**
	 * Menu*/
	public static void Menu() {
		
		//Street kemerSokak = new Street(100);
		Scanner sc= new Scanner(System.in);		
		int x=0;
		
		Street_AList kemerSokak = new Street_AList(x);
	    kemerSokak.setRigthBuildings(new ArrayList<Structure>());
	    kemerSokak.setLeftBuildings(new ArrayList<Structure>());
		boolean endThisRun = false;
		while(!endThisRun) {
			int userModeChoice=0,choice2=0;
			boolean exitUserMode=false,exitSubUserModes=false;
			boolean invalidOption=false;
			System.out.println("\n\n-------------Welcome-------------\n");
			System.out.println("1. Driver Mode");
			System.out.println("2. User Mode");
			System.out.println("3. Exit\n");
			if(sc.hasNextInt()) 
				userModeChoice = sc.nextInt();
	           
	        else {
            	System.out.println("Invalid Option!!");
    			invalidOption = true;
    			endThisRun = true;
	            }

			
			if(userModeChoice==3) {
				System.out.println("\nExiting...");
				endThisRun=true;
				exitUserMode=true;
			}
			else if(userModeChoice ==1) Driver();
			//user mode
			boolean takeLength=true;
			while(userModeChoice==2 && !exitUserMode && !invalidOption) {
				System.out.println("\n-------------USER MODE-------------\n");
				
				//BURAYI ACARSIN
			    while(takeLength) {
			    	System.out.print("Please enter the length of street: ");
			    	x = sc.nextInt();
			    	
			    	if(x>0) {
			    		takeLength = false;
			    		break;
			    	}
			    	else System.out.println("Invalid Size Input!!\n");
			    }

				

			    kemerSokak.setLength(x);
				System.out.println("1. Editing Mode");
				System.out.println("2. Viewing Mode");
				System.out.println("3. Focusing Mode");
				System.out.println("4. Exit");
				sc.nextLine();
				if(sc.hasNextInt()) 
					choice2 = sc.nextInt();
		           
		        else {
	            		System.out.println("Invalid Option!!");
	            		//sc.next();
	            		//invalidOption = true;
		            }
				
				if(choice2 == 4)
					exitUserMode=true;
				else exitSubUserModes = false; 
				/*----------------------EDITING MODE-------------------------*/
				while(choice2==1 && !exitSubUserModes) {
					System.out.println("\n-------------EDITING MODE-------------\n");
					
					System.out.println("Current state: \n");
					kemerSokak.displayBuildingList();
					System.out.println("\n---------------------\n");
					
					System.out.println("1. Add new ");
					System.out.println("2. Delete");
					System.out.println("3. Exit");
					int ch = sc.nextInt();

					/*----------------------Adding Part-------------------------*/

					if(ch==1) {
						//sc.nextLine();
						System.out.println("Which one Do You Wanna add?");
						System.out.println("1. Office");
						System.out.println("2. House");
						System.out.println("3. Market");
						System.out.println("4. Playground");
						int ch1 =sc.nextInt();
						
						kemerSokak.AddNewOne(ch1,kemerSokak);
						kemerSokak.displayRemainingLands();
					}
					/*----------------------Deleting Part-------------------------*/
					else if(ch==2) {
						//sc.nextLine();
						int ch1 = 0;
						int s;
						System.out.print("From which side would you like to delete? Rigth-> 1, Left->2: ");
						ch1 = sc.nextInt();
						//sc.nextLine();
						System.out.println("Enter the Structure's start  position");
						s = sc.nextInt();
						try {
							if(s<kemerSokak.getLength()) {
								
								if(ch1==1)
									Delete(s,kemerSokak.getRigthBuildings()); 
								else if(ch1 ==2)
									Delete(s,kemerSokak.getLeftBuildings());
							}
							else throw new Exception("ERROR: Given Structure's size exceeded the Street size");
						}
						
						catch(Exception  exc){
							System.out.print(exc.getMessage());
						}
						
					}
					/*--------------------------Exit-----------------------------*/
					else if(ch==3) {
						exitSubUserModes = true;
					}
					
					else System.out.println("\nInvalid Option!!\n"); //try catch 
				}
				/*--------------------------END OF EDITING MODE-----------------------------*/
				
				/*--------------------------VIEWING MODE-----------------------------*/
				while(choice2==2 && !exitSubUserModes) {
					//2. Viewing Mode
					//sc.nextLine();
					int ch;
					System.out.println("1. Display Remaining length of Land");
					System.out.println("2. Display the list of buildings on the street.");
					System.out.println("3. Display the number and ratio of lenth of playgrounds in the street.");
					System.out.println("4. Total length of street occupied by the markets, houses and offices.");
					System.out.println("5. Display the skyline silhouette of the street");
					System.out.println("6. Exit");
					ch = sc.nextInt();
					switch(ch) {
					case 1:
						kemerSokak.displayRemainingLands();
						break;
					case 2:
						kemerSokak.displayBuildingList();
						break;
					case 3:
						kemerSokak.displayPlayGNumberAndRatio();
						break;
					case 4:
						System.out.println("Total length of all markets,offices,houses: "+kemerSokak.getOccupiedLengths());
						break;
					case 5:
						kemerSokak.DrawSilhouette();
						break;
					case 6:
						exitSubUserModes = true;
						System.out.println();
						break;
					default: System.out.println("Invalid Input!!"); //try-catch?
					}
					System.out.println();
				}
				/*--------------------------END OF VIEWING MODE-----------------------------*/
				
				/*--------------------------FOCUSING MODE-----------------------------*/
				while(choice2==3 && !exitSubUserModes) {
					int ch;
					kemerSokak.displayBuildingList();
					System.out.println();
					System.out.println("1. Focus on a specific  House");
					System.out.println("2. Focus on a specific  Offices");
					System.out.println("3. Focus on a specific  Markets");
					System.out.println("4. Focus on a specific  Playgrounds");
					System.out.println("5. Exit");
					ch = sc.nextInt();
					int pos=0,side=0;
					if(ch!=5) {
						//sc.nextLine();
						System.out.print("which side do you wanna look at? Rigth-> 1, Left->2: ");
						side = sc.nextInt();
						//sc.nextLine();
						if(side!=1 && side!=2)
							System.out.println("Invalid Input!!"); //try-catch?
						else {
							System.out.print("Enter Start Position: ");
							pos = sc.nextInt();
						}
					}
					try {
						
						if(side==1) {
							int t = Street_AList.findFocusingIndex(pos,kemerSokak.getRigthBuildings());
							if(t==-1)
								System.out.println("Given Position is not correct!!");
							else kemerSokak.getRigthBuildings().get(t).presentInfo();
						}
						else if(side==2) {
							int t = Street_AList.findFocusingIndex(pos,kemerSokak.getLeftBuildings());
							
							if(t==-1)
								System.out.println("Given Position is not correct!!");
							else kemerSokak.getLeftBuildings().get(t).presentInfo();
						}
					}
					catch(Exception  s){
						System.out.print(s.getMessage());
					}
					if(ch==5) exitSubUserModes=true; //exit
				}
				/*--------------------------END OF FOCUSING MODE-----------------------------*/
			}
			System.out.println("---------------------------------\n");
			
			
			
		}

		//sc.close();
	}
	
	
	
	
	/*Deleting a structure on street helper methods for testing*/
	// 1 is rigth 2 is left
	public static <E>void Delete(int startPos, ArrayList<Structure> str) throws Exception{
		

		int index = Street_AList.findObjIndex(startPos,str);
		
		if(str.size()!=0) {
			
			System.out.println("\nDeleted: ");  
			System.out.println(str.get(index).toString());
			System.out.println();
			try {
				str.remove(index);
			}
			
			catch(Exception  s){
				throw s;
			}
		}
		else System.out.println("\nThe Given Street is already empty!!! "); 
		

		//else System.out.println("Invalid Input!!");
	}
	//if cannot find throws error
	
	
	

		/*------------------------------------------------------*/
	}
