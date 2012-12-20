/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package detectordeadlock;

import java.util.ArrayList;

/**
 *
 * @author evandro, GABRIE, LUCAS
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
