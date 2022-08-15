import java.util.Iterator;

/**
 * @author hhs
 *
 */
public class Test {

	public static void main(String[] args) {
		
		
	    MyGraph<String> graphTest = new MyGraph<String>(10, false);
	    
	    System.out.println("-	Creating edge without vertex will give error: ");
	    graphTest.addEdge(0, 1, 30);
	    System.out.println();
	    graphTest.addEdge(0, 2, 40);
	    System.out.println();
	    graphTest.addEdge(0, 3, 60);
	    
	    graphTest.addVertex(new Vertex<>(0,"v0",2.0,"Color","white"));
	    graphTest.addVertex(new Vertex<>(1,"v1",1.0,"Color","white"));
	    graphTest.addVertex(new Vertex<>(2,"v2",3.0,"Color","black"));
	    graphTest.addVertex(new Vertex<>(3,"v3",5.0,"Color","white"));
	    graphTest.addVertex(new Vertex<>(4,"v4",2.0,"Color","black"));
	    graphTest.addVertex(new Vertex<>(5,"v5",4.0,"Color","black"));
	    graphTest.addVertex(new Vertex<>(6,"v6",8.0,"Color","black"));
	    System.out.println();
	    System.out.println(graphTest.getNumV());
	    System.out.println(graphTest.getSizeOfEdges());
	    
	    graphTest.addEdge(0, 1, 30);
	    graphTest.addEdge(0, 2, 40);
	    graphTest.addEdge(0, 3, 60);
	    graphTest.addEdge(0, 4, 70);
	    graphTest.addEdge(1, 3, 40);
	    graphTest.addEdge(1, 4, 35);
	    graphTest.addEdge(3, 4, 50);
	    graphTest.addEdge(2, 5, 30);
	    graphTest.addEdge(2, 6, 50);
	    graphTest.addEdge(5, 6, 40);
	    System.out.println("After Adding edges: ");
	    System.out.println(graphTest.getSizeOfEdges());
		
	    System.out.println("\nPrint Result: ");
	    graphTest.printGraph();
	    
	    
	    graphTest.removeEdge(0, 4);

	    System.out.println("\nPrint Result After Removing: ");
	    graphTest.printGraph();
	    
	    
	    
	    System.out.println("\nPrint Result Before Removing Vertex: ");
	    graphTest.printGraph();
	    graphTest.removeVertex(4);  //removing 4th vertex
	    System.out.println("\nPrint Result After Removing Vertex: ");
	    graphTest.printGraph();
	    
	    
	    System.out.println("\nPrint Result Before Removing Vertex: ");
	    graphTest.printGraph();
	    graphTest.removeVertex("v5");  //removing 5th vertex with label
	    System.out.println("\nPrint Result After Removing Vertex: ");
	    graphTest.printGraph();
	    
	    System.out.println();	    
	    System.out.println("SubGraph: (White Vertexes only)");
	    MyGraph<Integer> subGraph = graphTest.filterVertices("Color", "white");
	    subGraph.printGraph();
	    
	    //export matrix
	    double[][] matrix = graphTest.exportMatrix();
	    for (int i = 0; i < matrix.length; i++) {
	        System.out.print("[");
	        for (int j = 0; j < matrix[i].length; j++) {
	            System.out.print(matrix[i][j]);
	            if(j != matrix.length-1)
	                System.out.print(", ");
	        }
	        System.out.println("]");
	    }
		System.out.println();
		//Generate a new vertex by given parameters:
	    Vertex<Integer> newV = graphTest.newVertex("newVertex", 12.0);
	    System.out.println(newV.toString());

		
		
	    System.out.println("------------------------------------------------------------");
	    System.out.println("Q2\n");
	    
	    MyGraph<String> gTest2 = new MyGraph<String>(20, true);
	    
	    gTest2.addVertex(new Vertex<>(0,"v0",2.0));
	    gTest2.addVertex(new Vertex<>(1,"v1",1.0));
	    gTest2.addVertex(new Vertex<>(2,"v2",3.0));
	    gTest2.addVertex(new Vertex<>(3,"v3",5.0));
	    gTest2.addVertex(new Vertex<>(4,"v4",2.0));
	    gTest2.addVertex(new Vertex<>(5,"v5",4.0));
	    // gTest2.addVertex(new Vertex<>(6,"v6",4.0));
	    
	    //Test1
	    gTest2.addEdge(0, 1, 30);
	    gTest2.addEdge(0, 2, 40);
	    gTest2.addEdge(1, 3, 80);
	    gTest2.addEdge(1, 5, 10);
	    gTest2.addEdge(2, 3, 20);
	    gTest2.addEdge(2, 4, 10);


	    
	    /*gTest2.addEdge(1, 0, 30);
	    gTest2.addEdge(2, 0, 40);
	    gTest2.addEdge(3, 0, 60);
	    gTest2.addEdge(4, 0, 70);
	    gTest2.addEdge(3, 1, 40);
	    gTest2.addEdge(4, 1, 35);
	    gTest2.addEdge(4, 3, 50);
	    gTest2.addEdge(5, 2, 30);
	    gTest2.addEdge(6, 2, 50);
	    gTest2.addEdge(6, 5, 40);*/
		   
	    BreadthFirstSearch bfs = new BreadthFirstSearch();
	    
	    double db = bfs.breadthFirstSearch(gTest2);
	    System.out.println("BFS Shortest path:");
	    System.out.println(db);
	    System.out.println();
	    
	    DepthFirstSearch dfs = new DepthFirstSearch(gTest2);
	    double db2 = dfs.DepthFirstSearch(gTest2);
	    System.out.println("DFS Shortest path:");
	    System.out.println(db2);
	    System.out.println();
	    
	    System.out.println("Difference: ");
	    System.out.println(db2 - db);
	    

	    MyGraph<String> gTest3 = new MyGraph<String>(50,true);
	    
	    gTest3.addVertex(new Vertex<>(0,"v0",2.0));
	    gTest3.addVertex(new Vertex<>(1,"v1",1.0));
	    gTest3.addVertex(new Vertex<>(2,"v2",3.0));
	    gTest3.addVertex(new Vertex<>(3,"v3",5.0));
	    gTest3.addVertex(new Vertex<>(4,"v4",2.0));
	    gTest3.addVertex(new Vertex<>(5,"v5",4.0));
	    gTest3.addVertex(new Vertex<>(6,"v6",4.0));
	    
	    gTest3.addEdge(0, 1, 30);
	    gTest3.addEdge(0, 2, 40);
	    gTest3.addEdge(0, 3, 60);
	    gTest3.addEdge(0, 4, 70);
	    gTest3.addEdge(1, 3, 40);
	    gTest3.addEdge(1, 4, 35);
	    gTest3.addEdge(2, 0, 80);
	    gTest3.addEdge(2, 5, 30);
	    gTest3.addEdge(2, 6, 50);
	    gTest3.addEdge(3, 4, 60);
	    gTest3.addEdge(5, 6, 50);
	    gTest3.addEdge(5, 1, 40);
	    gTest3.addEdge(6, 0, 80);
	    gTest3.addEdge(6, 2, 90);
	    
	    gTest3.printEdges();
	    
	    BreadthFirstSearch bfs3 = new BreadthFirstSearch();
	    
	    double db3 = bfs.breadthFirstSearch(gTest3);
	    System.out.println("BFS Shortest path:");
	    System.out.println(db3);
	    System.out.println();
	    
	    DepthFirstSearch dfs3 = new DepthFirstSearch(gTest3);
	    double db4 = dfs3.DepthFirstSearch(gTest3);
	    System.out.println("DFS Shortest path:");
	    System.out.println(db4);
	    System.out.println();
	    
	    System.out.println("Difference: ");
	    System.out.println(db4 - db3);
	    
	    System.out.println("------------------------------------------------------------");
	    System.out.println("Q3\n");
	    MyGraph<String> dijTest = new MyGraph<String>(50,true);
	    
	    dijTest.addVertex(new Vertex<>(0,"v0",2.0));
	    dijTest.addVertex(new Vertex<>(1,"v1",1.0));
	    dijTest.addVertex(new Vertex<>(2,"v2",3.0));
	    dijTest.addVertex(new Vertex<>(3,"v3",5.0));
	    dijTest.addVertex(new Vertex<>(4,"v4",2.0));

	    
	    dijTest.addEdge(0, 1, 10);
	    dijTest.addEdge(0, 3, 30);
	    dijTest.addEdge(0, 4, 100);
	    dijTest.addEdge(1, 2, 50);
	    dijTest.addEdge(2, 4, 10);
	    dijTest.addEdge(3, 2, 20);
	    dijTest.addEdge(3, 4, 60);
	    
	    //without boost
	    DijkstrasAlgorithm dij = new DijkstrasAlgorithm(); 
	    System.out.println("Boost values And Result: (Without Boost)");
	    dij.dijkstrasAlgorithm(dijTest, dijTest.getVertex(0));
	    
	    System.out.println();
	    //with boost
	    dijTest.getVertex(0).setBoost(2.0);
	    dijTest.getVertex(1).setBoost(4.0);
	    dijTest.getVertex(2).setBoost(8.0);
	    dijTest.getVertex(3).setBoost(10.0);
	    dijTest.getVertex(4).setBoost(15.0);

	    System.out.println("Boost values And Result: (With Boost)");
	    dij.dijkstrasAlgorithm(dijTest, dijTest.getVertex(0));
	    
	}

}
