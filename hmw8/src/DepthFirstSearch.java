import java.util.*;

/**
 * Class to implement the depth-first search algorithm.
 * 
 */

public class DepthFirstSearch {

	  // Data Fields
	  /** A reference to the graph being searched. */
	  private Graph graph;

	  /** Array of parents in the depth-first search tree. */
	  private int[] parent;

	  /** Flag to indicate whether this vertex has been visited. */
	  private boolean[] visited; 

	  /** The array that contains each vertex in discovery order. */
	  private int[] discoveryOrder;

	  /** The array that contains each vertex in finish order. */
	  private int[] finishOrder;

	  /** The index that indicates the discovery order. */
	  private int discoverIndex = 0;

	  /** The index that indicates the finish order. */
	  private int finishIndex = 0;

    private int yol=0;
    // Constructors
    /**
     * Construct the depth-first search of a Graph
     * starting at vertex 0 and visiting the start vertices in
     * ascending order.
     * 
     * @param graph The graph
     */
    public < E extends Comparable < E >> int DepthFirstSearch(MyGraph<String> graph) {
    	this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        //sort edges here
        for (int i = 0; i < graph.getSizeOfEdges(); i++) {
            graph.getIndexOfEdge(i).sort((e1, e2) -> Double.compare(e1.getWeight(), e2.getWeight()));         
        }
        for (int i = 0; i < n; i++) {
          parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
          if (!visited[i])
            depthFirstSearch(i);
        }
        
        return yol;

    }

    /**
     * Construct the depth-first search of a Graph
     * selecting the start vertices in the specified order.
     * The first vertex visited is order[0].
     * 
     * @param graph The graph
     * @param order The array giving the order
     *              in which the start vertices should be selected
     */
    public <E extends Comparable < E >> DepthFirstSearch(MyGraph<String> graph, int[] order) {
        // Same as constructor above except for the if statement.
    }

    public DepthFirstSearch(MyGraph<String> graphTest) {
		// TODO Auto-generated constructor stub
	}

	/**
     * Recursively depth-first search the graph
     * starting at vertex current.
     * 
     * @param current The start vertex
     */
    public void depthFirstSearch(int current) {
    	/* Mark the current vertex visited. */
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;
        /* Examine each vertex adjacent to the current vertex */
        Iterator < Edge > itr = graph.edgeIterator(current);
        while (itr.hasNext()) {
        	Edge temp = itr.next();
        	int neighbor = temp.getDest();
          
          /* Process a neighbor that has not been visited */
          if (!visited[neighbor]) {
        	 // System.out.print("visited: " + neighbor + " ");        	  
        	  //System.out.println(temp.getWeight());
        	  yol+= temp.getWeight();
        	  depthFirstSearch(neighbor);
          }
        }
        /* Mark current finished. */
        finishOrder[finishIndex++] = current;
    }

    /** BEGIN EXERCISE **/
    /**
     * Get the finish order
     * 
     * @return finish order
     */
    public int[] getFinishOrder() {
        return finishOrder;
    }

    /** END EXERCISE **/
}