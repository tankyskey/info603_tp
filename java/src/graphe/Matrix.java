package graphe;

import java.util.ArrayList;

public class Matrix<Element> {
    // liste des noeuds du graphe courant
    private ArrayList<Graphe2<Element>> nodes;
    // nombre de neouds
    private int nbNode;
    // matice representant les liens entre les noeuds avec leur poids
    private int[][] matrix;

    // CSTR
    public Matrix() {
        this.matrix = new int[1][1] ;
        this.matrix[0][0] = 0;
        this.nodes = new ArrayList<Graphe2<Element>>();
        this.nbNode = 0;
    }

    // METH
    /**
     * ajoute un noeud a la liste de noeuds
     * puis l'ajoute dans la matrix, une colone et une ligne (passe de [n x n] à [n+1 x n+1])
     * @param g noeud à ajouter
     */
    public void addNode(Graphe2<Element> g) {
        // matrix temporaire
        int[][] temp_matrix = matrix;
        // on ajoute le noeud a liste des noeuds
        nodes.add( g );
        // on met a jour le nombre de noeud
        nbNode++;
        // extension de la matrix
        matrix = new int[nbNode][nbNode];

        // copie récupération des donné de la matrix temporaire
        for(int i=0; i<nbNode-1; i++)
            for(int j=0; j<nbNode-1; j++)
                matrix[i][j] = temp_matrix[i][j];

    }

    /**
     * créer un lien orienté entre deux noeuds a et b
     * @param a noeud de départ
     * @param b noeud d'arrivé
     * @param w poid du liens
     */
    public void link(Graphe2<Element> a, Graphe2<Element> b, int w) {
        int idA = nodes.indexOf(a),
            idB = nodes.indexOf(b);

        matrix[idA][idB] = w;
    }

    public String toString() {
        String res = "";
        // work around 
        for(int i=0; i<matrix.length; i++)  
            if(i<10)  
                res += "  "+i+" ";
            else      
                res += " "+i+" ";

        for( int i=0; i<matrix.length; i++) {
            res += "\n|";
            for( int j=0; j<matrix.length; j++) {
                res += " " + matrix[i][j] + " |";
            }
        }
        return res;
    }

    public void printMatrix() {
        // work around 
        for(int i=0; i<matrix.length; i++)  
            if(i<10)  
                System.out.print("  "+i+" ");  
            else      
                System.out.print(" "+i+" ");   

        System.out.println("");  

        for(int i=0; i<matrix.length; i++){  
            System.out.print("|");  
            for(int c: matrix[i]){  
                if(c != 0)  
                    System.out.print(" "+c+" |");  
                else  
                    System.out.print("   |");      
            }  
            System.out.println(" "+i);  
        }
    }

}
