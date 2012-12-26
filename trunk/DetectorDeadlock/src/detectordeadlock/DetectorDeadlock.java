/*
 * this file have method main that call newframe.java, user interface
 */
package detectordeadlock;

/**
 *
 * @author evandro
 */
public class DetectorDeadlock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ArrayListTransaction teste = new ArrayListTransaction();
//        try
//        {
//            Transaction t = teste.getTransaction(12);
//        }
//        catch(IndexOutOfBoundsException e)
//        {
//            System.out.print(e.getMessage());
//        }
        
        
        new NewJFrame().setVisible(true);        
    }
}
