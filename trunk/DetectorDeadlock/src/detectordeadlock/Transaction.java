/*
 * this class is responsible by transactions definitions
 */
package detectordeadlock;

/**
 *
 * @author evandro
 */
 

public class Transaction {
 
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
}
