package graphe;

import java.util.ArrayList;

public abstract class Graphe {

    /**
     * @brief Obtient le "ieme" noeud du graphe (1eme noeud inseré dans le graphe)
     * @return 1eme noeud du graphe
     * TODO: est-ce que le ieme noeud existe ?
     */
	public abstract Node contenu(int i);

    /**
     * @brief Obtient la liste des successeurs de n
     * @param n neoud de départ
     * @return liste des noeuds
     * TODO: - est-ce que n n'est pas null ?
     */
	public abstract ArrayList<Node> succ(Node n);

    /**
     * @brief Obtient la list des predecesseurs du noeud n dans le graphe
     * @param n noeud de départ de la recherche
     * @return liste des predecesseurs
     * TODO: - est-ce que n n'est pas null ?
     */
	public abstract ArrayList<Node> pred(Node n);

    /**
     * @brief ajoute noeud dans le graphe
     * @param n noeud a ajouter
     * @return graphe resultant
     * TODO: - est-ce que le noeud est déjà présent ?
     *       - est-ce que le noeud n'est pas null ?
     */
    public abstract Graphe addNode( Node n );

    /**
     * @brief relie deux noeuds a et b par un lien de poids w
     * @param a noeud de départ
     * @param b noeud de destination
     * @param w poids du liens du noeud courant au fils
     * @return graphe resultant
     * TODO: - est-ce que a et b existe bien dans le graphe ? 
     *       - est-ce que w > 0 ?
     */
	public abstract Graphe link( Node a, Node b, int w );

    /**
     * @brief mesure le poids de la liasons entre 2 noeud
     * @param a noeud de départ
     * @param b noeud d'arrivé
     * TODO: vérifier si les noeud a et b son bien directement connécté
     */
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
	public void printGraphe(Node first, String tabu, ArrayList<Node> settled) {
		System.out.print( first );
        settled.add( first );
		int nbSucc = this.succ( first ).size();

		for( Node n: this.succ( first ) ) {

			System.out.print( "-["+poids(first, n)+"]->" );
            this.printGraphe( n, tabu+"          " );

			if( nbSucc > 1 )
				System.out.print("\n"+tabu+"|\n"+tabu+"|");

		}
	}

	public void printGraphe() {
        ArrayList<Node> settled = new ArrayList<Node>();
        Node n = contenu();
        if( n != null ) {
            printGraphe( contenu(), "  ", settled);
            System.out.println("");
        } else {
            System.out.println( "Le graphe vide" );
        }
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

        if( succ( start ).size() == 0 )
            return null;

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

