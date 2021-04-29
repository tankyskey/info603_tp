package main;
import bous.Bous;
import graphe.*;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		if( args.length < 1 ) {
			grapheTest1();
		} else if( args[0].equals( "bous" ) ) {
			bousTest();
		} else if( args[0].equals( "graphe1" ) ) {
			grapheTest1();
		} else if( args[0].equals( "graphe2" ) ) {
			grapheTest2();
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

	public static void grapheTest1() {
		Graphe1 g1 = new Graphe1();

        Node n0 = new Node("Hello"),
             n1 = new Node("Hi");

        g1.addNode( n0 );
        g1.addNode( n1 );
        g1.link( n0, n1, 1 );

		g1.printGraphe();

        g1 = new Graphe1();
        for( int i=0; i<10; i++ )
            g1.addNode( new Node("") );

        g1.link(0, 1, 10).link(1, 2, 15).link(2, 3, 5);
        g1.link(1, 4, 12).link(4, 3, 2);
        g1.link(0, 5, 15).link(5, 3, 10);
		g1.printGraphe();

        ArrayList<Node> parcour = g1.djikstra(g1.contenu(0), g1.contenu(3));
        for( int i=parcour.size()-1; i>0; i++)
            System.out.println( parcour.get(i) );
	}

    public static void grapheTest2() {
        Graphe2 g1 = new Graphe2();

        Node n0 = new Node("Hello"),
             n1 = new Node("Hi");

        g1.addNode( n0 );
        g1.addNode( n1 );
        g1.link( n0, n1, 1 );

		System.out.println( "Succ: " + g1.succ( n0 ).get(0) );
		g1.printGraphe();

        g1 = new Graphe2();
        for( int i=0; i<10; i++ )
            g1.addNode( new Node("") );

        g1.link(0, 1, 10).link(1, 2, 15).link(2, 3, 5);
        g1.link(1, 4, 12).link(4, 3, 2);
        g1.link(0, 5, 15).link(5, 3, 10);
		g1.printGraphe();

        ArrayList<Node> parcour = g1.djikstra(g1.contenu(0), g1.contenu(3));
        for( Node n: parcour )
            System.out.println(n);

    }
}

