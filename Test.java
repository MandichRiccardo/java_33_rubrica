public class Test{
    public static void main(String[] args){
        Rubrica r = new Rubrica();
        System.out.println(r);
        boolean running = true;
        while (running){
            System.out.println("""
                    cosa vuoi fare?
                        0)\tterminare il programma
                        1)\taggiungere un contatto
                        2)\trimuovere un contatto
                        3)\tcercare un contatto tramite nome e cognome""");
            switch (getInt()){
                default -> running = false;
                case 1 -> r.add(new NodeContatto(new Contatto()));
                case 2 -> r.remove(new NodeContatto(new Contatto()));
                case 3 -> System.out.println("il risultato di questa ricerca è \"" + r.cerca() + "\"");
            }
            System.out.println("stato della rubrica:\n" + r);
        }
    }

    public static int getInt(){
        try{
            return new java.util.Scanner(System.in).nextInt();
        }catch(java.util.InputMismatchException e){
            System.out.println("devi inserire un numero intero");
            return getInt();
        }
    }
}