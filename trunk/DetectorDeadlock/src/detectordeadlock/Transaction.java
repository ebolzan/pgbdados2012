/*
 * this class is responsible by transactions definitions
 */
package detectordeadlock;

/**
 *
 * @author evandro
 */
 

public class Transaction {
 
    //five states which can be each input user data
    enum FUNCTIONS {
        LOCK_S , LOCK_X, READ, WRITE,
        UNLOCK;
    }
    
    private char data;
    private FUNCTIONS function;
    
    //default constructor
    public Transaction(char data, FUNCTIONS function)
    {        
        this.data = data;
        this.function = function;
        System.out.print(function);
        
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public FUNCTIONS getFunction() {
        return function;
    }

    public void setFunction(FUNCTIONS function) {
        this.function = function;
    }
    
    
}
