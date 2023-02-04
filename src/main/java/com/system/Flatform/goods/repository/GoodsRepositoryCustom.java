package com.system.Flatform.goods.repository;

import com.system.Flatform.goods.dto.GoodsDetailDTO;
import com.system.Flatform.goods.dto.GoodsListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsRepositoryCustom {

    void deleteTickets(List<Long> ticketIds);

    Page<GoodsListDTO> ticketList(Pageable pageable, String ticketName, String address);

    GoodsDetailDTO ticketDetail(Long ticketId);

}
