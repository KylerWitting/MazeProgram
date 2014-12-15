import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyVertex implements Vertex {

    private Pair element;

//    public MyVertex (MyGraph parent) {
//        this.parent = parent;
//    }

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
        return null;
    }

    @Override
    public ArrayList<Vertex> adjacentVertices() {
        return null;
    }
}
