package threadexercicio5;

public class Principal {

   public static void main(String[] args) {
   
   Armazena objCompartilhado = new Armazena();
   Contador contador = new Contador(objCompartilhado);
   Impressora impressora = new Impressora(objCompartilhado);
   
   contador.start();
   impressora.start();
   
   }
}
