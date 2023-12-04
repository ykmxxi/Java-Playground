package chap1.ticket;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(final TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(final Audience audience) {
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        if (audience.getBag().hasInvitation()) { // 당첨자인 경우
            audience.getBag().setTicket(ticket);
        }
        if (!audience.getBag().hasInvitation()) { // 당첨자가 아닌 경우
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }

}
