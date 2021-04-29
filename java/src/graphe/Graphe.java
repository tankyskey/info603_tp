package graphe;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Graphe {

    /**
     * Obtient le "ieme" noeud du graphe (1eme noeud inseré dans le graphe)
     * @return 1eme noeud du graphe
     */
	public abstract Node contenu(int i);

    /**
     * Obtient la liste des successeurs ordonée de a selon leur poids
     * @param n neoud de départ
     * @return liste des noeuds
     */
	public abstract ArrayList<Node> succ(Node n);

    /**
     * Obtient la list des predecesseurs
     * @param n noeud de départ de la recherche
     * @return liste des predecesseurs
     */
	public abstract ArrayList<Node> pred(Node n);

    /**
     * @param n noeud a ajouter
     * @return graphe resultant
     */
    public abstract Graphe addNode( Node n );

    /**
     * @param a noeud de départ
     * @param b noeud de destination
     * @param w poids du liens du noeud courant au fils
     * @return graphe resultant
     */
	public abstract Graphe link( Node a, Node b, int w );

    public abstract int poids(Node a, Node b);

    public abstract void reset();

    // ============================
	public Node contenu() {
        return contenu( 0 );
    }

	public ArrayList<Node> succ(int i) {
        return succ( contenu(i) );
    }

	public ArrayList<Node> pred(int i) {
        return pred( i );
    }

    public Graphe addNode(String e) {
        return addNode( new Node(e) );
    }

	public Graphe link( int a, int b, int w ) {
        return link( contenu(a), contenu(b), w );
    }

    // ============================
	public void printGraphe(Node first, String tabu) {
		System.out.print( "("+ first +")");
		int nbSucc = this.succ( first ).size();

		for( Node n: this.succ( first ) ) {

			System.out.print( "-["+poids(first, n)+"]->" );
            this.printGraphe( n, tabu+"          " );

			if( nbSucc > 1 )
				System.out.print("\n"+tabu+"|\n"+tabu+"|");

		}
	}

	public void printGraphe() {
        printGraphe( contenu(), "  " );
        System.out.println("");
	}

    public void djikstraEval(Node start, Node end) {
        if( start != end ) {
            for( Node n: succ(start) ) {
                int w = start.getPoids() + poids(start, n);
                if( n.getPoids() == -1 || w < n.getPoids() ) {
                    n.setFrom( start, w );
                    djikstraEval( n, end );
                }
            }
        }
    }

    public ArrayList<Node> djikstra(Node start, Node end) {
        ArrayList<Node> res = new ArrayList<Node>();

        djikstraEval( start, end );

        Node d = end;
        while( d != start ) {
            res.add( d );
            d = d.getFrom();
        }
        res.add( d );

        reset();

        return res;
    }
}

