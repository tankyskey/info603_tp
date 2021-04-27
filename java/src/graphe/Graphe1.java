package graphe;

import java.util.ArrayList;

public class Graphe1<Element> extends Graphe {
	Element value;
	ArrayList<Graphe1> successeurs;
	ArrayList<Graphe1> predeccesseurs;

    // CSTR
	public Graphe1(Element value) {
		this.value = value;
		this.successeurs = new ArrayList<Graphe1>();
		this.predeccesseurs = new ArrayList<Graphe1>();
	}

    // METH
	public Element contenu() {
		return this.value;
	}

	public Graphe1 ajoute_succ( Graphe gr, int w ) {
		Graphe1 g = (Graphe1)gr;

		this.successeurs.add( g );
		g.predeccesseurs.add( (Graphe)this );
		return this;
	}

    // GTR
	public ArrayList<Graphe1> getSucc() {
		return this.successeurs;
	}

	public ArrayList<Graphe1> getPred() {
		return this.predeccesseurs;
	}
}

