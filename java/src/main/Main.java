package main;
import bous.Bous;
import graphe.*;

public class Main {

	public static void main(String[] args) {
		if( args.length < 1 ) {
			grapheTest();
		} else if( args[0].equals( "bous" ) ) {
			bousTest();
		} else if( args[0].equals( "graphe" ) ) {
			grapheTest();
		}
	}

	public static void bousTest() {
		int arr[] = {5, 2, 8, 3, 0, 5, 1};
		for( int e: arr)
			System.out.print( e+", " );
		System.out.println( "\n===" );

		Bous.sort( arr );
		for( int e: arr)
			System.out.print( e+", " );
		System.out.println( "\n===" );

	}

	public static void grapheTest() {
		// (1)->(2)->(3)
		//  |->(4)
		Graphe1<Integer> g1 = new Graphe1<Integer>(1);
		Graphe1<Integer> g2 = new Graphe1<Integer>(2);
		Graphe1<Integer> g3 = new Graphe1<Integer>(3);
		Graphe1<Integer> g4 = new Graphe1<Integer>(4);
		Graphe1<Integer> g5 = new Graphe1<Integer>(5);
		Graphe1<Integer> g6 = new Graphe1<Integer>(6);
		Graphe1<Integer> g7 = new Graphe1<Integer>(7);

		g1.ajoute_succ( g2 );
		g2.ajoute_succ( g3 );
		g1.ajoute_succ( g4 );
		g4.ajoute_succ( g5 );
		g5.ajoute_succ( g6 );
		g4.ajoute_succ( g7 );

		System.out.println( "contenu: " + g1.contenu() );
		System.out.println( "Succ: " + g1.getSucc().get(0).contenu() );

		g1.printGraphe();
	}

}

