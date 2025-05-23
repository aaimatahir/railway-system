class Train {
    private String trainName;
    private String destination;
    private String timing;
    private int availableSeats;

    public Train(String trainName, String destination, String timing, int availableSeats) {
        this.trainName = trainName;
        this.destination = destination;
        this.timing = timing;
        this.availableSeats = availableSeats;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getDestination() {
        return destination;
    }

    public String getTiming() {
        return timing;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
