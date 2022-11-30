package com.system.Flatform.API;


import com.system.Flatform.ticket.dto.TicketCreateDTO;
import com.system.Flatform.ticket.dto.TicketUpdateDTO;
import com.system.Flatform.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketAPI {

    private final String CREATE_SUCCESS = "티켓 등록 성공!";
    private final String UPDATE_SUCCESS = "티켓 수정 성공!";
    private final String DELETE_SUCCESS = "티켓 삭제 성공!";

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




}
