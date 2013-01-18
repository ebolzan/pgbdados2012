/*
 * this file save all transactions put by user
 */
package detectordeadlock;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author evandro, Gabriel Marchesan, Gabriel Lunardi, Lucas Gudergues
 */
public class ArrayListTransaction
{    
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
       
        
        //mostrando resultados
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
                    {
                        System.out.println("Linha de busca "+ cont);
                        if(haveDeadlock(id, function, data, cont))
                            this.t2 = true;
                    }                       
                    
                    //test
                     if(this.t1==true && this.t2==true)
                       JOptionPane.showMessageDialog(null, "Ocorreu deadlock");
        
                }                    
                else
                {
                    id = 1;       
                    
                    if(function != null)
                    {
                        System.out.println("Linha de busca "+ cont);
                         if(haveDeadlock( id, function, data, cont))
                         this.t1 = true;
                    }
                      
                    
                    if(this.t1==true && this.t2==true)
                       JOptionPane.showMessageDialog(null, "Ocorreu deadlock");
                }                                                                    
            }            
            cont++;
        }                
    }    
    
    //to show 
    public void showResult()
    {
        this.checkTransaction();
        
        if(t1==true && t2==true)
            JOptionPane.showMessageDialog(null, "Ocorreu deadlock");
        else
            JOptionPane.showMessageDialog(null, "Não ocorreu deadlock");
        
    }
    
}