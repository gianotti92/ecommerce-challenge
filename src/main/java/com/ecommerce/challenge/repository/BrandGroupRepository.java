package com.ecommerce.challenge.repository;

import com.ecommerce.challenge.model.BrandGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandGroupRepository extends JpaRepository<BrandGroup, Long> {
}
