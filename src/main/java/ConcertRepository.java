public class ConcertRepository {

    private Concert[] concerts;
    private int currentSize ;

    public ConcertRepository(int maxSize) {
        concerts = new Concert[maxSize];
    }

    public int getCurrentSize() { return currentSize;}

    // Return null if out of bounds (versus throwing exception)
    public Concert get(int index) {
        if (index >= 0 && index <currentSize) {
            return concerts[index];
        }
        else {
            return null;
        }
    }

    public boolean add(Concert concert) {
        if (currentSize < concerts.length) {
            concerts[currentSize] = concert;
            currentSize++;
            return true;
        }
        else {
            return false;
        }
    }

    public Concert findByPerformer(String performer) {
        String lowerCaseName = performer.toLowerCase();
        for (int i=0; i<currentSize; i++) {
            if (concerts[i].getPerformer().toLowerCase().equals(lowerCaseName)) {
                return concerts[i];
            }
        }
        return null;
    }
}

