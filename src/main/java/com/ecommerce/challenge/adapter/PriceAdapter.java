package com.ecommerce.challenge.adapter;

import com.ecommerce.challenge.dto.ProductPriceDto;
import com.ecommerce.challenge.exception.EcommerceError;
import com.ecommerce.challenge.exception.EcommerceException;
import com.ecommerce.challenge.service.PriceService;
import com.ecommerce.challenge.translator.PriceTranslator;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public List<ProductPriceDto> findProductPricesBy(String startDate, Long productCode, Long brandGroupId) {
        LocalDateTime startLocalDateTime = null;

        if(Strings.EMPTY.equals(startDate)) {
            throw new EcommerceException("invalid query param", EcommerceError.GENERIC_ERROR);
        }

        if(Strings.isNotBlank(startDate)) {
            startLocalDateTime = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }


        return priceService.findProductPricesBy(startLocalDateTime, productCode, brandGroupId).stream()
                .map(priceTranslator::toDto)
                .collect(Collectors.toList());
    }
}
