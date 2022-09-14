package pt.theloop.inditexchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pt.theloop.inditexchallenge.controller.request.GetPriceRequest;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Currency;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc()
@SpringBootTest
public class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test1() throws Exception {
        GetPriceRequest getPriceRequest = new GetPriceRequest(
                1L,
                35455L,
                LocalDateTime.of(2020, 06, 14, 10, 00));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("EUR"));

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/price")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(this.objectMapper.writeValueAsString(getPriceRequest))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1L))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.price").value(formatter.format(35.50)))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"));
    }

    @Test
    public void test2() throws Exception {
        GetPriceRequest getPriceRequest = new GetPriceRequest(
                1L,
                35455L,
                LocalDateTime.of(2020, 06, 14, 16, 00));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("EUR"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/price")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(this.objectMapper.writeValueAsString(getPriceRequest))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1L))
                .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
                .andExpect(jsonPath("$.price").value(formatter.format(25.45)))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"));
    }

    @Test
    public void test3() throws Exception {
        GetPriceRequest getPriceRequest = new GetPriceRequest(
                1L,
                35455L,
                LocalDateTime.of(2020, 06, 14, 21, 00));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("EUR"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/price")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(this.objectMapper.writeValueAsString(getPriceRequest))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1L))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.price").value(formatter.format(35.50)))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"));
    }

    @Test
    public void test4() throws Exception {
        GetPriceRequest getPriceRequest = new GetPriceRequest(
                1L,
                35455L,
                LocalDateTime.of(2020, 06, 15, 10, 00));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("EUR"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/price")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(this.objectMapper.writeValueAsString(getPriceRequest))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1L))
                .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$.price").value(formatter.format(30.50)))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"));
    }

    @Test
    public void test5() throws Exception {
        GetPriceRequest getPriceRequest = new GetPriceRequest(
                1L,
                35455L,
                LocalDateTime.of(2020, 06, 16, 21, 00));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("EUR"));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/price")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(this.objectMapper.writeValueAsString(getPriceRequest))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1L))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.price").value(formatter.format(38.95)))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"));
    }

}
