package graphe;

import java.util.ArrayList;

public class Graphe2<Element> extends Graphe<Element> {
	private Element value;
    private Matrix<Element> matrix;

	public Graphe2(Element value) {
		this.value = value;
        this.matrix = new Matrix<Element>();
        this.matrix.addNode(this);
	}

	public Element contenu() {
		return this.value;
	}

	public ArrayList<Graphe<Element>> getSucc() {
		return null;
	}

	public ArrayList<Graphe<Element>> getPred() {
		return null;
	}

	public Graphe2<Element> ajoute_succ( Graphe<Element> gr, int w ) {
        Graphe2<Element> g = (Graphe2<Element>) gr;

        this.matrix.addNode( g );
        this.matrix.link(this, g, w);

		return this;
	}

    public void print() {
        matrix.printMatrix();
    }

    public String toString() {
        return this.matrix.toString();
    }

}

