package com.ecommerce.challenge.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price_list")
    private Integer priceList;
    @ManyToOne(targetEntity = BrandGroup.class)
    @JoinColumn(name = "brand_id")
    private BrandGroup brandGroup;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    public Price() {
    }

    public Long getId() {
        return id;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public BrandGroup getBrandGroup() {
        return brandGroup;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static PriceBuilder newBuilder() {
        return new PriceBuilder();
    }

    public static final class PriceBuilder {
        private Long id;
        private Integer priceList;
        private BrandGroup brandGroup;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Long productId;
        private Integer priority;
        private BigDecimal price;
        private Currency currency;

        private PriceBuilder() {
        }

        public PriceBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PriceBuilder withPriceList(Integer priceList) {
            this.priceList = priceList;
            return this;
        }

        public PriceBuilder withBrandGroup(BrandGroup brandGroup) {
            this.brandGroup = brandGroup;
            return this;
        }

        public PriceBuilder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public PriceBuilder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public PriceBuilder withProductId(Long productId) {
            this.productId = productId;
            return this;
        }

        public PriceBuilder withPriority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public PriceBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PriceBuilder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Price build() {
            Price price = new Price();
            price.endDate = this.endDate;
            price.startDate = this.startDate;
            price.price = this.price;
            price.id = this.id;
            price.currency = this.currency;
            price.productId = this.productId;
            price.priceList = this.priceList;
            price.brandGroup = this.brandGroup;
            price.priority = this.priority;
            return price;
        }
    }
}
