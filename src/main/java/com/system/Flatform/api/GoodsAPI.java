package com.system.Flatform.api;


import com.system.Flatform.goods.record.GoodsCreateDTO;
import com.system.Flatform.goods.dto.GoodsReplyCreateDTO;
import com.system.Flatform.goods.dto.GoodsReplyUpdateDTO;
import com.system.Flatform.goods.record.GoodsUpdateDTO;
import com.system.Flatform.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.system.Flatform.utils.Constants.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsAPI {

    final static Logger logger = LogManager.getLogger(GoodsAPI.class);
    private final GoodsService goodsService;

    /**
     * 공연 등록(저장) API
     * @param goodsCreateDTO
     * @return
     */
    @PostMapping
    public ResponseEntity createGoods(@RequestBody GoodsCreateDTO goodsCreateDTO) {
        goodsService.createGoods(goodsCreateDTO);
        logger.log(Level.ALL, ">>>> log test");
        log.fatal(">>> test fatal");
        log.error(">>> test error");
        log.warn(">>> test warn");
        log.info(">>> test info");
        log.debug(">>> test debug");
        log.trace(">>> test trace");
        return ResponseEntity.ok().body(CREATE_SUCCESS);
    }

    /**
     * 공연 수정 API
     * @param goodsUpdateDTO
     * @return
     */
    @PutMapping
    public ResponseEntity updateGoods(@RequestBody GoodsUpdateDTO goodsUpdateDTO) {
        goodsService.updateGoods(goodsUpdateDTO);
        return ResponseEntity.ok().body(UPDATE_SUCCESS);
    }

    /**
     * 공연 삭제 API
     * @param goodsIds
     * @return
     */
    @DeleteMapping("/{goodsIds}")
    public ResponseEntity deleteGoods(@PathVariable("goodsIds") List<Long> goodsIds) {
        goodsService.deleteGoods(goodsIds);
        return ResponseEntity.ok().body(DELETE_SUCCESS);
    }

    /**
     * 공연 목록 조회 API
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity goodsList(Pageable pageable,
                                    @RequestParam(required = false, defaultValue = "") String goodsName,
                                    @RequestParam(required = false, defaultValue = "") String address) {
        return ResponseEntity.ok().body(goodsService.goodsList(pageable, goodsName, address));
    }

    /**
     * 공연 상세 조회 API
     * @param goodsId
     * @return
     */
    @GetMapping("/{ticketId}")
    public ResponseEntity goodsDetail(@PathVariable("goodsId") Long goodsId) {
        return ResponseEntity.ok().body(goodsService.goodsDetail(goodsId));
    }

    /**
     * 공연 답글 등록 API
     * @param goodsReplyCreateDTO
     * @return
     */
    @PostMapping("/reply")
    public ResponseEntity createGoodsReply(@RequestBody GoodsReplyCreateDTO goodsReplyCreateDTO) {
        goodsService.createGoodsReply(goodsReplyCreateDTO);
        return ResponseEntity.ok().body(CREATE_REPLY_SUCCESS);
    }

    /**
     * 공연 답글 수정 API
     * @param goodsReplyUpdateDTO
     * @return
     */
    @PutMapping("/reply")
    public ResponseEntity updateGoodsReply(@RequestBody GoodsReplyUpdateDTO goodsReplyUpdateDTO) {
        goodsService.updateGoodsReply(goodsReplyUpdateDTO);
        return ResponseEntity.ok().body(UPDATE_SUCCESS);
    }

    /**
     * 공연 답글 삭제 API
     * @param goodsReplyIds
     * @return
     */
    @DeleteMapping("/reply/{goodsReplyIds}")
    public ResponseEntity deleteGoodsReply(@PathVariable("goodsReplyIds") List<Long> goodsReplyIds) {
        goodsService.deleteGoodsReply(goodsReplyIds);
        return ResponseEntity.ok().body(DELETE_SUCCESS);
    }
}
