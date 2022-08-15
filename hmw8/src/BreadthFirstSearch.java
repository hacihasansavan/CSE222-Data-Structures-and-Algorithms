import java.util.*;

/**
 * Class to implement the breadth-first search algorithm.
 * 
 */

public class BreadthFirstSearch {

    public static <E extends Comparable < E >> double breadthFirstSearch(MyGraph<E> graph){
    	//if(!graph.isDirected()) 
        return breadthFirstSearch(graph, 0);
    }   
    /**
     * Perform a breadth-first search of a graph.
     * post: The array parent will contain the predecessor
     * of each vertex in the breadth-first
     * search tree.
     * 
     * @param graph The graph to be searched
     * @param start The start vertex
     * @return The array of parents
     */
    private static <E> double breadthFirstSearch(MyGraph graph, int start) {
    	

       // Queue<Integer> theQueue = new LinkedList<Integer>();

        List<Integer> theQueue = new ArrayList<Integer>();
        int totalDistance = 0;

        // Declare array identified and
        // initialize its elements to null.
        //boolean[] identified = new boolean[graph.getNumV()];
        
        List<Edge> identified = new ArrayList<Edge>(graph.getNumV());
        for (int i = 0; i < graph.getNumV(); i++) {
            identified.add(null);
        }
        /*
         * Mark the start vertex as identified and insert it
         * into the queue
         */
        Iterator<Edge> iter = graph.edgeIterator(0);

        identified.set(0, iter.next());  // edge tutar
        theQueue.add(start);   // id (int) tutar
        

        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
            /*
             * Take a vertex, current, out of the queue.
             * (Begin visiting current).
             */
            int current = theQueue.remove(0);   // int 0
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator<Edge> itr = graph.edgeIterator(current);

            while (itr.hasNext()) {

                Edge edge = itr.next();
                int neighbor = edge.getDest();

                if(identified.get(neighbor) != null){
                    double weight = identified.get(neighbor).getWeight();
                    if(weight > edge.getWeight()){
                        int index = theQueue.indexOf(neighbor);
                        if(index !=-1) {
                        	
                        	theQueue.remove(index);
                        	theQueue.add(neighbor); 
                        	totalDistance -= weight - edge.getWeight();
                        }
                    }
                }

                // If neighbor has not been identified
                if (identified.get(neighbor) == null) {
                    // Mark it identified.

                    identified.set(neighbor, edge);
                    // Place it into the queue.
                    theQueue.add(neighbor);
                    int temp = totalDistance;
                    totalDistance += edge.getWeight();
                  //  System.out.print(totalDistance-temp+" ");
                }
                
            }
            // Finished visiting current.
        }
       // System.out.println();
        return totalDistance;
    }
}