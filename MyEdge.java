import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyEdge implements Edge {
	ArrayList<Vertex> myVertices;
    private int element;
    
    public MyEdge ( ) {
		myVertices = new ArrayList<Vertex>( );
	}

    @Override
    public int getElement() {
        return element;
    }

    @Override
    public void setElement(int e) {
        element = e;
    }

    @Override
    public ArrayList<Vertex> vertices() {
        return null;
    }
}
