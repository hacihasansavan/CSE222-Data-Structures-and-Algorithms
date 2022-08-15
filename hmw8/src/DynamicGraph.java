import java.util.List;

@SuppressWarnings("rawtypes")
public interface DynamicGraph extends Graph {
	
	/**
	 * unimplemented newWertex
	 * */
	< E extends Comparable < E >>  Vertex<E>  newVertex (String label, double weight);
	/**
	 * unimplemented addVertex
	 * */
	Vertex addVertex (Vertex new_vertex);
	/**
	 * unimplemented addEdge
	 * */
	void addEdge (int vertexID1, int vertexID2, double weight); //void?
	/**
	 * unimplemented removeEdge
	 * */
	void removeEdge (int vertexID1, int vertexID2);
	/**
	 * unimplemented removeVertex
	 * */
	void removeVertex (int vertexID);
	/**
	 * unimplemented removeVertex
	 * */
	Vertex removeVertex (String label);
	/**
	 * unimplemented filterVertices
	 * */
	<E extends Comparable < E >> MyGraph<E> filterVertices (String key, String filter);
	/**
	 * unimplemented exportMatrix
	 * */
	double[][] exportMatrix();
	/**
	 * unimplemented printGraph
	 * */
	void printGraph(); 
}
