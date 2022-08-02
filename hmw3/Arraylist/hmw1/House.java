package hmw1;
/**
 * <h1>House Class</h1>
 * House class. is a building
 * @author Haci Hasan Savan
 * @since 2022-03-03
 * */
public class House extends Building{
	private int numOfRooms;
	private String color;
	
	public House(int _position,int _length, int _heigth, String _owner, int _roomNum, String _color) {
		super(_position,_length, _heigth);
		this.owner = _owner;
		this.numOfRooms = _roomNum;
		this.color = _color;
	}
	/**
	 * @return number of rooms*/
	public int getNumOfRooms() {
		return numOfRooms;
	}
	/**
	 * @param numOfRooms sets number of rooms*/
	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}
	/**
	 * @return color*/
	public String getColor() {
		return color;
	}
	/**
	 * @param color sets color*/
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void presentInfo() {
		System.out.println("Owner: "+this.owner);
	}
	@Override 
	public String toString() {
		return super.toString()+"color: "+this.color+", "+ "Room number: "+this.numOfRooms+" ]";
	}

}
