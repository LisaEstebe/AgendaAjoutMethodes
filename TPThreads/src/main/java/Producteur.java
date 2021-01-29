
import static java.lang.Math.random;
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
public class Producteur extends Thread {
    List<String> produits;
    
    public Producteur(List<String> produits) {
        this.produits = produits;
    }
        
   
    
    @Override
    public void run(){
    
    int limite = 10;
    //ajouter un produit si le tableau n'est pas plein
    while (produits.size()<limite){
        int nouveauProduit = produits.size();
        produits.add("numéro "+nouveauProduit);
        System.out.println(getName()+" a ajouté le produit: "+nouveauProduit);
        
        long a = Math.round(Math.random()*5000);
   
        try{ sleep(a) ; } catch (InterruptedException e){ };
        }
    
    }
}
