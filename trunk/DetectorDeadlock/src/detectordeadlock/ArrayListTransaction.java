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
    //new trying 
    //tt1[0] = a;
    //tt1[1] = b;
    
    //tt2[0] = a;
    //tt2[1] = b;
    
    private Integer[] tt1= new Integer[2];
    private Integer[] tt2= new Integer[2];   
    
    //check if have lock_s and lock_x
    private boolean mixedT1 = false;
    private boolean mixedT2 = false;
        
    ArrayList<Transaction> arraylist;

   @SuppressWarnings("unchecked")
    public ArrayListTransaction() {
            arraylist = new ArrayList();                        
            
            //set 0 all array
            tt1[0]=0;
            tt1[1]=0;
            tt2[0]=0;
            tt2[1]=0;            
    }
    
   public boolean isDeadlock()
   {
       if(mixedT1 && mixedT2)
       {    
            if( tt1[0]==1 && tt1[1]==1 && tt2[0]==1 && tt2[1]==1)
            {
                System.out.print("Ocorreu deadlock -------\n\n");
                return true;
            }   
       }
       return false;
   }              
   
   public void setDeadlock(Transaction t)           
   {
       if(t.getId()==1)
       {
           if(t.getFunction().toString().equals("LOCK_S") || t.getFunction().
                   toString().equals("LOCK_X"))
           {
               if(t.getData().equals("A"))
                   tt1[0]=1;
                   else
                   tt1[1]=1;    
               
               if(t.getFunction().toString().equals("LOCK_X"))
                   mixedT1 = true;
               
           }
           else if(t.getFunction().toString().equals("UNLOCK"))
           {
               tt1[0]=0;                   
               tt1[1]=0;
           }
       }
       
       if(t.getId()==2)
       {
           if(t.getFunction().toString().equals("LOCK_S") || t.getFunction().
                   toString().equals("LOCK_X"))
           {
               if(t.getData().equals("A"))
                   tt2[0]=1;
                   else
                   tt2[1]=1;
               
               if(t.getFunction().toString().equals("LOCK_X"))
                   mixedT2 = true;
           }                      
           else if(t.getFunction().toString().equals("UNLOCK"))
           {
               tt2[0]=0;                   
               tt2[1]=0;
           }                          
       }              
   }
   
   //test
   public boolean checkTransaction2()
   {
        int cont = 0;          
        Iterator<Transaction> itr = arraylist.iterator();
        
        while(itr.hasNext())
        {
            Transaction t = itr.next();            
            setDeadlock(t);     
            if(isDeadlock())
                return true;
            cont++;
        }
        
        return false;
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
    
    //to show result all transactions
    public void showResult()
    {
        if(checkTransaction2())
        {
            JOptionPane.showMessageDialog(null, "Ocorreu deadlock");
            new Desfazer(this).setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null, "Não ocorreu deadlock 2");
                       
    }
    
    // choice - qual transacao sera desfeita - 1 serah a T1 e 2 serah a T2 (na interface)
    public String rollBackTransaction (int choice) {
        
        String str = ""; 
        int tam = arraylist.size();
        for (int i = 1; i <= tam; i++){
            Transaction t = getTransaction(tam - i);
            if (t.getId() == choice){ //entao dados da T1
                str+=(t.getFunction().toString());
                str+=" (";
                str+=t.getData();
                str+=") ";
                str+="\n";
            }            
        }
        return str;        
    }
    
    //clear all values of arraylist
    public void clearArrayTransaction(){
        arraylist.clear();
    }
}
