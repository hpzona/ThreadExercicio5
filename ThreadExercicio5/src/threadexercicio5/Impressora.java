package threadexercicio5;

public class Impressora  implements Runnable {

   private Armazena objCompartilhado;

   Impressora(Armazena objCompartilhado) {
      this.objCompartilhado = objCompartilhado;
   }

   public void run() {
      while (true) {
         System.out.println(objCompartilhado.getValor());
      }

   }
}
