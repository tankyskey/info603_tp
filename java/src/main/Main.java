package main;
import bous.Bous;
import graphe.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Graphe1 g1 = new Graphe1();
    private static Graphe2 g2 = new Graphe2();
    private static Graphe g;

	public static void main(String[] args) {
		if( args.length < 1 ) {
            menu();

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

    // ========= MENU
    public static void menu() {
        Scanner input = new Scanner(System.in);

        String status = "";
        String[] options = {"quitter", "Graphe1", "Graphe2", "ajouter un noeud", "Djikstra", "Afficher le graphe", "Remplire les graphes"};

        int choix;
        final int Quitter = 0,
                  Graphe1 = 1,
                  Graphe2 = 2,
                  AddNode = 3,
                  AstarAl = 4,
                  PrintGr = 5,
                  Remplir = 6;
        g = g1;

        do {
            afficheStatus( status );
            afficheOptions( options );
            choix = input.nextInt();
            clearScreen();

            switch (choix) {
                case Graphe1:
                    g = g1;
                    break;

                case Graphe2:
                    g = g2;
                    break;

                case AddNode:
                    System.out.println("entrez la valeur du noeud: ");
                    String label = input.next();
                    g.addNode( new Node(label) );
                    break;

                case AstarAl:
                    subMenuDjikstra(input);
                    break;

                case PrintGr:
                    g.printGraphe();
                    waitInput();
                    break;

                case Remplir:
                    for( int i=0; i<10; i++ ) {
                        Node n = new Node("");
                        g1.addNode( n );
                        g2.addNode( n );
                    }
                    g1.link(0, 1, 10).link(1, 2, 15).link(2, 3, 5);
                    g1.link(1, 4, 12).link(4, 3, 2);
                    g1.link(0, 5, 15).link(5, 3, 10);

                    g2.link(0, 1, 10).link(1, 2, 15).link(2, 3, 5);
                    g2.link(1, 4, 12).link(4, 3, 2);
                    g2.link(0, 5, 15).link(5, 3, 10);
                    break;

                default:
                    break;
            }

        } while ( choix != Quitter );

        input.close();
    }

    public static void subMenuDjikstra(Scanner input) {
        String choix;

        do{
            g.printGraphe();
            System.out.println("entrez le numero du neoud de départ puis d'arrivé: ");
            int d = input.nextInt(),
                e = input.nextInt();

            if( g.succ( d ).size() != 0 ) {
                ArrayList<Node> parcour = g.djikstra(g.contenu(d), g.contenu(e));

                for( int i=parcour.size()-1; i>=0; i--)
                    System.out.println( parcour.get(i) );

            } else {
                System.out.println("aucun de chemin trouvé");
            }

            System.out.println("recommencer ? [y/n]");
            choix = input.next();
        } while( choix.equals("y") );
    }

    // ========= UTIL
    public static void afficheStatus(String status) {
        if(g == g2)
            status = "  Graphe1\n\033[32m* Graphe2\033[0m";
        else
            status = "\033[32m* Graphe1\033[0m\n  Graphe2";

        clearScreen();
        System.out.println( status + "\n\n---------\n\n" );
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void afficheOptions(String[] options) {
        for( int i=0; i<options.length; i++)
            System.out.println( ""+i+". "+options[i] );
    }

    public static void waitInput() {
        try {
            System.in.read();
        } catch (Exception e) {}
    }
}

