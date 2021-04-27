package graphe;

import java.util.ArrayList;

public class Graphe2<Element> extends Graphe {
	private Element value;
    private int id;

	public Graphe2(Element value) {
		this.value = value;
	}

	public Element contenu() {
		return this.value;
	}

	public ArrayList<Graphe2> getSucc() {
		return null;
	}

	public ArrayList<Graphe2> getPred() {
		return null;
	}

	public Graphe2 ajoute_succ( Graphe gr, int w ) {
		// TODO
        Graphe2 g = (Graphe2) gr;

		return this;
	}

}

