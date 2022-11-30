package com.system.Flatform.ticket.repository;

import java.util.List;

public interface TicketRepositoryCustom {

    void deleteTickets(List<Long> ticketIds);
}
