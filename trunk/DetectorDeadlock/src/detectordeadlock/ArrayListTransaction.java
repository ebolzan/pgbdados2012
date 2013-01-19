/*
 * this file save all transactions put by user
 */
package detectordeadlock;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument;

/**
 * @author evandro, Gabriel Marchesan, Gabriel Lunardi, Lucas Gudergues
 */

public class ArrayListTransaction
{    
    //true if have deadlock in t1 or t2
    boolean t1 = false;
    boolean t2 = false;
    
    //used to know what line there were deadlocks
    int     line1;
    int     line2;
    
    ArrayList<Transaction> arraylist;

   @SuppressWarnings("unchecked")
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
    
    //check if have deadlock between line1 and line2
    public boolean haveUnlock()
    {        
        if(line1 > line2)
        {
            int aux = line1;
            line1   = line2;
            line2   = aux;                        
        }
        
        int i;        
        for(i=line1; i<line2; i++)
        {            
            try
            {
                Transaction t = getTransaction(i);
                
                //if have unlock return true
                if(t.getFunction().UNLOCK.toString().equals("UNLOCK"))
                    return true;
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println(e.getMessage());
            }           
        }
        
        //dont found unlock, return false
        return false;
    }
    
    
    //check input data before timestant
    public boolean haveDeadlock(int id, String function, String data, int limit) 
    {               
        //show results
        System.out.println("Buscando por "+id +" function "+function+""
                + " data " +data+ " limit "+ limit);
        
        int cont = 0;          
        Iterator<Transaction> itr = arraylist.iterator();
        
        while(itr.hasNext() && cont <= limit)
        {
            Transaction t = itr.next();            
                                    
            //check if have deadlock
            if(id == t.getId() && t.getFunction().toString().equals(function) &&
                    t.getData().equals(data))
            {
                System.out.println("retornando true\n");
                return true;
            }            
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
                data = t1.getData();                
                                
                if(t1.getFunction().equals(Transaction.FUNCTIONS.LOCK_S))
                    function = "LOCK_X";
                else if((t1.getFunction().equals(Transaction.FUNCTIONS.LOCK_X)))
                    function = "LOCK_S";
                else
                    function = null;
                                                          
                if(t1.getId() == 1)
                {
                    id = 2;
                    
                    if(function != null)
                    {
                        System.out.println("Linha de busca "+ cont);
                        if(haveDeadlock(id, function, data, cont))
                        {
                            this.t2    = true;
                            this.line2 = cont;
                        }                            
                    }                                                                                 
                }                    
                else
                {
                    id = 1;                           
                    if(function != null)
                    {
                        System.out.println("Linha de busca "+ cont);
                         if(haveDeadlock( id, function, data, cont))
                         {
                            this.t1    = true;
                            this.line1 = cont;
                         }
                    }                                      
                }                                                                    
            }            
            cont++;
        }                
    }    
    
    //to show 
    public void showResult()
    {
        this.checkTransaction();
        
        //test se have deadlock
        if(t1==true && t2==true)
        {
            //check if between t1 and t2 haven't unlock command
            if(haveUnlock())
            {
                JOptionPane.showMessageDialog(null, "Não ocorreu deadlock");
            }
            else
                JOptionPane.showMessageDialog(null, "Ocorreu deadlock");
        }
        else
            JOptionPane.showMessageDialog(null, "Não ocorreu deadlock");        
    }    
}