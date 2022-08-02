package hmw1;
/**
 * <h1>Office Class</h1>
 * It is a Building 
 * @author Haci Hasan Savan
 * @since 2022-03-03
 * */
public class Office extends Building{
	private String jobType;

	public Office(int _position,int _length, int _heigth, String _owner, String _jobType) {
		super(_position,_length, _heigth);
		this.owner = _owner;
		this.jobType = _jobType;

	}
	/**
	 *@return returns jobType of the office*/
	public String getJobType() {return jobType;}


	@Override
	public void presentInfo() {

		System.out.println("jobType: "+this.jobType);
	}
	
	@Override 
	public String toString() {
		return super.toString()+"jobType: "+this.jobType+" ]";
	}

}
