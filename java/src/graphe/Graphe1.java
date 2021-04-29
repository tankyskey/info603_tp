package graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Graphe1 extends Graphe {
    private ArrayList< Node > nodes;
    private HashMap< Node, HashMap<Node, Integer> > map;
    //private HashMap< Node, ArrayList<Integer> > poids;

    // CSTR
	public Graphe1() {
        this.nodes = new ArrayList< Node >();
		this.map = new HashMap< Node, HashMap<Node, Integer> >();
		//this.poids = new HashMap< Node, ArrayList<Integer> >();
	}

    // METH
	public Node contenu() {
		return nodes.get(0);
	}

    public Node contenu(int i) {
        return nodes.get(i);
    }

	public Graphe1 link( Node a, Node b, int w ) {
        if( nodes.contains(a) && nodes.contains(b) ) {
            map.get(a).put(b, w);
            //poids.get(a).add(w);
        } else {
            System.out.println("linking is impossible, at least one of the nodes ins't in the graphe");
        }
		return this;
	}

    public Graphe1 addNode(Node n) {
        nodes.add( n );
        map.put( n, new HashMap<Node, Integer>() );
        //poids.put( n, new ArrayList<Integer>() );
        return this;
    }

    public int poids(Node a, Node b) {
        return map.get( a ).get( b );
    }

    // GTR
	public ArrayList<Node> succ(Node n) {
        ArrayList<Node> res = new ArrayList<Node>();

        /*
        HashMap<Node, Integer> succ_map = map.get(n);
        for( int i=0; i<succ_map.size(); i++) {

            Entry<Node, Integer> min = null;
            for( Entry<Node, Integer> e: succ_map.entrySet() ){
                if( res.contains( e.getKey() ) ) continue;
                if( min == null) min = e;
                if( min.getValue() > e.getValue() ) e = min;
            }
            res.add( min.getKey() );

        }
        */

        for( Node s: map.get(n).keySet() ) {
            res.add( s );
        }

        return res;
	}

	public ArrayList<Node> pred(Node a) {
        ArrayList<Node> res = new ArrayList<Node>();

        for( Node n: nodes ) {
            if( map.get(n).get(a) != null )
                res.add(n);
        }

        return res;
	}
}

