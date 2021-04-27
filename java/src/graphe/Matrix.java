package graphe;

import java.util.ArrayList;
import java.util.HashMap;

public class Matrix {
    // liste des noeuds du graphe courant
    private ArrayList<Graphe2> nodes;
    // nombre de neouds
    private int nbNode;
    // matice representant les liens entre les noeuds avec leur poids
	private ArrayList<int[]> matrix;
    // 0 |=====
    // 1 |X|===
    // 2 |X|X|=
    // 3 |X|X|X

    // CSTR
    public Matrix() {
        this.matrix = new ArrayList<int[]>();
        this.nodes = new ArrayList<Graphe2>();
        this.nbNode = 0;
    }

    // METH
    public void addNode(Graphe2 g) {
        this.nodes.add( g );
        this.nbNode++;
        this.matrix.get(nbNode) = new int[nbNode]();
    }
}
