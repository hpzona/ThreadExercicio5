
package threadexercicio5;

public class Armazena {

   private int valor;
   private boolean ocupado = false; // define 

   
   // para que os métodos wait() e notify() funcionem 
   // eles devem sempre estar dentro de um bloco synchronized
   public synchronized void setValor(int valor) {
      
      // enquanto o valor não for lido, coloca a thread em estado de espera
      while ( ocupado ) 
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
      // indica que a impressora pode ler outro valor
      // porque o contador acabou de incrementar o valor
      ocupado = true;
      // instrui a thread impressora em espera a entrar no estado executavel
      notify(); 
 
   }
   
   public synchronized int getValor() {
      
      // enquanto os dados não forem lidos, coloca thread em estado de espera
      while ( !ocupado )
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

      // indica que o contador pode incrementar o valor 
      // porque a impressora acabou de recuperar o valor
      ocupado = false;
      // instrui a thread contador em espera a entrar no estado executavel
      notify(); 

      return valor;
   }
}
