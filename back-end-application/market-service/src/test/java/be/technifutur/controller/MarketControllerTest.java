package be.technifutur.controller;

import be.technifutur.MarketApplication;
import be.technifutur.business.mapper.MarketMapper;
import be.technifutur.business.service.MarketService;
import be.technifutur.config.BeanConfig;
import be.technifutur.config.WebSecurityConfig;
import be.technifutur.model.entity.Market;
import be.technifutur.model.form.MarketForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
@ContextConfiguration(classes = {BeanConfig.class, WebSecurityConfig.class, MarketApplication.class})
@WebMvcTest(controllers = MarketController.class)
class MarketControllerTest {

    private final UUID UUID_TEST = UUID.fromString("c510c434-58dc-4163-b802-828f0698cab0");
    @Autowired
    private MockMvc mockMvc;
    private MarketMapper mapper;
    @MockBean
    private MarketService service;
    Market market;
    MarketForm form;

    @BeforeEach
    void setUp() {
        mapper = new MarketMapper();
        market = Market.builder()
                .id(0L)
                .gameRef(UUID_TEST)
                .price(100)
                .stock(50)
                .build();
        form = new MarketForm(
                UUID_TEST,
                105.5,
                999
        );
    }

    @Test
    public void get_one_market_dto() throws Exception {

        //when
        when(service.getOneByGameRef(any())).thenReturn(mapper.entityToDTO(market));

        //then
        this.mockMvc.perform(get("/market/{ref}", UUID_TEST))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.price").value(100)
                );


    }

    @Test
    public void add_one_market() throws Exception{
        this.mockMvc.perform(post("/market/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(market)))
                .andDo(print())
                .andExpect(
                        status().isCreated()
                );
    }
    @Test
    public void delete_one_market() throws Exception {
        this.mockMvc.perform(delete("/market/{ref}", UUID_TEST))
                .andDo(print())
                .andExpect(
                        status().isOk()
                );
    }

    @Test
    public void patch_stock_only() throws Exception {
        market.setStock(1002);
        when(service.updateStockOnly(any(), anyInt())).thenReturn(mapper.entityToDTO(market));
        this.mockMvc.perform(patch("/market/update/{ref}", UUID_TEST)
                        .param("stock", String.valueOf(1002)))
                .andDo(print())
                .andExpectAll(
                        status().is2xxSuccessful(),
                        jsonPath("$.stock").value(1002)
                );
    }

    @Test
    public void patch_price_only() throws Exception {
        market.setPrice(1002);
        when(service.updatePriceOnly(any(), anyDouble())).thenReturn(mapper.entityToDTO(market));
        this.mockMvc.perform(patch("/market/update/price/{ref}", UUID_TEST)
                        .param("price", String.valueOf(1002)))
                .andDo(print())
                .andExpectAll(
                        status().is2xxSuccessful(),
                        jsonPath("$.price").value(1002)
                );
    }

    @Test
    public void put_price_and_stock_update() throws Exception {

        market.setPrice(form.getPrice());
        market.setStock(form.getStock());
        //when
        when(service.updateAll(any(), any())).thenReturn(mapper.entityToDTO(market));

        //then
        this.mockMvc.perform(put("/market/update/{ref}", UUID_TEST)
                        .content(asJsonString(form))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpectAll(
                        status().is2xxSuccessful(),
                        jsonPath("$.price").value(105.5),
                        jsonPath("$.stock").value(999)
                );
    }
    private static <T> String asJsonString(T content){
        try{
            return new ObjectMapper().writeValueAsString(content);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }



}