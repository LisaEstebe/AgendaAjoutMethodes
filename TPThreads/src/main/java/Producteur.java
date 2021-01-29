
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
        produits.add("Nouveau Produit");
        
        }
    }
}
