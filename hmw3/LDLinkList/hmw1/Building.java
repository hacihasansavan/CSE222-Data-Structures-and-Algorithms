package hmw1;
/**
 * <h1>Building Class</h1>
 * This Abstract class is parent class of Office,House and Market.
 * Extends Structure abstract class
 * @author Haci Hasan Savan
 * @since 2022-03-03
 * */
public abstract class Building extends Structure{

	protected int startPosition; //
	protected int endingPosition; //
	protected int length; //endingPos - staringPos
	protected int height;
	protected String owner;
	//protected String name;
	
	public Building(int _position,int _length, int _heigth) {
		this.startPosition = _position;
		this.length = _length;
		this.endingPosition = this.startPosition + this.length;
		this.height = _heigth;
	}
	/**
	 * @return Returns length of the Building
	 * */
	@Override
	public int getLength() {return length;}
	/**
	 * sets Height
	 * @param newHeigth new Height for building
	 * */
	public void setHeight(int newHeigth){
		this.height = newHeigth;
	}
	
	/**
	 * @return Returns height of the Building
	 * */
	@Override
	public int getHeight() {return height;}
	/**
	 * sets Length
	 * @param newLength new Length for building
	 * */
	@Override
	public void setLength(int newLength) {
		length = newLength;
	}
	/**
	 * @return Returns owner of the Building
	 * */
	public String getOwner() {return owner;}
	//public String getName() {return name;}
	@Override
	public int getStartPos() {
		return startPosition;
	}
	/**
	 * sets startPosition
	 * @param position setStartPos for building
	 * */
	public void setStartPos(int position) {
		this.startPosition = position;
	}
	/**
	 * @return Returns ending position of the Building
	 * */
	@Override
	public int getEndingPos() {
		return endingPosition;
	}
	/**
	 * sets endingPosition
	 * @param finishPosition is Ending Position for building
	 * */
	public void setEndingPos(int finishPosition) {
		this.endingPosition = finishPosition;
	}
	@Override
	public String toString() {
		String r = "[ Start position: " + startPosition+", ";
		r += "length: "+length + ", ";
		r+="heigth: " + height + ", ";
		r+="owner: " + owner + ", ";
		return r;
	}
	
}
