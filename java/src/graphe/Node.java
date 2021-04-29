package graphe;

public class Node {
    private String value;
    private Node from;
    private Integer poids;
    private int id;
    private static int nbNode = 0;

    public Node(String value) {
        this.value = value;
        this.from = null;
        this.poids = null;
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

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return ""+id+": "+value;
    }
}
