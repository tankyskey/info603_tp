package graphe;

public class Matrix {
    // nombre de neouds
    private int nbNode;
    // matice representant les liens entre les noeuds avec leur poids
    private int[][] matrix;

    // CTR
    public Matrix() {
        //this.matrix = new int[1][1] ;
        // la case [0][0] doit etre a 0 (de manière générale: [i][i] = 0)
        //this.matrix[0][0] = 0;
        this.nbNode = 0;
    }

    // MET
    /**
     * ajoute un noeud a la liste de noeuds
     * puis l'ajoute dans la matrix, une colone et une ligne (passe de [n x n] à [n+1 x n+1])
     * @param n noeud à ajouter
     */
    public void addNode() {
        // matrix temporaire
        int[][] temp_matrix = matrix;
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
    public void link(int a, int b, int w) {
        matrix[a][b] = w;
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

    public int[] getLine(int i) {
        return matrix[i];
    }

    public int[] getCol(int i) {
        int[] arr = new int[nbNode];

        for( int j=0; j<nbNode; j++)
            arr[j] = matrix[j][i];

        return arr;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int poids(int a, int b) {
        return matrix[a][b];
    }

}
