
package threadexercicio5;

public class Armazena {

   private int valor;
   private boolean occupied = false; 

   
   // para que os métodos wait() e notify() funcionem 
   // eles devem sempre estar dentro de um bloco synchronized
            
   public synchronized int getValor() {
      
      // enquanto os dados nao são lidos, coloca thread em estado de espera
      while ( !occupied )
      {
         // espera
         try 
         {
            wait();
         } // fim try
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // fim catch
      } // fim while

      // indica que a produtora pode armazenar outro valor 
      // porque a consumidora acabou de recuperar o valor do buffer
      occupied = false;
      notify(); // instrui a thread em espera a entrar no estado executavel

      return valor;

   }

   public synchronized void setValor(int valor) {
      
      // enquanto o valor não for lido, coloca a thread em estado de espera
      while ( occupied ) 
      {
         // espera
         try 
         {
            wait();
         } // fim try
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // fim catch
      } // fim while
        
      this.valor = valor;
      
      // indica que a produtora nao pode armazenar outro valor
      // ate que a consumidora recupere valor atual de buffer
      occupied = true;
      notify(); // instrui a thread em espera a entrar no estado executavel
 
   }
}
