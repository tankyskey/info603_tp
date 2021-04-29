package graphe;

import java.util.ArrayList;
import java.util.HashMap;

public class Graphe1 extends Graphe {
    private ArrayList< Node > nodes;
    private HashMap< Node, HashMap<Node, Integer> > map;

    // CSTR
	public Graphe1() {
        this.nodes = new ArrayList< Node >();
		this.map = new HashMap< Node, HashMap<Node, Integer> >();
	}

    // METH
	public Node contenu() {
        if( nodes.size() > 0 )
            return nodes.get(0);
        return null;
	}

    public Node contenu(int i) {
        if( i < nodes.size() )
            return nodes.get(i);
        return null;
    }

    public Graphe1 addNode(Node n) {
        nodes.add( n );
        map.put( n, new HashMap<Node, Integer>() );
        return this;
    }

	public Graphe1 link( Node a, Node b, int w ) {
        if( nodes.contains(a) && nodes.contains(b) )
            map.get(a).put(b, w);
        else
            System.out.println("linking is impossible, at least one of the nodes ins't in the graphe");

		return this;
	}

	public ArrayList<Node> succ(Node n) {
        ArrayList<Node> res = new ArrayList<Node>();

        for( Node s: map.get(n).keySet() )
            res.add( s );

        return res;
	}

	public ArrayList<Node> pred(Node n) {
        ArrayList<Node> res = new ArrayList<Node>();

        for( Node m: nodes )
            if( map.get(m).get(n) != null )
                res.add(m);

        return res;
	}

    public int poids(Node a, Node b) {
        return map.get( a ).get( b );
    }

    public void reset() {
        for( Node n: nodes )
            n.resetFrom();
    }

    // ========= /!\ UNIQUE /!\ ========== \\
}

