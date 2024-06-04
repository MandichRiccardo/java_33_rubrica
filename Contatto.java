import java.util.Objects;

public class Contatto{
    final String nome;
    final String cognome;
    final String numero;

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
        String info = super.toString() + "\n";
        info += "nome:\t\t" + nome + "\n";
        info += "cognome:\t" + cognome + "\n";
        info += "numero:\t\t" + numero + "\n";
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