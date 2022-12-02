package com.system.Flatform.ticket.repository;

import com.system.Flatform.ticket.dto.TicketDetailDTO;
import com.system.Flatform.ticket.dto.TicketListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketRepositoryCustom {

    void deleteTickets(List<Long> ticketIds);

    Page<TicketListDTO> ticketList(Pageable pageable, String ticketName, String address);

    TicketDetailDTO ticketDetail(Long ticketId);

}
