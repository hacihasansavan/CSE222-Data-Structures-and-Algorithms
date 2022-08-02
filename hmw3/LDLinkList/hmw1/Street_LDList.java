package hmw1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <h1>Street_AList Class</h1>
 * Just Street Class but with ArrayList
 * @author Haci Hasan Savan
 * @since 2022-03-03
 *
 * */
public class Street_LDList extends Structure{

	private int length;
	//private int[] xAxis; /*it will either 1 or 0. 1 means it's full, 0 means empty*/
	private LDLinkedList<Structure> leftSideBuildings;  
	private LDLinkedList<Structure> rigthSideBuildings;
	private char[][] arr2d ;//= new char[100][100]; //2d coordinate plane. buildings' inside -> * , border -> +
												
	
	/**
	 * Theta(1)
	 * Constructor
	 * @param  _length street length
	 * */
	public Street_LDList(int _length){
		this.length = _length;
		//xAxis = new int[length];
		
	}
	/**
	 * Theta(1)
	 * */
	public LDLinkedList<Structure> getRigthBuildings(){
		return rigthSideBuildings;
	}
	/**
	 * Theta(1)
	 * */
	public LDLinkedList<Structure> getLeftBuildings(){
		return leftSideBuildings;
	}
	/**
	 * Theta(1)
	 * */
	public void setRigthBuildings(LDLinkedList<Structure> s){
		rigthSideBuildings = s;
	}
	/**
	 * Theta(1)
	 * */
	public void setLeftBuildings(LDLinkedList<Structure> s){
		leftSideBuildings = s;
	}
	/*viewing mode methods*/
	
	/**
	 * Time Complexity: Theta(n^2)
	 * @return Remaining size in the right side of the street
	 * */
	public int getRigthRemaining() {
		int rigth=0;
		for(int i=0; i<rigthSideBuildings.size(); ++i) {	
			rigth +=rigthSideBuildings.get(i).getLength();
		}
		rigth = this.length - rigth;
		return rigth;
	}
	/**
	 * Time Complexity: Theta(n^2)
	 * @return Remaining size in the left side of the street
	 * */
	public int getLeftRemaining() {
		int left=0;
		for(int i=0; i<leftSideBuildings.size(); ++i) {	
			left +=leftSideBuildings.get(i).getLength();
		}
		left = this.length - left;
		return left;
	}
	/**
	 * Time Complexity: Theta(n^2)
	 *  Prints the total remaining size in the street (right+left sides of street)
	 * */
	public void displayRemainingLands() {
		int r = getRigthRemaining(),l =getLeftRemaining();
		int total = r+l;
		System.out.println("on the Rigth Side: "+r);
		System.out.println("on the Left Side: "+l);
		System.out.println("Total Remaining: "+total);
	}
	
	/**
	 * Time Complexity: O(n^2)
	 * Compares given start point (sPoint) and the others in the street (str)
	 * if they are equal then returns it
	 * @param sPoint Start point of an object that is in the street
	 * @param str left side street or right side street
	 * @return Object index
	 * 
	 * */
	public static int findObjIndex(int sPoint, LDLinkedList<Structure> str){
		int rValue=-1;
		
		if(str.size() ==0) rValue = 0;
		for(int i=0; i<str.size();++i) {
			//System.out.println("find object index: "+str.get(i).getStartPos());
			if(sPoint<= str.get(i).getStartPos()) {
				rValue = i;
				break;
			}
			else rValue = str.size();
		}
		//if(rValue==-1) 
			//System.out.println("throw error here"); //try-catch
		return rValue;
	}
	
	/**
	 * Time Complexity: Theta(n^2)
	 * Compares given start point (sPoint) and the others in the street (str)
	 * if they are equal then returns it
	 * @param sPoint Start point of an object that is in the street
	 * @param str left side street or right side street
	 * @return Object index
	 * 
	 * */
	public static int findFocusingIndex(int sPoint, LDLinkedList<Structure> str){
		int rValue=-1;
		for(int i=0; i<str.size();++i) {
			//System.out.println("find object index: "+str.get(i).getStartPos());
			if(sPoint == str.get(i).getStartPos()) {
				rValue = i;
				break;
			}

		}
		//if(rValue==-1) 
			//System.out.println("throw error here"); //try-catch
		return rValue;
	}
	

	/**
	 * Time Complexity: O(n^2)
	 * Prints the Current Building list on the left and on the right
	 * */
	public void displayBuildingList() {
			System.out.println("Rigth: ");
			for(int i=0; i<rigthSideBuildings.size(); ++i) {
				if(rigthSideBuildings.get(i) instanceof Office)
					System.out.print("Office: ");
				else if(rigthSideBuildings.get(i) instanceof Market)
					System.out.print("Market: ");
				else if(rigthSideBuildings.get(i) instanceof House)
					System.out.print("House:  ");
				else if(rigthSideBuildings.get(i) instanceof Playground)
					System.out.print("Playground: ");
				System.out.println(i+1+". "+rigthSideBuildings.get(i).toString());
			}
			System.out.println("------------");
			System.out.println("Left: ");
			for(int i=0; i<leftSideBuildings.size(); ++i) {
				if(leftSideBuildings.get(i) instanceof Office)
					System.out.print("Office: ");
				else if(leftSideBuildings.get(i) instanceof Market)
					System.out.print("Market: ");
				else if(leftSideBuildings.get(i) instanceof House)
					System.out.print("House: ");
				else if(leftSideBuildings.get(i) instanceof Playground)
					System.out.print("Playground: ");
				System.out.println(i+1+". "+leftSideBuildings.get(i).toString());
			}
	}

	/**
	 * Time Complexity: O(n^2)
	 * Prints the playgrounds number and (total playgrounds size )/(street total land size)
	 * */
	public void displayPlayGNumberAndRatio() {
		int pNum=0;
		float pSize=0;
		for(int i=0; i<rigthSideBuildings.size(); ++i) {
			if(rigthSideBuildings.get(i) instanceof Playground) {
				pSize+= rigthSideBuildings.get(i).getLength();
				pNum++;
			}
		}
		
		for(int i=0; i<leftSideBuildings.size(); ++i) {
			if(leftSideBuildings.get(i) instanceof Playground) {
				pSize+= leftSideBuildings.get(i).getLength();
				pNum++;
			}
		}
		System.out.println("Playground number: "+pNum);
		float ratio = pSize/(length*2); 
		System.out.println("Ratio of lenth of playgrounds: "+ ratio + " ("+pSize+"/"+length*2+")");
	}
	
	/**
	 * Time Complexity: Theta(n^3)
	 * Returns the highest building's height in the street. This will be used while creating 
	 * the 2d grid that includes Silhouette. 
	 * */
	private int getMaxHeight() {
		int h=0;
		for(int i=0; i<rigthSideBuildings.size(); ++i) {
			if(rigthSideBuildings.get(i).getHeight() > h)
				h = rigthSideBuildings.get(i).getHeight();
		}
		for(int i=0; i<leftSideBuildings.size(); ++i) {
			if(leftSideBuildings.get(i).getHeight() > h)
				h = leftSideBuildings.get(i).getHeight();
		}
		return h;
	}




	/**
	 * Time Complexity: O(n^2)
	 * Draws 2d grid to the screen
	 * */
	private void draw2dPlane() {
		boolean doIt=false;
		mirror();
		boolean isItFullyEmpty = true;
		//int max = getMaxHeight();
		for(int i=arr2d.length-1; i>=0; --i) {
			for(int k=arr2d[i].length-1; k>=0; --k) {
				if(arr2d[i][k]!=' ') {
					isItFullyEmpty = false;
					break;
				}
					
			}
			if(!isItFullyEmpty) {
				
				for(int k=arr2d[i].length-1; k>=0; --k) {
					
					System.out.print(arr2d[i][k]);
					if(arr2d[i][k]!=' ') doIt=true;
				}
				
				if(doIt)
				{
					System.out.print("\n");
					doIt=false;
				}
			}
		}
	}
	
	/**
	 * Time Complexity is O(n^2)
	 * Converts 2d grid to it's mirror view
	 * */
	public void mirror() {
		//int temp;
	    for (int i = 0; i < arr2d.length; i++){
	        for (int j = 0; j < arr2d[i].length/2; j++){
	            char temp = arr2d[i][j];
	            arr2d[i][j] = arr2d[i][arr2d[i].length-j-1];
	            arr2d[i][arr2d[i].length-j-1] = temp;
	        }
	    }
	}
	
	/**
	 * Time Complexity: O(n^3)
	 * Calculates the total length of street occupied by the markets, houses or offices
	 * While total value will be returned, the the others will be printed out
	 * @return Total Occupied Lengths by markets, houses and offices
	 * */
	public int getOccupiedLengths() {
		int oNum=0;
		int house=0,office=0,market=0;
		for(int i=0; i<rigthSideBuildings.size(); ++i) {
			if(rigthSideBuildings.get(i) instanceof Office) {
				
				oNum += rigthSideBuildings.get(i).getLength();
				office += rigthSideBuildings.get(i).getLength();
			}
			if(rigthSideBuildings.get(i) instanceof Market) {
				
				oNum += rigthSideBuildings.get(i).getLength();
				market += rigthSideBuildings.get(i).getLength();
			}
			if(rigthSideBuildings.get(i) instanceof House) {
				oNum += rigthSideBuildings.get(i).getLength();
				house += rigthSideBuildings.get(i).getLength();
			}
				
		}
		for(int i=0; i<leftSideBuildings.size(); ++i) {
			if(leftSideBuildings.get(i) instanceof Office) {
				
				oNum += leftSideBuildings.get(i).getLength();
				office += leftSideBuildings.get(i).getLength();
			}
			if(leftSideBuildings.get(i) instanceof Market) {
				
				oNum += leftSideBuildings.get(i).getLength();
				market += leftSideBuildings.get(i).getLength();
			}
			if(leftSideBuildings.get(i) instanceof House) {
				oNum += leftSideBuildings.get(i).getLength();
				house += leftSideBuildings.get(i).getLength();
			}
		}
		
		System.out.println("Office: "+office);
		System.out.println("Market: "+market);
		System.out.println("House: "+house);
		return oNum;
	}
	
	/**
	 * theta(1)
	 * */
	@Override
	public int getLength() {
		return length;
	}
	/**
	 * Time Complexity: Theta(n^3)
	 * Draws Skyline silhouette to a 2d char grid. Travels in the arr2d 
	 * if coordinates of arr2d within the height and width boundaries then add there
	 * to the char character
	 * */
	public void DrawSilhouette() {
		char border = '.';
		initialize2dArr();

		for(int i=0; i<arr2d.length; ++i) {
			for(int j=0; j<arr2d[i].length; ++j) {
				for(int k=0;k<rigthSideBuildings.size(); ++k) {
					if(j<=rigthSideBuildings.get(k).getHeight() && i>=rigthSideBuildings.get(k).getStartPos() 
							&& i<=rigthSideBuildings.get(k).getEndingPos()) {
						/*if(j==rigthSideBuildings.get(k).getHeight()) {
							arr2d[j][i]='|';
						
						}*/
						 arr2d[j][i]=border;
					}
				}
			}
		}
		for(int i=0; i<arr2d.length; ++i) {
			for(int j=0; j<arr2d[i].length; ++j) {
				for(int k=0;k<leftSideBuildings.size(); ++k) {
					if(j<=leftSideBuildings.get(k).getHeight() && i>=leftSideBuildings.get(k).getStartPos() 
							&& i<=leftSideBuildings.get(k).getEndingPos()) {
						
						if(arr2d[j][i]!=border)
							arr2d[j][i]=border;
						
					}
				}
			}
		}

		for(int i=0; i<arr2d[0].length;++i) {
			arr2d[0][i]=border;
		}
		
		draw2dPlane();
	}
	
	/*public void clearInside() {
		//int x =getMaxHeight()+10;
		//char[][] tempArr = new char[length][length];
		for(int i=0; i<arr2d.length; ++i) {
			for(int j=0; j<arr2d[i].length;++j) {
				
				if(i+1<=arr2d.length && i-1>=0 && j+1<=arr2d[i].length && j+1>=arr2d[i].length) {
					if(arr2d[i][j+1]==border)
				}
			
				
			}
		}
	}*/
	
	/**
	 * Time Complexity is Theta(1)
	 * Sets Street length
	 * */
	@Override
	public void setLength(int newLength) {
		this.length = newLength;
	}
	/**
	 * Time Complexity is O(n^2)
	 * Creates an enough size array and initializes it with whitespace
	 * */
	private void initialize2dArr() {
		
		int x =getMaxHeight()+10;
		x=length;
		
		//System.out.println("max:" +x);
		arr2d = new char[x][length];
		if(length>0) {
			
			for(int i=0; i<arr2d.length; i++) {
				for(int k=0; k<arr2d[i].length; ++k)
					arr2d[i][k] =' ';
			}
		}
		else System.out.println("Street length is 0!!!");
	}
	/**
	 * Time Complexity is Theta(1)
	 * @return an MyArray that includes left Side of Street structures
	 * */
	public LDLinkedList<Structure> getLeftSideBuildings() {
		return leftSideBuildings;
	}
	/**
	 * Time Complexity is Theta(1)
	 * Sets the left Side of The Street
	 * @param leftBuildings is an MyArray that includes left Side of Street structures
	 * */
	public void setLeftSideBuildings(LDLinkedList<Structure> leftBuildings) {
		this.leftSideBuildings = leftBuildings;
	}
	/**
	 * Time Complexity is Theta(1)
	 * @return an MyArray that includes right Side of Street structures
	 * */
	public LDLinkedList<Structure> getRightSideBuildings() {
		return rigthSideBuildings;
	}
	/**
	 * Time Complexity is Theta(1)
	 * Sets the right Side of The Street
	 * @param rightBuildings is an MyArray that includes right side or left side of Street structures
	 * */
	public void setRightSideBuildings(LDLinkedList<Structure> rightBuildings) {
		this.rigthSideBuildings = rightBuildings;
	}
	/**
	 * Time Complexity is O(n^4)
	 * */
	public static boolean isValidPlace(LDLinkedList<Structure> arr,int position,int length) {
		
		//boolean rValue=true;
		int endPos = position+length;
		for(int i=0; i<arr.size();++i) {
			if(position>=arr.get(i).getStartPos() && endPos<=arr.get(i).getEndingPos())
				return false;
			for(int j=position; j<endPos;++j) {
				if(j==arr.get(i).getStartPos() || j==arr.get(i).getEndingPos()) {
					return false;
				}
			}
			
		}
		return true;
	}
	/**
	 * Time Complexity is Theta(1)
	 * checks if given position is in boundaries or not
	 * @param pos start position of structure
	 * @param len length of structure
	 * @return true if it is in boundaries of street*/
	private boolean isItInBoundaries(int pos,int len) {
		int streetSize = length;
		System.out.println("streetSize: "+streetSize);
		System.out.println("pos: "+pos);
		System.out.println("len: "+len);
		if(pos>=streetSize)
			return false;
		else if(len>=streetSize)
			return false;
		else if(pos+len>streetSize)
			return false;
		else if(pos<0 || len<=0 || pos+len<0)
			return false;
		return true;
	}
	/**
	 * Time Complexity: O(n^4)
	 * Creates Office Object and puts it into the street array properly
	 * @param arr is an MyArray that includes right Side or left side of Street structures
	 * */
	private void createOffice(LDLinkedList<Structure> arr) {
		int position,length,heigth;
		String owner,jobType;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("position: ");
		position = sc.nextInt();
		System.out.print("length: ");
		length = sc.nextInt();
		System.out.print("heigth: ");
		heigth = sc.nextInt();
		sc.nextLine();
		System.out.print("owner: ");
		owner = sc.nextLine();
		System.out.print("jobType: ");
		jobType = sc.nextLine();
		if(!isItInBoundaries(position,length)) {
			System.out.print("ERROR: Given Structure's size exceeded the Street size");
		}
		else {
			
			int index=0;
			try {
				
				index = findObjIndex(position, arr);
			}
			catch(Exception  s){
				System.out.print(s.getMessage());
			}
			boolean valid = true;
			if(!isValidPlace(arr,position,length)) {
				valid = false;
				System.out.println("There is already a building!!");			
			}
			//System.out.println("\n\n eklenmek istenen yer: "+ index+"\n\n");
			try {
				if(valid) {
					System.out.println("\n\nNew Office Added: ");
					arr.add(index,new Office(position,length,heigth,owner,jobType));					
				}
			}
			
			catch(Exception  s){
				System.out.print(s.getMessage());
			}
		}
		//sc.close();
	}
	


	/**
	 * Time Complexity: O(n^4)
	 * Creates Market Object and puts it into the street array properly
	 * @param arr is an MyArray that includes right Side or left side of Street structures
	 * */
	private void createMarket(LDLinkedList<Structure> arr){
		int position,length,heigth;
		String owner,oTime,cTime;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("poisiton: ");
		position = sc.nextInt();
		System.out.print("length: ");
		length = sc.nextInt();
		System.out.print("heigth: ");
		heigth = sc.nextInt();
		sc.nextLine();
		System.out.print("Owner: ");
		owner = sc.nextLine();
		System.out.print("Opening time: ");
		oTime = sc.nextLine();
		System.out.print("Closing Time: ");
		cTime = sc.nextLine();
		
		if(!isItInBoundaries(position,length)) {
			System.out.print("ERROR: Given Structure's size exceeded the Street size");
		}
		else {
			
			int index =0;
			try {
				
				index = findObjIndex(position, arr);
			}
			catch(Exception  s){
				System.out.print(s.getMessage());
			}
			boolean valid = true;
			if(!isValidPlace(arr,position,length)) {
				valid = false;
				System.out.println("There is already a building!!");			
			}
			
			//System.out.println("\n\n eklenmek istenen yer: "+ index+"\n\n");
			try {
				if(valid) {
					System.out.println("\n\nNew Market Added: ");
					arr.add(index,new Market(position,length,heigth,owner,oTime,cTime));					
				}
			}
			
			catch(Exception  s){
				System.out.print(s.getMessage());
			}
		}
		//sc.close();
	}
	/**
	 * Time Complexity: O(n^4)
	 * Creates House Object and puts it into the street array properly
	 * @param arr is an MyArray that includes right Side or left side of Street structures
	 * */
	private void createHouse(LDLinkedList<Structure> arr) {
		int position,length,heigth,roomNum;
		String color,owner;
		
		Scanner sc= new Scanner(System.in);
		System.out.print("poisiton: ");
		position = sc.nextInt();
		System.out.print("length: ");
		length = sc.nextInt();
		System.out.print("heigth: ");
		heigth = sc.nextInt();
		sc.nextLine();
		System.out.print("Owner: ");
		owner = sc.nextLine();
		System.out.print("Room Num: ");
		roomNum = sc.nextInt();
		sc.nextLine();
		System.out.print("Color: ");
		color = sc.nextLine();
		if(!isItInBoundaries(position,length)) {
			System.out.print("ERROR: Given Structure's size exceeded the Street size");
		}
		else {
			
			int index=0;
			boolean valid = true;
			try {
				
				index = findObjIndex(position, arr);			
			}
			catch(Exception  s){
				System.out.print(s.getMessage());
			}
			if(!isValidPlace(arr,position,length)) {
				valid = false;
				System.out.println("There is already a building!!");			
			}
			//System.out.println("\n\n eklenmek istenen yer: "+ index+"\n\n");
			try {
				if(valid) {
					
					System.out.println("\n\nNew House Added: ");
					arr.add(index,new House(position,length,heigth,owner,roomNum,color));
				}
			}
			
			catch(Exception  s){
				System.out.print(s.getMessage());
			}

		}
		
		//sc.close();
	}
	/**
	 * Time Complexity: O(n^4)
	 * Creates Playground Object and puts it into the street array properly
	 * @param arr is an MyArray that includes right Side or left side of Street structures
	 * */
	private void createPlayground(LDLinkedList<Structure> arr) {
		int position,length;
		
		Scanner sc= new Scanner(System.in);
		System.out.print("poisiton: ");
		position = sc.nextInt();
		System.out.print("length: ");
		length = sc.nextInt();
		if(!isItInBoundaries(position,length)) {
			System.out.print("ERROR: Given Structure's size exceeded the Street size");
		}
		else {
			
			int index=0;
			try {
				index = findObjIndex(position, arr);			
			}
			catch(Exception  s){
				System.out.print(s.getMessage());
			}
			boolean valid = true;
			if(!isValidPlace(arr,position,length)) {
				valid = false;
				System.out.println("There is already a building!!");			
			}
			//System.out.println("\n\n eklenmek istenen yer: "+ index+"\n\n");
			try {
				if(valid) {
					System.out.println("\n\nNew Playground Added: ");
					arr.add(index,new Playground(position,length));
					
				}
			}
			
			catch(Exception  s){
				System.out.print(s.getMessage());
			}
		}
		//sc.close(); 
	}

	
	/**
	 * Time Complexity: O(n^4)
	 * Creates Office Object and puts it into the street array properly
	 * @param choice is a structure choice (1->Office, 2->House, 3->Market, 4->Playground)
	 * @param str is a street object
	 * */
	public void AddNewOne(int choice,Street_LDList str) {
		System.out.print("which side do you wanna add? Rigth-> 1, Left->2: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		//System.out.println("secim: "+x);
		LDLinkedList<Structure> arr = null;
		if(x==1) arr = str.getRightSideBuildings();
		else if(x==2) arr = str.leftSideBuildings;
		else choice = -1;
		switch(choice) {
		case 1 :
			createOffice(arr);
			break;
		case 2:
			createHouse(arr);
			break;
		case 3:
			createMarket(arr);
			break;
		case 4:
			createPlayground(arr);
			break;
		default: 
			System.out.println("Invalid Option!!"); //try catch ?
		}
		//sc.close();
	}
	
}
