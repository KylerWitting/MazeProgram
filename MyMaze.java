import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyMaze implements Maze {
	
	/**
	 * Returns a random maze with the specified number of rows and columns
	 * @param rows and colums for the size of the new Maze
	 */
    @Override
    public void generateMaze(int rows, int columns) {

    }

    /**
     * @return an ordered list representing a path of vertices from the start to the finish
     */
    @Override
    public ArrayList<Vertex> solveMaze() {
        return null;
    }

    /**
     * @return a graph representing the maze
     */
    @Override
    public Graph toGraph() {
        return null;
    }

    /**
     * @return an array of vertices representing the maze
     */
    @Override
    public Vertex[][] toArray() {
        return new Vertex[0][];
    }

    /**
     * @return the start vertex to this maze
     */
    @Override
    public Vertex startVertex() {
        return null;
    }

    /**
     * @return the finish vertex of this maze
     */
    @Override
    public Vertex finishVertex() {
        return null;
    }
}
