package hmw1;
/**
 * <h1>Market Class</h1>
 * Market is a Building
 * @author Haci Hasan Savan
 * @since 2022-03-03
 * */
public class Market extends Building{
	private String openingTime;
	private String closingTime;
	
	public Market(int _position,int _length, int _heigth, String _owner, String _openingT, String _closingT) {
		super(_position,_length, _heigth);
		this.owner = _owner;
		this.openingTime = _openingT;
		this.closingTime = _closingT;

	}
	/**
	 *@return returns Opening Time of the market*/
	public String getOpeningTime() {
		return openingTime;
	}
	/**
	 * sets openingTime
	 * @param openingTime */
	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	/**
	 * @return returns ClosingTime of the market*/
	public String getClosingTime() {
		return closingTime;
	}
	/**
	 *  sets closingTime
	 * @param closingTime*/
	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}
	
	@Override
	public void presentInfo() {
		System.out.println("closing time: " + this.closingTime);
		
	}
	@Override 
	public String toString() {
		return super.toString()+"Opening Time: "+this.openingTime+", "+ "Closing Time: "+this.closingTime+" ]";
	}

}
