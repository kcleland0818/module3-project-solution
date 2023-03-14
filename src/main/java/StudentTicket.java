public class StudentTicket extends WalkupTicket {

    public StudentTicket(int ticketNumber) {
        super(ticketNumber);
    }

    @Override
    public double getPrice() {
        return super.getPrice() / 2;
    }
}
