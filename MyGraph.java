import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyGraph implements Graph {
	
	ArrayList<Vertex> myVertices;
	ArrayList<Edge> myEdges;

	public MyGraph( ) {
		myVertices = new ArrayList<Vertex>( );
		myEdges = new ArrayList<Edge>( );
	}
	
    @Override
    public ArrayList<Vertex> vertices( ) {
        return myVertices;
    }

    @Override
    public Vertex addVertex( Pair p ) {
    	//TODO
    	return null;
    }

    @Override
    public Vertex addVertex( Vertex v ) {
    	myVertices.add( v );
		return v;
    }

    @Override
    public boolean removeVertex( Pair p ) {
    	//TODO
    	return false;
    }

    @Override
    public boolean removeVertex( Vertex v ) {
    	if ( myVertices.contains( v1 ) ) {
			for ( int i = 0; i < v1.adjacentVertices().size(); i++ ) {
				Vertex v2 = v1.adjacentVertices().get( i );
				v2.adjacentVertices().remove( v1 );
				v2.incidentEdges().remove( findEdge( v1, v2 ) );
				myEdges.remove( findEdge( v1, v2) );
			}
		}
		return myVertices.remove( v1 );
    }

    @Override
    public Vertex findVertex( Pair p ) {
    	//TODO
        return null;
    }

    @Override
    public ArrayList<Edge> edges( ) {
        return myEdges;
    }

    @Override
    public Edge addEdge( Vertex v1, Vertex v2 ) {
    	Edge newEdge = new MyEdge( );
		newEdge.vertices().add( v1 );
		newEdge.vertices().add( v2 );
		myEdges.add( newEdge );
		addEdgeToVertex( v1, v2, newEdge );
		return newEdge;
    }
    
    public void addEdgeToVertex( Vertex v1, Vertex v2, Edge newEdge ) {
		v1.adjacentVertices().add( v2 );
		v2.adjacentVertices().add( v1 );
		v1.incidentEdges().add( newEdge );
		v2.incidentEdges().add( newEdge );
	}

    @Override
    public Edge addEdge( Edge e ) {
		myEdges.add( e );
		Edge newEdge = e;
		addEdgeToVertex( newEdge.vertices().get(0), newEdge.vertices().get(1), newEdge );
		return e;
    }

    @Override
    public boolean removeEdge( Vertex v1, Vertex v2 ) {
		for ( int i = 0; i < myEdges.size(); i++ ) {
			if ( myEdges.get( i ).vertices().contains( v1 ) && myEdges.get( i ).vertices().contains( v2 ) ) {
				v1.incidentEdges().remove( myEdges.get( i ) );
				v2.incidentEdges().remove( myEdges.get( i ) );
				myEdges.remove( i );
				v1.adjacentVertices().remove( v2 );
				v2.adjacentVertices().remove( v1 );
				return true;
			}
		}
		return false;
    }

    @Override
    public boolean removeEdge( Edge e ) {
    	Vertex v1 = e.vertices().get( 0 );
		Vertex v2 = e.vertices().get( 0 );
		v1.incidentEdges().remove( e );
		v2.incidentEdges().remove( e );
		v1.adjacentVertices().remove( v2 );
		v2.adjacentVertices().remove( v1 );
		return myEdges.remove( e );
    }

    @Override
    public Edge findEdge( Vertex v1, Vertex v2 ) {
    	for ( int i = 0; i < myEdges.size(); i++ ) {
			if ( myEdges.get( i ).vertices().contains( v1 ) && myEdges.get( i ).vertices().contains( v2 ) )
				return myEdges.get( i );
		}
		return null;
    }

    @Override
    public boolean areConnected( Vertex v1, Vertex v2 ) {
    	for ( int i = 0; i < myEdges.size(); i++ ) {
			if ( myEdges.get( i ).vertices().contains( v1 ) && myEdges.get( i ).vertices().contains( v2 ) )
				return true;
		}
		return false;
    }

    @Override
    public ArrayList<Vertex> adjacentVertices( Vertex v1 ) {
        return v1.adjacentVertices( );
    }

    @Override
    public ArrayList<Edge> incidentEdges( Vertex v1 ) {
        return v1.incidentEdges( );
    }

    @Override
    public ArrayList<Vertex> shortestPath( Vertex v1, Vertex v2 ) {
    	//TODO
        return null;
    }

    @Override
    public Graph minimumSpanningTree( ) {
    	//TODO
        return null;
    }
}
