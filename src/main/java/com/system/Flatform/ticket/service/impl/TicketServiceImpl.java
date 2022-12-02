package com.system.Flatform.ticket.service.impl;

import com.system.Flatform.ticket.domain.Ticket;
import com.system.Flatform.ticket.domain.TicketReply;
import com.system.Flatform.ticket.dto.*;
import com.system.Flatform.ticket.repository.TicketReplyRepository;
import com.system.Flatform.ticket.repository.TicketRepository;
import com.system.Flatform.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.system.Flatform.utils.Constants.*;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketReplyRepository ticketReplyRepository;


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

    /**
     * 티켓 목록 조회
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<TicketListDTO> ticketList(Pageable pageable, String ticketName, String address) {
        return ticketRepository.ticketList(pageable, ticketName, address);
    }

    /**
     * 티켓 상세 조회
     * @param ticketId
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public TicketDetailDTO ticketDetail(Long ticketId) {
        return ticketRepository.ticketDetail(ticketId);
    }

    /**
     * 티켓 답글 등록(저장)
     * @param ticketReplyCreateDTO
     */
    @Transactional
    @Override
    public void createTicketReply(TicketReplyCreateDTO ticketReplyCreateDTO) {
        Ticket ticket = ticketRepository.findById(ticketReplyCreateDTO.getTicketId()).orElseThrow(()
                -> new IllegalArgumentException(NO_TICKET_INFO_MSG));
        TicketReply savedTicketReply = ticketReplyRepository.save(ticketReplyCreateDTO.toEntity(ticket));
        savedTicketReply.setReplyParentId((ticket.getTicketReplyList().size() == 0) ?
                savedTicketReply.getTicketReplyId() :
                ticket.getTicketReplyList().get(ticket.getTicketReplyList().size()-1).getTicketReplyId());
    }

    /**
     * 티켓 답글 수정
     * @param ticketReplyUpdateDTO
     */
    @Transactional
    @Override
    public void updateTicketReply(TicketReplyUpdateDTO ticketReplyUpdateDTO) {
        TicketReply ticketReply = ticketReplyRepository.findById(ticketReplyUpdateDTO.getTicketReplyId()).orElseThrow(()
                -> new IllegalArgumentException(NO_TICKET_REPLY_MSG));
        ticketReply.updateReplyContent(ticketReplyUpdateDTO);
    }

    /**
     * 티켓 답글 삭제
     * @param ticketReplyIds
     */
    @Transactional
    @Override
    public void deleteTicketReply(List<Long> ticketReplyIds) {
        ticketReplyRepository.deleteTicketReply(ticketReplyIds);
    }

}
