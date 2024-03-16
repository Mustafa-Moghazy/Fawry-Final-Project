package com.example.coupon.rest;

import com.example.coupon.dto.ConsumptionHistoryDTO;
import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.service.ConsumptionHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coupons")
public class ConsumptionHistoryController {
    @Autowired
    ConsumptionHistoryServiceImpl chService;
    @PostMapping("consume")
    public boolean consume(@RequestBody ConsumptionHistoryDTO chDTO){
        return chService.consume(chDTO);
    }
    @GetMapping("history")
    public List<ConsumptionHistory> findAll(){
        return chService.findAll();
    }
}
