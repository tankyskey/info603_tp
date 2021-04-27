package graphe;

import java.util.ArrayList;

public abstract class Graphe<Element>{

	public abstract Element contenu();

	public abstract ArrayList<Graphe> getSucc();

	public abstract ArrayList<Graphe> getPred();

	public abstract Graphe ajoute_succ( Graphe g, int w );

	public void printGraphe() {
		System.out.print( "("+ this.contenu() +")");
		int nbSucc = this.getSucc().size();

		for( Graphe g: this.getSucc() ) {
			System.out.print( "->" );
			g.printGraphe();

			if( nbSucc > 1 )
				System.out.print("\n |");
		}

	}

}

