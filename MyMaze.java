import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyMaze implements Maze {

    Vertex[][] backing = null;

    Graph graph = null;

    Vertex start;
    Vertex finish;
	
	/**
	 * Returns a random maze with the specified number of rows and columns
	 * @param rows and colums for the size of the new Maze
	 */
    @Override
    public void generateMaze(int rows, int columns) {
        backing = new Vertex[rows][columns];

        Graph temp = new MyGraph();

        // Draws Square graph temp
        for(int rowIndex = 0; rowIndex <rows; rowIndex++) {
            for (int colIndex = 0; colIndex <columns; colIndex++) {
                MyVertex myVertex = new MyVertex();
                myVertex.setElement(new MyPair(rowIndex,colIndex));
                backing [rowIndex][colIndex] = myVertex;
                temp.addVertex(myVertex);
                if(rowIndex != 0) {
                    temp.addEdge(backing[rowIndex - 1][colIndex], myVertex);
                }

                if(colIndex != 0){
                    temp.addEdge(backing[rowIndex][colIndex - 1], myVertex);
                }
            }
        }


        List<Edge> edges = new ArrayList<Edge>(temp.edges());
        List<Vertex> vertices = temp.vertices();

        temp.edges().clear();

        Random rand = new Random() ;

        start = backing [rand.nextInt(rows)][0];
        finish = backing [rand.nextInt(rows)][columns -1];


        // TODO Map this out and store to graph


    }

    /**
     * @return an ordered list representing a path of vertices from the start to the finish
     */
    @Override
    public ArrayList<Vertex> solveMaze() {
        return graph.shortestPath(start,finish);
    }

    /**
     * @return a graph representing the maze
     */
    @Override
    public Graph toGraph() {
        return graph;
    }

    /**
     * @return an array of vertices representing the maze
     */
    @Override
    public Vertex[][] toArray() {
        return backing;
    }

    /**
     * @return the start vertex to this maze
     */
    @Override
    public Vertex startVertex() {
        if(backing == null || backing.length < 2 ) {
            return null;
        }
        else {
            return start;
        }
    }

    /**
     * @return the finish vertex of this maze
     */
    @Override
    public Vertex finishVertex() {
        if(backing == null || backing.length < 2 ) {
            return null;
        }
        else {
            return finish;
        }
    }
}
