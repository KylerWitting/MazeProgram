import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyVertex implements Vertex {

    private Pair element;
    ArrayList<Edge> myEdges;
	ArrayList<Vertex> myVertices;
	
	/**
	 * constructor for MyVertex
	 */
	public MyVertex ( ) {
		myEdges = new ArrayList<Edge>( );
		myVertices = new ArrayList<Vertex>( );
		element = new MyPair( );
	}

    @Override
    public String toString() {
        return "<" + element.toString() + ": " + myEdges + ">";
    }

    /**
	 * gets the element of MyVertex (the x/y location)
	 * @return the element of MyVertex
	 */
    @Override
    public Pair getElement() {
        return element;
    }

    /**
     * sets the element of MyVertex
     * @param e the new pair to be added to MyVertex
     */
    @Override
    public void setElement(Pair e) {
        element = e;
    }

    /**
     * @return the incident edges to this vertex
     */
    @Override
    public ArrayList<Edge> incidentEdges() {
        return myEdges;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyVertex) {
            MyVertex other = (MyVertex) obj;
            if(other.element.getX() == element.getX()) {
                if(other.element.getY() == element.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return the adjacent vertices to this MyVertex
     */
    @Override
    public ArrayList<Vertex> adjacentVertices() {
        return myVertices;
    }
}
