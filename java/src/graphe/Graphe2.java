package graphe;

import java.util.ArrayList;


public class Graphe2 extends Graphe {
    private ArrayList< Node > nodes;
    private Matrix matrix;

    // CSTR
	public Graphe2() {
        this.nodes = new ArrayList< Node >();
        this.matrix = new Matrix();
        this.matrix.addNode();
	}

    // METH
	public Node contenu() {
        if( nodes.size() > 0 )
            return contenu( 0 );
        return null;
	}

    public Node contenu( int i ) {
        if( i < nodes.size() )
            return nodes.get(i);
		return null;
    }

    public Graphe2 addNode(Node n) {
        this.matrix.addNode();
        this.nodes.add( n );
        return this;
    }

	public Graphe2 link( Node a, Node b, int w ) {
        if( nodes.contains(a) && nodes.contains(b) ) {
            int idA = nodes.indexOf( a ),
                idB = nodes.indexOf( b );

            this.matrix.link(idA, idB, w);
        } else 
            System.out.println("linking is impossible, at least one of the nodes ins't in the graphe");

		return this;
	}

	public ArrayList< Node > succ(Node n) {
        ArrayList< Node > res = new ArrayList< Node >();
        int[] arr = matrix.getLine( nodes.indexOf( n ) );

        for( int i=0; i<arr.length; i++ ) 
            if( arr[i] > 0)
                res.add( nodes.get(i) );

		return res;
	}

	public ArrayList< Node > pred(Node n) {
        ArrayList< Node > res = new ArrayList< Node >();
        int arr[] = matrix.getCol( nodes.indexOf( n ) );

        for( int i=0; i<arr.length; i++ )
            if( arr[i] > 0)
                res.add( nodes.get(i) );

		return res;
	}

    public int poids(Node a, Node b) {
        return matrix.poids( nodes.indexOf(a), nodes.indexOf(b) );
    }

    public void reset() {
        for( Node n: nodes )
            n.resetFrom();
    }

    // ========= /!\ UNIQUE /!\ ========== \\
    public void print() {
        matrix.printMatrix();
    }

    public String toString() {
        return this.matrix.toString();
    }

}

