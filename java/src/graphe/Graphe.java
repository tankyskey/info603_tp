package graphe;

import java.util.ArrayList;

public abstract class Graphe<Element>{

    /**
     * @return valeur de la racine
     */
	public abstract Element contenu();

    /**
     * @return liste des successeurs
     */
	public abstract ArrayList<Graphe<Element>> getSucc();

    /**
     * @return liste des predecesseurs
     */
	public abstract ArrayList<Graphe<Element>> getPred();

    /**
     * @param g noeud fils
     * @param w poids du liens du noeud courant au fils
     * @return graphe resultant
     */
	public abstract Graphe<Element> ajoute_succ( Graphe<Element> g, int w );

	public void printGraphe() {
		System.out.print( "("+ this.contenu() +")");
		int nbSucc = this.getSucc().size();

		for( Graphe<Element> g: this.getSucc() ) {

			System.out.print( "->" );
			g.printGraphe();

			if( nbSucc > 1 )
				System.out.print("\n |");

		}
	}
}





