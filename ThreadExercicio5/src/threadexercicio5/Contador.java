package threadexercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Contador implements Runnable{

   private int contagem;
   private Armazena objCompartilhado;

   Contador(Armazena objCompartilhado) {
      this.objCompartilhado = objCompartilhado;
      contagem = 0;
   }

   public void run() {
      while (true) {
         objCompartilhado.setValor(contagem++);
      }

   }
}
