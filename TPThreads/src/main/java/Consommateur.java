
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
public class Consommateur extends Thread {

    List<String> produits;

    public Consommateur(List<String> produits) {
        this.produits = produits;
    }

    /* @Override
    public void run(){
      
        while (true) {
            
            synchronized (produits){
            if (produits.isEmpty()) break;
            int last = produits.size()-1;   
            System.out.println(getName() + " tente de lire le produit: "+last);
            String produit = produits.get(last);
            System.out.println(getName()+" a lu le produit: "+produit);
            produits.remove(last);
            System.out.println(getName()+" a enlevé le produit: "+produit);
            try{ sleep(500) ; } catch (InterruptedException e){ };
           }
       }
        System.out.println(getName()+" a fini");
    }
     */
    //Exercice recap
    //Un thread Consomateur doit tourner à l'infini
    @Override
    public void run() {
        while (true) {
            synchronized (produits) {

                if (!produits.isEmpty()) {

                    //retirer un produit de la liste quand celle-ci n'est pas vide
                    int last = produits.size() - 1;
                    String produit = produits.get(last);
                    produits.remove(produit);
                    System.out.println(getName() + " a enlevé le produit: " + produit);

                }
            }
            long a = Math.round(Math.random() * 5000);
            try {
                sleep(a);
            } catch (InterruptedException e) {
            };
        }
    }

}
