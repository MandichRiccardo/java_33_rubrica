public class NodeContatto{
    private final Contatto value;
    private NodeContatto next;

    public NodeContatto(Contatto value) {
        this.value = value;
    }

    public Contatto getValue() {
        return value;
    }

    public NodeContatto getNext() {
        return next;
    }

    public void add(NodeContatto n) throws ContactAlreadyAddedRuntimeException {
        if(next == null) next = n;
        else{
            if(next.equals(n)) throw new ContactAlreadyAddedRuntimeException("il nuovo contatto è uguale a un nodo già presente");
            else next.add(n);
        }
    }

    public void remove(NodeContatto n) throws ContactNotFindRuntimeException {
        try{
            if(next.equals(n)) next = next.next;
            else next.remove(n);
        }catch (NullPointerException e){
            throw new ContactNotFindRuntimeException("contatto non trovato nella rubrica");
        }
    }

    public String cerca(String nome, String cognome) throws ContactNotFindRuntimeException {
        try{
            if(value.getNome().equals(nome) && value.getCognome().equals(cognome)) return value.getNumero();
            else return next.cerca(nome, cognome);
        }catch (NullPointerException e){
            return null;
        }
    }

    public boolean equals(NodeContatto n) {
        return n.value.equals(value);
    }
}