import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Vertex Class. To Represent the vertices in a graph
 * */
public class Vertex< E
extends Comparable < E >> {	
	private int id;
	private String label;
	private double weight; 
	private double boost;

	Map<E, E> userDefinedProperity;// = new HashMap<>();
	
	/**
	 * Constructor1
	 * (No User Defined Properity)
	 * (No User Defined Weight)
	 * @param idx int id value
	 * @param lbl String label
	 * */
	Vertex(int idx, String lbl){
		id = idx;
		label = lbl;
		weight = 1.0;
		userDefinedProperity = null;
	}
	/**
	 * Constructor2
	 * (No User Defined Properity)
	 * @param idx int id value
	 * @param lbl String label
	 * @param wght double weight value of vertex
	 * */
	Vertex(int idx, String lbl, double wght){
		this(idx, lbl);
		weight = wght;
		userDefinedProperity = null;
	}
	/**
	 * Constructor3
	 * @param idx int id value
	 * @param lbl String label
	 * @param wght double weight value of vertex
	 * @param Key String value. user defined key value
	 * @param Value user defined value
	 * */
	Vertex(int idx, String lbl, double wght,String Key, String Value){
		this(idx, lbl);
		weight = wght;
		userDefinedProperity = new HashMap<E,E>();
		userDefinedProperity.put((E)Key, (E)Value);
	}
	/**
	 * Adds new property to existing vertex
	 * @param Key String key
	 * @param Value String value*/
	public void addAdditionalProperty(String Key, String Value) {
		if(userDefinedProperity==null) userDefinedProperity = new HashMap<>();
		userDefinedProperity.put((E)Key, (E)Value);
	}
	/**
	 * returns vertex id
	 * @return vertex.id*/
	public int getId() {
		return id;
	}
	/**
	 * returns boost value
	 * @return boost
	 * */
	 public double getBoost(){
		return boost;
	 }
	 public void setBoost(double bst) {
		 boost = bst;
	 }
	/**
	 * returns vertex label
	 * @return vertex.label*/
	public String getLabel() {
		return label;
	}
	
    /** Get the weight
    @return the value of weight
     */
	public double getWeight() {
	  return weight;
	}
	
	/** Return a String representation of the vertex
	    @return A String representation of the vertex
	 */
	public String toString() {
	  StringBuffer sb = new StringBuffer("[(");
	  sb.append(label);
	  sb.append(", ");
	  sb.append(id);
	  sb.append("): ");
	  sb.append(Double.toString(weight));
	  sb.append("]\n");
	  sb.append("[ ");
	  sb.append("( ");
	  sb.append(userDefinedProperity.toString());
	  sb.append(" ) ");
	  

	  /*for(var x: userDefinedProperity) {
		  sb.append("( ");
		  sb.append(x.key+" - ");
		  sb.append(x.value);
		  sb.append(" ) ");
		  
	  }*/
	  sb.append(" ]\n");
	  return sb.toString();
	}
	
	/** Return true if two edges are equal. Edges
	    are equal if the source and destination
	    are equal. Weight is not conidered.
	    @param obj The object to compare to
	    @return true if the edges have the same source
	    and destination
	 */
	public boolean equals(Object obj) {
	  if (obj instanceof Vertex) {
		  @SuppressWarnings("rawtypes")
		Vertex vrtx = (Vertex) obj;
	    return (id == vrtx.id
	            && label.equals(vrtx.label) && weight == vrtx.weight);
	  }
	  else {
	    return false;
	  }
	}

}
