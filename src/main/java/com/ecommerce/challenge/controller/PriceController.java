package com.ecommerce.challenge.controller;

import com.ecommerce.challenge.adapter.PriceAdapter;
import com.ecommerce.challenge.dto.ProductPriceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
public class PriceController {

    private final PriceAdapter priceAdapter;

    public PriceController(PriceAdapter priceAdapter) {
        this.priceAdapter = priceAdapter;
    }

    @GetMapping
    public List<ProductPriceDto> findProductPricesBy(@RequestParam(required = false) LocalDateTime startDate
            ,@RequestParam(required = false) Long productCode
            ,@RequestParam(required = false) Long brandGroupId) {

        return priceAdapter.findProductPricesBy(startDate, productCode, brandGroupId);
    }
}
