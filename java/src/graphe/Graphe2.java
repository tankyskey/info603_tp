package graphe;

import java.util.ArrayList;

public class Graphe2<Element> extends Graphe {
	Element value;
	Graphe2[] successeurs;

	public Graphe2(Element value) {
		this.value = value;
		this.successeurs = new Graphe2[0];
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

	public Graphe2 ajoute_succ( Graphe gr ) {
		// TODO
		return this;
	}

}

