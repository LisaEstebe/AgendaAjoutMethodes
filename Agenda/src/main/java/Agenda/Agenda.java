package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    private final List<Event> myEvents = new LinkedList<>();
    
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        this.myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) throws Exception {
        // TODO : implémenter cette méthode
        if(this.myEvents.isEmpty()){
            throw new Exception("Pas d'evenement dans cet Agenda");
        }
        
        List<Event> resultat = new LinkedList<>();
        
        for( Event e : this.myEvents) {
            if(e.isInDay(day)) resultat.add(e);
        }
        
        return resultat;
        
    }
    
     /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) throws Exception {
        // TODO : implémenter cette méthode
        if(this.myEvents.isEmpty()){
            throw new Exception("Pas d'evenement dans cet Agenda");
        }
        
        List<Event> resultat = new LinkedList<>();
        for (Event e : this.myEvents){
            if (e.getTitle() == title) resultat.add(e);
            else throw new Exception ("Aucun evenement trouve");
        }  
        return resultat;
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        // TODO : implémenter cette méthode
        boolean resultat = true;
       for (Event ev : this.myEvents){
           if (e.isInDay(ev.getStart().toLocalDate())){
               if (e.getStart().toLocalTime().isBefore(ev.getStart().toLocalTime()) || e.getStart().toLocalTime().equals(ev.getStart().toLocalTime())){
                   if(e.getStart().plus(e.getDuration()).toLocalTime().isAfter(ev.getStart().toLocalTime()) || e.getStart().plus(e.getDuration()).toLocalTime().equals(ev.getStart().toLocalTime())){
                       resultat = false;
                   }
               }
           } 
       }     
       return resultat;
    }
    
}
    
