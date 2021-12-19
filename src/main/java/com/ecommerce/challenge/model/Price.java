package com.ecommerce.challenge.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceList;
    @ManyToOne(targetEntity = BrandGroup.class)
    @JoinColumn(name = "brand_id")
    private Long brandId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

}
