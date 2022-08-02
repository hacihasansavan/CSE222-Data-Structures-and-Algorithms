package hmw1;
/**
 * <h1>Structure Class</h1>
 * Structure Class is a abstract base class of the system. Street,Building,Playground classes inherit it
 * @author Haci Hasan Savan
 * @since 2022-03-03
 * */
public abstract class Structure {


	/**
	 * @return length of structure*/
	abstract public int getLength();

	
	/**
	 * Sets lenght
	 * @param newLength new length*/
	abstract public void setLength(int newLength);


	/**
	 * Prints a specific information about class*/
	public void presentInfo() {System.out.println("not implemented");}

	/**
	 * Should be overrided
	 * @return start position of structure*/
	public int getStartPos() {return -1;}

	/**
	 * Should be overrided
	 * @return ending position of structure*/
	public int getEndingPos() {return -1;}

	/**
	 * Should be overrided
	 * @return length of structure*/
	public int getHeight() {return -1;}
	

}
