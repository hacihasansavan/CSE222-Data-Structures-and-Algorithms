import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyGraph < E
extends Comparable < E >>  implements DynamicGraph {
	
	private ArrayList<Vertex<E>> vList;  
	private List < Edge > [] eList; 
	private int Vsize=0;
	private boolean directed;
	/**
	 * Constructor
	 * @param size int size of graph
	 * @param isDirected boolean value that refers */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	MyGraph(int size,boolean isDirected){
		this.Vsize = size;
		directed = isDirected;
		vList = new ArrayList<Vertex<E>>(size);
	    eList = new List[Vsize];
	    for (int i = 0; i < Vsize; i++) {
	    	eList[i] = new LinkedList < Edge > ();
	    }
	}
	/**
	 * @return edgeList.length
	 * */
	public int getSizeOfEdges() {
		int size=0;
		//int i=0;
		//System.out.println("eList length: "+eList.length);
		for(List<Edge> x : eList) {
			//System.out.println(i+"th size: "+ x.size());
			size+= x.size();
			//i++;
		}
		return size;
	}

	/**
	 * Returns edgeList[index]
	 * @param index int index value
	 * @return eList[index]
	 * */
	public List<Edge> getIndexOfEdge(int index) {
		return eList[index];
	}
	/**
	 * Returns edgeList[index]
	 * @param index int index value
	 * @return eList[index]
	 * */
	public Vertex getVertex(int i) {
		return vList.get(i);
	}
	
	/**
	 * Returns number of vertex
	 * @return number of vertex
	 * */
	@Override
	public int getNumV() {
		return vList.size();
	}
	
	/**
	 * Returns boolean value that shows if it is directed or not
	 * @return graph.directed
	 * */
	@Override
	public boolean isDirected() {
		return directed;
	}

	/** Insert a new edge into the graph.
	 *@param edge The new edge
	 * */
	public void insert(Edge edge) {
	  eList[edge.getSource()].add(edge);
	  if (!isDirected()) {
		  eList[edge.getDest()].add(new Edge(edge.getDest(),
	                                       edge.getSource(),
                                       edge.getWeight()));
	  }
	}

	/** Determine whether an edge exists.
	    @param source The source vertex
	    @param dest The destination vertex
	    @return true if there is an edge from source to dest
	*/
	public boolean isEdge(int source, int dest) {
		return eList[source].contains(new Edge(source, dest));
	}

  /** Get the edge between two vertices. If an
    edge does not exist, an Edge with a weight
    of Double.POSITIVE_INFINITY is returned.
    @param source The source
    @param dest The destination
    @return the edge between these two vertices
 */
	public Edge getEdge(int source, int dest) {
	  Edge target =
	      new Edge(source, dest, Double.POSITIVE_INFINITY);
	  for (Edge edge : eList[source]) {
	    if (edge.equals(target))
	      return edge; // Desired edge found, return it.
	  }
	  // Assert: All edges for source checked.
	  return target; // Desired edge not found.
	}
	/**
	 * returns edge iterator from given index
	 * @param int source vertex
	 * @return edge iterator*/
	public Iterator < Edge > edgeIterator(int source) {
	    return eList[source].iterator();
	  }

	/**
	 * Generate a new vertex by given parameters and returns it.
	 * @param label String label value
	 * @param weight String weight value for vertex
	 * @return new vertex*/
	@Override
	public < E extends Comparable < E >>  Vertex<E> newVertex(String label, double weight) {
		return new Vertex<E>(0,label,weight,"null","null");
	}
	
	/**
	 * Add the given vertex to the graph. 
	 * @param new_vertex vertex object
	 * @return added vertex
	 **/
	@Override
	public Vertex addVertex(Vertex new_vertex) {
		//Vsize++;
	    vList.add(new_vertex);
		return new_vertex;
	}
	/**
	 * Add an edge between the given two vertices in the graph.
	 * @param vertexID1 : source
	 * @param vertexID2 : destination
	 * @param weight : weight*/
	@Override
	public void addEdge(int vertexID1, int vertexID2, double weight) {
        /* */
        boolean b1 = false;
        boolean b2 = false;
        for (Vertex<E> vertex : vList) {
            if(vertex.getId() == vertexID1)
            	b1 = true;
            if(vertex.getId() == vertexID2)
            	b2 = true;
            if (b1 && b2) {
            	insert(new Edge(vertexID1, vertexID2, weight));
            	break;
            }
        }
        if(!b1 || !b2) 	System.out.println("edge : [(" + vertexID1 + ", " + vertexID2 + "): " + weight + "]");
        if(!b1)  		System.out.println("Edge Couldn't be created: Vertex " + vertexID1 + " is not exist!");
        if(!b2) 		System.out.println("Edge Couldn't be created: Vertex " + vertexID2 + " is not exist!");
       
    }
	/** Insert a new edge into the graph.
		@param source : source vertex
		@param dest : destination vertex
		@param weight : weight of edge 
	*/
	public void insert(int source, int dest, double weight) {
		Edge edge = new Edge(source,dest,weight);
		eList[edge.getSource()].add(edge);
		if (!isDirected()) {
			eList[edge.getDest()].add(new Edge(edge.getDest(),
		                                     edge.getSource(),
		                                     edge.getWeight()));
		}
	}
	/**
	 * Remove the edge between the given two vertices.
	 * @param vertexID1 : first vertex
	 * @param vertexID2 : second vertex 
	 * @return boolean */
	@Override
    public void removeEdge(int vertexID1, int vertexID2) {
		
        eList[vertexID1].remove(getEdge(vertexID1, vertexID2));
        if(!directed) eList[vertexID2].remove(getEdge(vertexID2, vertexID1));
    }
		
	/**
	 * Remove the vertex from the graph with respect to the given vertex id.
	 * @param vertexID : vertex id to be removed
	 * */
	@Override
	public void removeVertex(int vertexID) {
		boolean removed = false;

		for(int i=0; i<vList.size(); ++i) {
			if(vList.get(i).getId() == vertexID) {
				//System.out.println("removed: " +vList.get(i).toString() );	
				vList.remove(i);
				removed = true;
			}
		}
		if(removed)
			for(List<Edge> x : eList)
				for(Edge edges : x)
					this.removeEdge(vertexID, edges.getDest());

		else System.out.println("Invalid vertex id!");	
	}

	/**
	 * Remove the vertices that have the given label from the graph.
	 * @param label : vertex label to be removed 
	 * @return removed object*/
	@Override
	public Vertex removeVertex(String label) {
		boolean removed = false;
		int vertexID = -1;
		Vertex temp=null;
		for(int i=0; i<vList.size(); ++i) {
			if(vList.get(i).getLabel().equals(label)) {
				temp = vList.get(i);
				vertexID = vList.get(i).getId();
				vList.remove(i);
				removed = true;
				Vsize--;
				//break;
			}	
		}
		if(removed)
			for(List<Edge> x : eList)
				for(Edge edges : x)
					this.removeEdge(vertexID, edges.getDest());

		else System.out.println("Invalid vertex id!");
		return temp;
	}
	/**
	 * Filter the vertices by the given user-defined property and returns a subgraph of the graph.
	 * @param key : String key value
	 * @param filter : String filter value
	 * */
	@Override
	public <E extends Comparable < E >> MyGraph<E> filterVertices(String key, String filter) {
		MyGraph<E> subGraph = new MyGraph<E>(this.getNumV(),false);
		for(Vertex x : vList) {
			if(x.userDefinedProperity.containsKey(key) &&  x.userDefinedProperity.containsValue(filter))
				subGraph.vList.add((Vertex<E>) x);
		}
		//System.out.println(subGraph.getNumV());
		//System.out.println(i);
		  for (int i = 0; i < subGraph.getNumV() - 1; i++) {
	            for (int k = i + 1; k < subGraph.getNumV(); k++) {
	                int source = subGraph.vList.get(i).getId();
	                int dest = subGraph.vList.get(k).getId();
	                if(this.isEdge(source, dest)) {
	                	subGraph.addEdge(source, dest, this.getEdge(source, dest).getWeight());                   
	                	//System.out.println("girdi");
	                }
	                
	            }
	        }
		return subGraph;
	}
	
	/**
	 * Generate the adjacency matrix representation of the graph and returns the matrix.
	 * @return double [][] array*/
    @Override
    public double[][] exportMatrix() {

        double[][] matrix = new double[Vsize][Vsize];
        for (int i = 0; i < matrix.length; i++) 
        	for (int j = 0; j < matrix[i].length; j++) 
        		matrix[i][j] = getEdge(i, j).getWeight();
        return matrix;

    }
    /**
     * Helper function that prints the Vertexes
     * */
    public void printVertexes() {
    	for(Vertex<E> e : vList)
    		System.out.println(e.toString());
    }
    /**
     * Helper function that prints the Edges
     * */
    public void printEdges() {
    	for(List<Edge> el : eList)
    		for(Edge e : el)
    			System.out.println(e.toString());    	
    }
    
    /**
     * Prints the graph in adjacency list format.
     */
	@Override
	public void printGraph() {  //--> Theta(N^2)
		
		boolean putArrow = true;
        for (int i = 0; i < vList.size()+2; i++) { //+1
        	putArrow = true;
            Iterator<Edge> itr = edgeIterator(i);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                if(putArrow){
                	putArrow = false;
                    System.out.print(edge.getSource() + " -> ");
                }
                System.out.print(edge.getDest());
                if(itr.hasNext())
                    System.out.print(" -> ");
            }
            if(!putArrow)
                System.out.println();  
                      
        }        
    }	
	
	
}
