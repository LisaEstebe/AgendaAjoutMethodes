package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    
    public ChronoUnit frequency;
    List<LocalDate> lesExceptions = new ArrayList<>();
    
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        lesExceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }
    
    @Override
    public boolean isInDay(LocalDate aDay){
        LocalDateTime myStart = this.getStart();
        Duration myDuration = this.getDuration();
        LocalDateTime myEnd = myStart.plus(myDuration);
        boolean r = false;
        
        if (!lesExceptions.stream().noneMatch(d -> (d.isEqual(aDay)))) {
            return false;
        }
        if (myStart.toLocalDate().isEqual(aDay)){
            return true;
        }
        while (myStart.toLocalDate().isBefore(aDay)){
            myEnd = myStart.plus(myDuration);
            if (myStart.toLocalDate().isBefore(aDay) || myStart.toLocalDate().isEqual(aDay)){
                if (myEnd.toLocalDate().isAfter(aDay) || myEnd.toLocalDate().isEqual(aDay)){
                    return true;
                }
                else {
                    r = false;
                }
            }
            else {
                r = false;
            }
        myStart = myStart.plus(1, frequency);
        }
        return r;
    }
    
}
