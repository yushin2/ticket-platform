package com.system.Flatform.ticket.service;

import com.system.Flatform.ticket.dto.TicketCreateDTO;
import com.system.Flatform.ticket.dto.TicketUpdateDTO;

import java.util.List;

public interface TicketService {

    void createTicket(TicketCreateDTO ticketCreateDTO);

    void updateTicket(TicketUpdateDTO ticketUpdateDTO);

    void deleteTicket(List<Long> ticketIds);
}
