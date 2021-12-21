package com.ecommerce.challenge;

import com.ecommerce.challenge.model.BrandGroup;
import com.ecommerce.challenge.model.Currency;
import com.ecommerce.challenge.model.Price;
import com.ecommerce.challenge.repository.BrandGroupRepository;
import com.ecommerce.challenge.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@AutoConfigureMockMvc
class ChallengeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private BrandGroupRepository brandGroupRepository;


    @BeforeEach
    public void init() {
        var zaraBrandGroup = brandGroupRepository.save(createZARABranGroup());
        var firstPrice = createPrice(1L,1, zaraBrandGroup,
                LocalDateTime.parse("2020-06-14T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                LocalDateTime.parse("2020-12-31T23:59:59", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                35455L,
                0,
                new BigDecimal(35.50),
                Currency.EUR

        );
        var sndPrice = createPrice(2L,2, zaraBrandGroup,
                LocalDateTime.parse("2020-06-14T15:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                LocalDateTime.parse("2020-06-14T18:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                35455L,
                1,
                new BigDecimal(25.45),
                Currency.EUR

        );
        var thrdPrice = createPrice(3L,3, zaraBrandGroup,
                LocalDateTime.parse("2020-06-15T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                LocalDateTime.parse("2020-06-15T11:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                35455L,
                1,
                new BigDecimal(30.50),
                Currency.EUR

        );
        var fourthPrice = createPrice(4L,4, zaraBrandGroup,
                LocalDateTime.parse("2020-06-15T16:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                LocalDateTime.parse("2020-12-31T23:59:59", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                35455L,
                1,
                new BigDecimal(38.95),
                Currency.EUR

        );

        priceRepository.save(firstPrice);
        priceRepository.save(sndPrice);
        priceRepository.save(thrdPrice);
        priceRepository.save(fourthPrice);

    }

    @Test
    void test1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product?startDate=2020-06-14T10:00:00&productCode=35455&brandGroupId=1"))
                .andExpect(result -> result.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void test2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product?startDate=2020-06-14T16:00:00&productCode=35455&brandGroupId=1"))
                .andExpect(result -> result.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void test3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product?startDate=2020-06-14T21:00:00&productCode=35455&brandGroupId=1"))
                .andExpect(result -> result.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void test4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product?startDate=2020-06-15T10:00:00&productCode=35455&brandGroupId=1"))
                .andExpect(result -> result.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void test5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product?startDate=2020-06-16T21:00:00&productCode=35455&brandGroupId=1"))
                .andExpect(result -> result.getResponse().getContentAsString().equals("[]"));
    }

    private BrandGroup createZARABranGroup() {
        return BrandGroup.newBuilder()
                .withId(1L)
                .withName("ZARA")
                .build();
    }

    private Price createPrice(Long id, Integer priceList, BrandGroup brandGroup, LocalDateTime startDate,
                              LocalDateTime endDate, Long productId, Integer priority, BigDecimal price, Currency currency) {
        return Price.newBuilder()
                .withId(id)
                .withPriceList(priceList)
                .withBrandGroup(brandGroup)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withProductId(productId)
                .withPriority(priority)
                .withPrice(price)
                .withCurrency(currency)
                .build();
    }

}
