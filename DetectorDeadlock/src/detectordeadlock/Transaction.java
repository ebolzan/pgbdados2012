/*
 * this class is responsible by transactions definitions
 */
package detectordeadlock;
/**
 * @author evandro, lucas, gabriel m, gabriel l.
 */
 
public class Transaction {
 
    //five states which can be each input user data
    enum FUNCTIONS {
        LOCK_S , LOCK_X, READ, WRITE,
        UNLOCK;
    }
    
    private int id;
    private String data;
    private FUNCTIONS function;
    
    //default constructor
    public Transaction(int id, String data, FUNCTIONS function)
    {        
        this.id = id;
        this.data = data;
        this.function = function;              
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public FUNCTIONS getFunction() {
        return function;
    }

    public void setFunction(FUNCTIONS function) {
        this.function = function;
    }

    public int getId() {
        return id;
    }            
}
