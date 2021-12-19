package com.ecommerce.challenge.translator;

import com.ecommerce.challenge.dto.ProductPriceDto;
import com.ecommerce.challenge.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceTranslator {

    public ProductPriceDto toDto(Price price) {
        return ProductPriceDto.newProductPriceDtoBuilder()
                .withProductCode(price.getProductId())
                .withBrandGroupCode(price.getBrandId())
                .withRate(price.getPriceList())
                .withStartDate(price.getStartDate())
                .withEndDate(price.getEndDate())
                .withFinalPrice(price.getPrice())
                .build();
    }
}
