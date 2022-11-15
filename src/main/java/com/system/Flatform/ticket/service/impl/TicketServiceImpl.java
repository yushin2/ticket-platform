package com.system.Flatform.ticket.service.impl;

import com.system.Flatform.ticket.dto.TicketCreateDTO;
import com.system.Flatform.ticket.repository.TicketRepository;
import com.system.Flatform.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;


    /**
     * 티켓 등록(저장)
     * @param ticketCreateDTO
     */
    @Transactional
    @Override
    public void createTicket(TicketCreateDTO ticketCreateDTO) {
        ticketRepository.save(ticketCreateDTO.toEntity());
    }
}
