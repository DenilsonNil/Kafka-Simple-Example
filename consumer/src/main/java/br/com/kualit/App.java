package br.com.kualit;

import br.com.kualit.service.TicketProcessment;

public class App {
    public static void main(String[] args) throws InterruptedException {
        TicketProcessment processor = new TicketProcessment();
        processor.processTickets();
    }
}
