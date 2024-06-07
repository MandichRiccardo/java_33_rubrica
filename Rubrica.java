public class Rubrica{
    private NodeContatto start;
    private int size;

    Rubrica(){
        size = 0;
        start = null;
    }

    public void add(NodeContatto n) throws ContactAlreadyAddedRuntimeException {
        if(start == null) start = n;
        else{
            if(start.equals(n)) throw new ContactAlreadyAddedRuntimeException("il nuovo contatto è uguale a quello presente sul nodo start");
            else start.add(n);
        }
        size++;
    }

    public void remove(NodeContatto n) throws ContactNotFindRuntimeException {
        try{
            if(start.equals(n)) start = start.getNext();
            else start.remove(n);
        }catch (NullPointerException e){
            throw new ContactNotFindRuntimeException("la lista è vuota per cui il contatto da rimuovere non è presente nella rubrica");
        }catch (ContactNotFindRuntimeException ex){
            throw ex;
        }
        size--;
    }

    public String cerca(){
        System.out.println("inserisci il nome da cercare");
        String nome = Contatto.getString();
        System.out.println("inserisci il cognome da cercare");
        return cerca(nome, Contatto.getString());
    }

    public String cerca(String nome, String cognome){
        try{
            if(start.getValue().getNome().equals(nome) && start.getValue().getCognome().equals(cognome)) return start.getValue().getNumero();
            else return start.getNext().cerca(nome, cognome);
        }catch (NullPointerException e){
            return null;
        }
    }

    public static boolean getBoolean(){
        try{
            System.out.println("insert a boolean value with the format \"true\" or \"false\"");
            return new java.util.Scanner(System.in).nextBoolean();
        }catch (java.util.InputMismatchException e){
            return getBoolean();
        }
    }

    @Override
    public String toString(){
        String info = "";
        info += "size:\t" + size + "\n";
        info += "\tlista iniziata\n";
        if(start != null) info += "\tstart:\n" + start + "\n";
        else info += "\tlista terminata\n";
        return info;
    }
}