package hmw1;
/**
 * <h1>Playground Class</h1>
 * Playground is a Structure.
 * @author Haci Hasan Savan
 * @since 2022-03-03
 * */
public class Playground extends Structure {
	
	private int startPosition; //
	private int endingPosition; //
	private int length; //endingPos - staringPos
	private int height;
	
	public Playground(){}
	public Playground(int _position,int _length){
		this.length = _length;
		this.setStartPosition(_position);
		this.setEndingPosition(_position + length);
		height = 2; 
	}

	@Override
	public void presentInfo() {
		System.out.println("length: "+this.length);
	}    
	/**
	 * @return start length*/
	@Override
	public int getLength() {
		return length;
	}
	/**
	 * @param newLength sets length*/
	@Override
	public void setLength(int newLength) {
		this.length = newLength;
	}

	/**
	 * @param startPosition sets startPosition*/
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	/**
	 * @param endingPosition sets endingPosition*/
	public void setEndingPosition(int endingPosition) {
		this.endingPosition = endingPosition;
	}
	/**
	 * @return start position*/
	@Override
	public int getStartPos() {
		
		return startPosition;
	}
	/**
	 * @return ending position*/
	@Override
	public int getEndingPos() {
		return endingPosition;
	}
	@Override
	public String toString() {
		String r = "[ Start position: " + startPosition+",";
		r += "length: "+length + " ]";
		return r;
	}
	public int getHeight() {
		return height;
	}
}
