import java.util.Objects;

public class Contatto{
    private final String nome;
    private final String cognome;
    private final String numero;

    public Contatto(){
        System.out.println("inserisci il nome di questo contatto");
        this.nome = getString();
        System.out.println("inserisci il cognome di " + nome);
        this.cognome = getString();
        System.out.println("inserisci il numero di " + nome + " " + cognome);
        this.numero = getString();
    }

    public Contatto(String nome, String cognome, String numero) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        String info = "\t\t\t" + super.toString() + "\n";
        info += "\t\t\tnome:\t\t" + nome + "\n";
        info += "\t\t\tcognome:\t" + cognome + "\n";
        info += "\t\t\tnumero:\t\t" + numero + "\n";
        return info;
    }

    public boolean equals(Contatto c) {
        if(!c.nome.equals(nome)) return false;
        return c.cognome.equals(cognome);
    }

    public static String getString(){
        try{
            return new java.util.Scanner(System.in).nextLine();
        }catch (java.util.InputMismatchException e){
            System.out.println("devi inserire una stringa");
            return getString();
        }
    }
}