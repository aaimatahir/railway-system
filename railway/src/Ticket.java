class Ticket {
    private Train train;
    private Passenger passenger;
    private int seatNumber;

    public Ticket(Train train, Passenger passenger, int seatNumber) {
        this.train = train;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
