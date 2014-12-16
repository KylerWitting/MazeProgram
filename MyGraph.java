import java.util.ArrayList;

/**
 * Created by Snake on 12/14/2014.
 */
public class MyGraph implements Graph {
	
	ArrayList<Vertex> myVertices;
	ArrayList<Edge> myEdges;

	/**
	 * constructor for MyGraph
	 */
	public MyGraph( ) {
		myVertices = new ArrayList<Vertex>( );
		myEdges = new ArrayList<Edge>( );
	}
	
	/**
	 * @return the vertices of this Graph
	 */
    @Override
    public ArrayList<Vertex> vertices( ) {
        return myVertices;
    }

    /**
     * Creates a new vertex in this MyGraph
     * @param the pair to create the new vertex from
     * @return the vertex that was created 
     */
    @Override
    public Vertex addVertex( Pair p ) {
    	//TODO
    	return null;
    }

    /**
     * Creates a new vertex in this MyGraph using a Vertex
     * @param The vertex to add
     * @return the Vertex that was added
     */
    @Override
    public Vertex addVertex( Vertex v ) {
    	//TODO possibly. Not sure how the adjacent stuff will work
    	myVertices.add( v );
		return v;
    }

    /**
     * removes a vertex from MyGraph using a pair
     * @param the pair of the vertex to remove from MyGraph
     * @return true if the vertex was removed
     */
    @Override
    public boolean removeVertex( Pair p ) {
    	//TODO
    	return false;
    }

    /**
     * removes a vertex from MyGraph
     * @param the vertex to be removed 
     * @return true if the vertex was removed 
     */
    @Override
    public boolean removeVertex( Vertex v1 ) {
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

    /**
     * finds the vertex in the graph by using a pair 
     * @param the pair of the vertex you are trying to find
     * @return the vertex that was found 
     */
    @Override
    public Vertex findVertex( Pair p ) {
    	//TODO
        return null;
    }

    /**
     * @return the edges in MyGraph
     */
    @Override
    public ArrayList<Edge> edges( ) {
        return myEdges;
    }

    /**
     * adds and edge to MyGraph using 2 vertices
     * @param the vertices that the new edge will be created from 
     * @return the edge that was created 
     */
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

    /**
     * adds an edge to MyGraph using an edge
     * @param the edge to add 
     * @return the edge that was added
     */
    @Override
    public Edge addEdge( Edge e ) {
		myEdges.add( e );
		Edge newEdge = e;
		addEdgeToVertex( newEdge.vertices().get(0), newEdge.vertices().get(1), newEdge );
		return e;
    }

    /**
     * removes an edge from the graph
     * @param the vertices that will indicate the edge to remove 
     * @return true if edge was removed
     */
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

    /**
     * removes an edge from MyGraph
     * @param the edge to remove 
     * @return true if the edge was removed
     */
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

    /**
     * finds an edge in MyGraph
     * @param the vertices that make up the edge to find
     * @return the edge that was found 
     */
    @Override
    public Edge findEdge( Vertex v1, Vertex v2 ) {
    	for ( int i = 0; i < myEdges.size(); i++ ) {
			if ( myEdges.get( i ).vertices().contains( v1 ) && myEdges.get( i ).vertices().contains( v2 ) )
				return myEdges.get( i );
		}
		return null;
    }

    /**
     * checks to see if the two vertices are connected by an edge
     * @param the 2 vertices to be checked
     * @return true if the vertices are connected 
     */
    @Override
    public boolean areConnected( Vertex v1, Vertex v2 ) {
    	for ( int i = 0; i < myEdges.size(); i++ ) {
			if ( myEdges.get( i ).vertices().contains( v1 ) && myEdges.get( i ).vertices().contains( v2 ) )
				return true;
		}
		return false;
    }

    /**
     * @return the adjacent vertices of the given vertex
     */
    @Override
    public ArrayList<Vertex> adjacentVertices( Vertex v1 ) {
        return v1.adjacentVertices( );
    }

    /**
     * @return the incident edges of the given vertex
     */
    @Override
    public ArrayList<Edge> incidentEdges( Vertex v1 ) {
        return v1.incidentEdges( );
    }

    /**
     * finds the shortest path between 2 vertices 
     * @param the vertices to find the path between
     * @return ArrayList of vertices that are the shortest path between 2 vertices 
     */
    @Override
    public ArrayList<Vertex> shortestPath( Vertex v1, Vertex v2 ) {
    	//TODO
        return null;
    }

    /**
     * @return the minimum spanning tree of MyGraph
     */
    @Override
    public Graph minimumSpanningTree( ) {
    	//TODO
        return null;
    }
}
