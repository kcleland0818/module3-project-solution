public class ConcertRepository {
    private Concert[] concertList;

    public ConcertRepository() {
        concertList = new Concert[] {
            new Concert("Taylor Swift", 5, 10000),
            new Concert("The Weeknd", 2, 5000),
            new Concert("Harry Styles", 100, 1000)
        };
    }

    public Concert[] findAll() {
        return concertList;
    }

    public Concert findByArtist(String artist) {
        artist = artist.toLowerCase();
        for (Concert concert : concertList) {
            if (concert.getArtist().toLowerCase().equals(artist)) {
                return concert;
            }
        }
        return null;
    }
}

