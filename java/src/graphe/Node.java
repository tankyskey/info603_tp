package graphe;

public class Node {
    // valeur du noeud
    private String value;

    // id du noeud (affecté automatiquement, évite d'avoir a Labéliser tout les noeuds)
    private int id;
    private static int nbNode = 0;

    // utilisé par djikstra, indique le noeud précédent et le poids total
    private Node from;
    private Integer poids;

    public Node(String value) {
        this.value = value;
        this.from = null;
        this.poids = -1;
        this.id = nbNode;
        nbNode++;
    }

    public String getValue() {
        return value;
    }

    public Node getFrom() {
        return from;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setFrom(Node from, int poids) {
        this.from = from;
        this.poids = poids;
    }

    public void resetFrom() {
        this.from = null;
        this.poids = -1;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "\033[31m("+id+": "+value+")\033[0m";
    }
}

