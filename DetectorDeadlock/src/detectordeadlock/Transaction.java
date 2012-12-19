/*
 * this class is responsible by transactions definitions
 */
package detectordeadlock;

/**
 *
 * @author evandro
 */
 

public class Transaction {
 
    enum functions {
        LOCK_S , LOCK_X, READ, WRITE,
        UNLOCK;
    }
    
    private char data;
    private functions function;
    
    //default constructor
    public Transaction(char data, functions function)
    {        
        this.data = data;
        this.function = function;
        System.out.print(function);
        
    }
}
