/*
 * this file save all transactions put by user
 */
package detectordeadlock;

import java.util.ArrayList;

/**
 *
 * @author evandro, Gabriel Marchesan, Gabriel Lunardi, Lucas Gudergues
 */
public class ArrayListTransaction{
    
    ArrayList<Transaction> arraylist;

    public ArrayListTransaction() {
        arraylist = new ArrayList();                
    }
    
    //insert new transaction
    public void insert(Transaction t)
    {
        arraylist.add(t);        
    }
    
    //return transaction element by index 
    public Transaction getTransaction(int index) throws  IndexOutOfBoundsException 
    {
        if(index < 0 || index >= arraylist.size())             
            throw new  IndexOutOfBoundsException("Index is out of bounds");
            
        return arraylist.get(index);
    }           
    
}
