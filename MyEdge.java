import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyEdge implements Edge {
	
	ArrayList<Vertex> myVertices;
    private int element;
    
    /**
     * constructor for MyEdge
     */
    public MyEdge ( ) {
		myVertices = new ArrayList<Vertex>( );
	}

    /**
     * @return the element int for MyEdge
     */
    @Override
    public int getElement() {
        return element;
    }

    /**
     * sets the element of MyEdge to param
     * @param the new element int 
     */
    @Override
    public void setElement(int e) {
        element = e;
    }

    @Override
    public String toString() {
        String retVal = "";
        for(Vertex vert :vertices()) {
            retVal += vert.getElement();
        }
        return element + "@" +retVal;
    }

    /**
     * @return the vertices of MyEdge
     */
    @Override
    public ArrayList<Vertex> vertices() {
        return myVertices;
    }
}
