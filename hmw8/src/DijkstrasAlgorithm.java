import java.util.*;

/**
 * Class that contains static boosted Dijkstra's algorithm.
 */

public class DijkstrasAlgorithm {

    /**
     * Dijkstra's Shortest-Path algorithm but with boosting.
     * 
     * @param graph The weighted graph to be searched
     * @param startV The start vertex
     */
    @SuppressWarnings("deprecation")
	public static <E extends Comparable<E>> void dijkstrasAlgorithm(MyGraph<E> graph, Vertex<Double> startV) {

        int numV = graph.getNumV();
        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);

        /* Contains the predecessors in the shortest path */
        int[] pred = new int[numV];
        /* Contains the distance in the shortest path */
        double[] dist = new double[numV];
        for (int i = 0; i < numV; i++)
            if (i != startV.getId()) vMinusS.add(i);

        for (int v : vMinusS) {
            pred[v] = startV.getId();
            dist[v] = graph.getEdge(startV.getId(), v).getWeight();
        }
        while (vMinusS.size() != 0) {
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            vMinusS.remove(u);
            Iterator<Edge> itr = graph.edgeIterator(u);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int v = edge.getDest();
                if (vMinusS.contains(new Integer(v))) {
                    double weight = edge.getWeight();
                    double boost = graph.getVertex(u).getBoost();
                    System.out.println(boost);
                    if (dist[u] + weight - boost < dist[v]) {
                        dist[v] = dist[u] + weight - boost;
                        pred[v] = u;
                    }
                }
            }
        }
        //print result
        System.out.println("Vertex \t\t Shortest Distance");
        for (int i = 0; i < numV; i++)
            System.out.println(i + " \t\t " + dist[i]);
    
    }
}