
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lisa
 */
public class JavaApplication {
    public static void main(String[] args) throws Exception {
       /* monThread t1 = new monThread();
        monThread t2 = new monThread();
        t1.start();
        t2.start();
        t1.join(); 
        t2.join();
        System.out.println("Tout le monde a fini");*/
       
       List<String> produits = new ArrayList();

       // on remplit la liste
       for (int i=0;i<100;i++) {
             produits.add("numéro "+i);
             }
        Consommateur cons = new Consommateur(produits);
        cons.start();
        
        Consommateur cons2 = new Consommateur(produits);
        cons2.start();
        
        Consommateur cons3 = new Consommateur(produits);
        cons3.start();
    }
       
    
}
