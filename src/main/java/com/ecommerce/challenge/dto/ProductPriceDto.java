package com.ecommerce.challenge.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductPriceDto {
    private Long productCode;
    private Long brandGroupCode;
    private Integer rate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal finalPrice;

    public Long getProductCode() {
        return productCode;
    }

    public Long getBrandGroupCode() {
        return brandGroupCode;
    }

    public Integer getRate() {
        return rate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public static ProductPriceDtoBuilder newProductPriceDtoBuilder() {
        return new ProductPriceDtoBuilder();
    }


    public static final class ProductPriceDtoBuilder {
        private Long productCode;
        private Long brandGroupCode;
        private Integer rate;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private BigDecimal finalPrice;

        private ProductPriceDtoBuilder() {
        }

        public ProductPriceDtoBuilder withProductCode(Long productCode) {
            this.productCode = productCode;
            return this;
        }

        public ProductPriceDtoBuilder withBrandGroupCode(Long brandGroupCode) {
            this.brandGroupCode = brandGroupCode;
            return this;
        }

        public ProductPriceDtoBuilder withRate(Integer rate) {
            this.rate = rate;
            return this;
        }

        public ProductPriceDtoBuilder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public ProductPriceDtoBuilder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public ProductPriceDtoBuilder withFinalPrice(BigDecimal finalPrice) {
            this.finalPrice = finalPrice;
            return this;
        }

        public ProductPriceDto build() {
            ProductPriceDto productPriceDto = new ProductPriceDto();
            productPriceDto.endDate = this.endDate;
            productPriceDto.brandGroupCode = this.brandGroupCode;
            productPriceDto.startDate = this.startDate;
            productPriceDto.productCode = this.productCode;
            productPriceDto.finalPrice = this.finalPrice;
            productPriceDto.rate = this.rate;
            return productPriceDto;
        }
    }
}
