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
    
    boolean t1 = false;
    boolean t2 = false;
    
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
    
    //check input data before timestant
    public boolean haveDeadlock(int id, String function, String data, int limit) 
    {
        int cont = 0;
                
        for(Transaction t1 : arraylist)
        {
            
            cont++;
        }        
        return false;
    }
    
    
    
    //get deadlock
    public void checkTransaction()
    {
        int cont = 0;
        int id;
        String data;
        String function;        
        for(Transaction t1 : arraylist)
        {
            if(cont != 0)
            {
                            
                //data             
                    data = t1.getData();                
                
                //function
                if(t1.getFunction().equals(Transaction.FUNCTIONS.LOCK_S))
                    function = "LOCK_X";
                else if((t1.getFunction().equals(Transaction.FUNCTIONS.LOCK_X)))
                    function = "LOCK_S";
                else
                    function = null;
                                          
                 //veri
                if(t1.getId() == 1)
                {
                    id = 2;
                    
                    if(function != null)
                    this.t2 = haveDeadlock(id, function, data, cont); 
                }                    
                else
                {
                    id = 1;       
                    
                    if(function != null)
                    this.t1 = haveDeadlock( id, function, data, cont);
                }
                                                                    
            }
            
            cont++;
        }
        
        
    }
    
    
}
