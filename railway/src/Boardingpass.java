public class Boardingpass {
    private Ticket ticket;
    public Boardingpass(Ticket ticket) {
        this.ticket = ticket;
    }
    public void printbordingpass(){
        Passenger pasenger=ticket.getPassenger();
        Train train = ticket.getTrain();
        System.out.println("Boarding Pass");
        System.out.println("--------------");
        System.out.println("Train: " + ticket.getTrain().getTrainName());
        System.out.println("Destination: " + ticket.getTrain().getDestination());
        System.out.println("Seat Number: " + ticket.getSeatNumber());
        System.out.println("Passenger: " + ticket.getPassenger().getName());
        System.out.println("--------------");
    }
    
}
