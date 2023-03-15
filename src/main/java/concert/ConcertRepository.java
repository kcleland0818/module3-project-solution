package concert;

import java.util.ArrayList;
import java.util.List;

public class ConcertRepository {

    private final List<Concert> concerts;

    public ConcertRepository() {
        concerts = new ArrayList<>();
    }

    /**
     * Get a concert by the index in the list
     * @param index : int - index of the concert.Concert of interest
     * @return concert.Concert - concert.Concert object at the given index
     *                   Return null if out of bounds (versus throwing an exception)
     */
    public Concert get(int index) {
        if (index >= 0 && index < concerts.size()) {
            return concerts.get(index);
        }
        else {
            // Return null if out of bounds (versus throwing exception)
            return null;
        }
    }

    /**
     * Find all the concerts in the list
     * @return List<concert.Concert> - list of the current concerts
     */
    public List<Concert> getAllConcerts() {
        return concerts;
    }

    /**
     * Add a concert to the list
     * @param concert : concert.Concert - concert to be added to the list
     * @return boolean - whether the concert could be added or not
     */
    public boolean add(Concert concert) {
        return concerts.add(concert);
    }

    /**
     * Find a concert.Concert based on the performer
     * @param performer : String - performer name to search on
     * @return concert.Concert - concert object with the given performer
     *                   Return null if there is no concert with the given performer
     */
    public Concert findByPerformer(String performer) {
        String lowerCaseName = performer.toLowerCase();

        for (Concert concert : concerts) {
            if (concert.getPerformer().toLowerCase().equals(lowerCaseName)) {
                return concert;
            }
        }

        return null;
    }
}

