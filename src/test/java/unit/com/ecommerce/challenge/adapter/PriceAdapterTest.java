package unit.com.ecommerce.challenge.adapter;

import com.ecommerce.challenge.adapter.PriceAdapter;
import com.ecommerce.challenge.dto.ProductPriceDto;
import com.ecommerce.challenge.exception.EcommerceException;
import com.ecommerce.challenge.model.Price;
import com.ecommerce.challenge.service.PriceService;
import com.ecommerce.challenge.translator.PriceTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceAdapterTest {
    @Mock
    private PriceService priceService;
    @Mock
    private PriceTranslator priceTranslator;
    @InjectMocks
    private PriceAdapter priceAdapter;

    private EcommerceException ecommerceException;
    private static final Long PRODUCT_CODE = 1L;
    private static final Long BRAND_GROUP_ID = 1L;

    @Test
    public void findProductPricesByFailByInvalidDate() {
        String invalidStartDate = "";

        ecommerceException
                = Assertions.assertThrows(EcommerceException.class, () -> priceAdapter.findProductPricesBy(invalidStartDate, PRODUCT_CODE, BRAND_GROUP_ID));

        Assertions.assertEquals("invalid query param", ecommerceException.getMessage());
    }

    @Test
    public void findProductPricesByOK() {
        String startDate = "2020-06-14T00:00:00";

        when(priceService.findProductPricesBy(LocalDateTime.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME), PRODUCT_CODE, BRAND_GROUP_ID))
        .thenReturn(List.of(Price.newBuilder().withPrice(new BigDecimal(25.5)).build()));
        when(priceTranslator.toDto(any())).thenReturn(ProductPriceDto.newProductPriceDtoBuilder().build());

        var response = priceAdapter.findProductPricesBy(startDate, PRODUCT_CODE, BRAND_GROUP_ID);

        Assertions.assertFalse(response.isEmpty());
    }
}
