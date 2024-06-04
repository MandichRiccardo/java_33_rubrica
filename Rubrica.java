public class Rubrica{
    private NodeContatto start;
    private int size;

    Rubrica(){
        System.out.println("vuoi inserire il primo nodo?");
        add(getBoolean() ? new NodeContatto(new Contatto()) : null);
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
}