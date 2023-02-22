public class ConcertRepository {
    private Concert[] concerts;
    private int currentSize ;

    public ConcertRepository(int maxSize) {
        concerts = new Concert[maxSize];
    }

    public int getCurrentSize() { return currentSize;}

    public Concert get(int i) {
        if (i >= 0 && i <currentSize) {
            return concerts[i];
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

    public Concert findByArtist(String artist) {
        String lowerCaseArtist = artist.toLowerCase();
        for (int i=0; i<currentSize; i++) {
            if (concerts[i].getArtist().toLowerCase().equals(lowerCaseArtist)) {
                return concerts[i];
            }
        }
        return null;
    }
}

