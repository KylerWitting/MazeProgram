import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyVertex implements Vertex {

    private Pair element;
    ArrayList<Edge> myEdges;
	ArrayList<Vertex> myVertices;
	
	public MyVertex ( ) {
		myEdges = new ArrayList<Edge>( );
		myVertices = new ArrayList<Vertex>( );
		element = new MyPair( );
	}

    @Override
    public Pair getElement() {
        return element;
    }

    @Override
    public void setElement(Pair e) {
        element = e;
    }

    @Override
    public ArrayList<Edge> incidentEdges() {
        return myEdges;
    }

    @Override
    public ArrayList<Vertex> adjacentVertices() {
        return myVertices;
    }
}
