package com.ecommerce.challenge.adapter;

import com.ecommerce.challenge.dto.ProductPriceDto;
import com.ecommerce.challenge.service.PriceService;
import com.ecommerce.challenge.translator.PriceTranslator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceAdapter {
    private final PriceService priceService;
    private final PriceTranslator priceTranslator;

    public PriceAdapter(PriceService priceService, PriceTranslator priceTranslator) {
        this.priceService = priceService;
        this.priceTranslator = priceTranslator;
    }

    public List<ProductPriceDto> findProductPricesBy(LocalDateTime startDate, Long productCode, Long brandGroupId) {
        return priceService.findProductPricesBy(startDate, productCode, brandGroupId).stream()
                .map(priceTranslator::toDto)
                .collect(Collectors.toList());
    }
}
