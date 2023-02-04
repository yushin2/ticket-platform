package com.system.Flatform.goods.service;

import com.system.Flatform.goods.dto.*;
import com.system.Flatform.goods.record.GoodsCreateDTO;
import com.system.Flatform.goods.record.GoodsUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {

    /** 이하 공연 API */
    void createGoods(GoodsCreateDTO goodsCreateDTO);

    void updateGoods(GoodsUpdateDTO goodsUpdateDTO);

    void deleteGoods(List<Long> ticketIds);

    Page<GoodsListDTO> goodsList(Pageable pageable, String ticketName, String address);

    GoodsDetailDTO goodsDetail(Long ticketId);

    /** 이하 공연 답글 API */
    void createGoodsReply(GoodsReplyCreateDTO goodsReplyCreateDTO);

    void updateGoodsReply(GoodsReplyUpdateDTO goodsReplyUpdateDTO);

    void deleteGoodsReply(List<Long> ticketReplyIds);

}
