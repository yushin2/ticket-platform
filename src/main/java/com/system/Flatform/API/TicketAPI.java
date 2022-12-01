package com.system.Flatform.API;


import com.system.Flatform.ticket.dto.TicketCreateDTO;
import com.system.Flatform.ticket.dto.TicketReplyCreateDTO;
import com.system.Flatform.ticket.dto.TicketUpdateDTO;
import com.system.Flatform.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketAPI {

    private final String CREATE_SUCCESS = "등록 성공!";
    private final String UPDATE_SUCCESS = "수정 성공!";
    private final String DELETE_SUCCESS = "삭제 성공!";
    private final String CREATE_REPLY_SUCCESS = "답글 등록 성공!";


    private final TicketService ticketService;

    /**
     * 티켓 등록(저장) API
     * @param ticketCreateDTO
     * @return
     */
    @PostMapping
    public ResponseEntity createTicket(@RequestBody TicketCreateDTO ticketCreateDTO) {
        ticketService.createTicket(ticketCreateDTO);
        return ResponseEntity.ok().body(CREATE_SUCCESS);
    }

    /**
     * 티켓 수정 API
     * @param ticketUpdateDTO
     * @return
     */
    @PutMapping
    public ResponseEntity updateTicket(@RequestBody TicketUpdateDTO ticketUpdateDTO) {
        ticketService.updateTicket(ticketUpdateDTO);
        return ResponseEntity.ok().body(UPDATE_SUCCESS);
    }

    /**
     * 티켓 삭제 API
     * @param ticketIds
     * @return
     */
    @DeleteMapping("/{ticketIds}")
    public ResponseEntity deleteTickets(@PathVariable("ticketIds") List<Long> ticketIds) {
        ticketService.deleteTicket(ticketIds);
        return ResponseEntity.ok().body(DELETE_SUCCESS);
    }

    /**
     * 티켓 목록 조회 API
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity ticketList(Pageable pageable) {
        return ResponseEntity.ok().body(ticketService.ticketList(pageable));
    }

    /**
     * 티켓 상세 조회 API
     * @param ticketId
     * @return
     */
    @GetMapping("/{ticketId}")
    public ResponseEntity ticketDetail(@PathVariable("ticketId") Long ticketId) {
        return ResponseEntity.ok().body(ticketService.ticketDetail(ticketId));
    }

    @PostMapping("/reply")
    public ResponseEntity createTicketReply(@RequestBody TicketReplyCreateDTO ticketReplyCreateDTO) {
        ticketService.createTicketReply(ticketReplyCreateDTO);
        return ResponseEntity.ok().body(CREATE_REPLY_SUCCESS);
    }


}
