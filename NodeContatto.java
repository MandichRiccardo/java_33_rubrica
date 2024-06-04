public class NodeContatto{
    final Contatto value;
    NodeContatto next;

    public NodeContatto(Contatto value) {
        this.value = value;
    }

    public boolean equals(NodeContatto n) {
        return n.value.equals(value);
    }
}