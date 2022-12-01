package com.system.Flatform.ticket.service;

import com.system.Flatform.ticket.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {

    void createTicket(TicketCreateDTO ticketCreateDTO);

    void updateTicket(TicketUpdateDTO ticketUpdateDTO);

    void deleteTicket(List<Long> ticketIds);

    Page<TicketListDTO> ticketList(Pageable pageable);

    TicketDetailDTO ticketDetail(Long ticketId);

    void createTicketReply(TicketReplyCreateDTO ticketReplyCreateDTO);


}
