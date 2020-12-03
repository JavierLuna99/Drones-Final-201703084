//Javier Enrique Luna Díaz
package JDrones;

public class NumDron {
    private int conta;
    
    NumDron(){
        conta = 1;
    }
    
    public int getConta() {
        return conta;
    }
    
    public void setConta(int conta) {
        this.conta = conta;
    }
     
    public void aumentaDron(){
         this.conta++;
    }
    
}
