package com.ecommerce.challenge.service;

import com.ecommerce.challenge.model.Price;
import com.ecommerce.challenge.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> findProductPricesBy(LocalDateTime startDate, Long productCode, Long brandGroupId){
        return priceRepository.findProductPricesBy(startDate, productCode, brandGroupId);
    }
}
