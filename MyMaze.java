import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyMaze implements Maze {

	Vertex[][] backing = null;
	boolean[][] visited;

	Graph mazeGraph;

	Vertex start;
	Vertex finish;

    public MyMaze( ) {
        mazeGraph = new MyGraph();
    }

	/**
	 * Returns a random maze with the specified number of rows and columns
	 * @param rows and columns for the size of the new Maze
	 */
	@Override
	public void generateMaze(int rows, int columns) {
		backing = new Vertex[rows][columns];

		// Draws Square graph temp
		for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
			for (int colIndex = 0; colIndex < columns; colIndex++) {
				MyVertex myVertex = new MyVertex();
				myVertex.setElement(new MyPair(rowIndex,colIndex));
				backing [rowIndex][colIndex] = myVertex;
				mazeGraph.addVertex(myVertex);
				/*if(rowIndex != 0) {
                    temp.addEdge(backing[rowIndex - 1][colIndex], myVertex);
                }
                if(colIndex != 0) {
                    temp.addEdge( backing[rowIndex][colIndex - 1], myVertex);
                }*/
			}
		}


		/*List<Edge> edges = new ArrayList<Edge>(temp.edges());
        List<Vertex> vertices = temp.vertices();
        temp.edges().clear();*/
		Random rand = new Random() ;
		int startRow = rand.nextInt(rows);
		start = backing [startRow][0];
		finish = backing [rand.nextInt(rows)][columns -1];

		visited = new boolean[rows][columns];
		for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
			for (int colIndex = 0; colIndex < columns; colIndex++) {
				visited[rowIndex][colIndex] = false;
			}
		}
		generate( startRow, 0 );
		if ( !checkGraph( rows, columns ) )
			System.out.println( "Making the maze faile" );
		// TODO Map this out and store to graph


	}
	private void generate( int x, int y) {
		visited[x][y] = true;
		while (!visited[x][y+1] || !visited[x+1][y] || !visited[x][y-1] || !visited[x-1][y]) {

			while (true) {
				Random rand = new Random();
				int r = rand.nextInt( 4 );
				//up
				if (r == 0) {
                    if(y > visited [0].length - 1) {

                    }
                    if(!visited[x][y+1]) {
                        mazeGraph.addEdge(backing[x][y], backing[x][y + 1]);
                        generate(x, y + 1);
                        if (!visited[x][y - 1]) {
                            generate(x, y - 1);
                        }
                        break;
                    }
				}
				//right
				else if (r == 1 ) {
                    if(x > visited [0].length - 1) {

                    }
                    if(!visited[x+1][y]) {
                        mazeGraph.addEdge(backing[x][y], backing[x + 1][y]);
                        generate(x + 1, y);
                        if (!visited[x - 1][y]) {
                            generate(x - 1, y);
                        }
                        break;
                    }
				}
				//down
				else if (r == 2 ) {
                    if(y - 1 < 0) {

                    }
                    if(!visited[x][y-1]) {
                        mazeGraph.addEdge(backing[x][y], backing[x][y - 1]);
                        generate(x, y - 1);
                        if (!visited[x][y + 1]) {
                            generate(x, y + 1);
                        }
                        break;
                    }
				}
				//left
				else if (r == 3 && !visited[x-1][y]) {
                    if(x - 1 < 0) {
                        mazeGraph.addEdge(backing[x][y], backing[x - 1][y]);
                        generate(x - 1, y);
                        if (!visited[x + 1][y]) {
                            generate(x + 1, y);
                        }
                    }
				}
			}
		}
	}
	private boolean checkGraph(int rows, int columns ) {
		for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
			for (int colIndex = 0; colIndex < columns; colIndex++) {
				if ( !visited[rowIndex][colIndex] )
					return false;
			}
		}
		return true;
	}

	/**
	 * @return an ordered list representing a path of vertices from the start to the finish
	 */
	@Override
	public ArrayList<Vertex> solveMaze() {
		return mazeGraph.shortestPath(start,finish);
	}

	/**
	 * @return a graph representing the maze
	 */
	@Override
	public Graph toGraph() {
		return mazeGraph;
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
		if( backing == null || backing.length < 2 )
			return null;
		else
			return start;
	}

	/**
	 * @return the finish vertex of this maze
	 */
	@Override
	public Vertex finishVertex() {
		if(backing == null || backing.length < 2 )
			return null;
		else
			return finish;
	}
}
