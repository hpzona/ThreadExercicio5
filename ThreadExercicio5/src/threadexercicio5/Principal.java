package threadexercicio5;

public class Principal {

   public static void main(String[] args) {
   
   Armazena objCompartilhado = new Armazena();
   Contador contador = new Contador(objCompartilhado);
   Impressora impressora = new Impressora(objCompartilhado);
   
   Thread cont = new Thread(contador);
   Thread imp  = new Thread(impressora);
   
   cont.start();
   imp.start();
   
   }
}
