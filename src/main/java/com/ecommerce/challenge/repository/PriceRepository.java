package com.ecommerce.challenge.repository;

import com.ecommerce.challenge.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("select p from Price p where (p.startDate = :startDate or :startDate is null)" +
            "and (p.productId = :productCode or :productCode is null)" +
            "and (p.brandGroup.id = :brandGroupId or :brandGroupId is null)"
    )
    List<Price> findProductPricesBy(@Param("startDate") LocalDateTime startDate,
                                    @Param("productCode") Long productCode,
                                    @Param("brandGroupId") Long brandGroupId);



    List<Price> findPricesByStartDateOrProductIdOrBrandGroup(LocalDateTime startDate, Long productCode, Long brandGroupId);
}
