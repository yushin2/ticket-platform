package com.system.Flatform.ticket.service.impl;

import com.system.Flatform.ticket.domain.Ticket;
import com.system.Flatform.ticket.dto.TicketCreateDTO;
import com.system.Flatform.ticket.dto.TicketUpdateDTO;
import com.system.Flatform.ticket.repository.TicketRepository;
import com.system.Flatform.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final String NO_TICKET_INFO_MSG = "해당하는 공연 정보가 없습니다.";
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

    /**
     * 티켓 수정
     * @param ticketUpdateDTO
     */
    @Transactional
    @Override
    public void updateTicket(TicketUpdateDTO ticketUpdateDTO) {
        Ticket ticket = ticketRepository.findById(ticketUpdateDTO.getTicketId()).orElseThrow(()
                -> new IllegalArgumentException(NO_TICKET_INFO_MSG));
        ticket.ticketUpdate(ticketUpdateDTO);
    }

    /**
     * 티켓 삭제
     * @param ticketIds
     */
    @Transactional
    @Override
    public void deleteTicket(List<Long> ticketIds) {
        ticketRepository.deleteTickets(ticketIds);
    }
}
