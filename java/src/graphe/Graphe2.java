package graphe;

import java.util.ArrayList;

public class Graphe2 extends Graphe {
    private ArrayList< Node > nodes = new ArrayList< Node >();
    private Matrix matrix;

    // CSTR
	public Graphe2() {
        this.matrix = new Matrix();
        this.matrix.addNode();
	}

    // METH
    public Node contenu( int i ) {
		return nodes.get( i );
    }

	public Node contenu() {
        return contenu( 0 );
	}

    public Graphe2 addNode(Node n) {
        this.matrix.addNode();
        this.nodes.add( n );
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

	public Graphe2 link( Node a, Node b, int w ) {
        int idA = nodes.indexOf( a ),
            idB = nodes.indexOf( b );

        this.matrix.link(idA, idB, w);

		return this;
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

