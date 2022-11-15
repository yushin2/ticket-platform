package com.system.Flatform.API;


import com.system.Flatform.ticket.dto.TicketCreateDTO;
import com.system.Flatform.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketAPI {

    private final String CREATE_SUCCESS = "티켓 등록 성공!";

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity createTicket(@RequestBody TicketCreateDTO ticketCreateDTO) {
        ticketService.createTicket(ticketCreateDTO);
        return ResponseEntity.ok().body(CREATE_SUCCESS);
    }



}
