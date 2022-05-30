package be.technifutur.controller;

import be.technifutur.business.mapper.MarketMapper;
import be.technifutur.business.service.MarketService;
import be.technifutur.model.entity.Market;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
@WebMvcTest(controllers = MarketController.class)
class MarketControllerTest {

    private final UUID UUID_TEST = UUID.fromString("c510c434-58dc-4163-b802-828f0698cab0");
    @Autowired
    private MockMvc mockMvc;
    private MarketMapper mapper;
    @MockBean
    private MarketService service;
    Market market;

    @BeforeEach
    void setUp() {
        mapper = new MarketMapper();
        market = Market.builder()
                .id(0L)
                .gameRef(UUID_TEST)
                .price(100)
                .stock(50)
                .build();
    }

    @Test
    public void get_one_market_dto() throws Exception {

        //when
        when(service.getOneByGameRef(UUID_TEST)).thenReturn(mapper.entityToDTO(market));

        //then
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/market/{ref}", UUID_TEST))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.price").value(100)
                );


    }

    @Test
    public void add_one_market() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/market/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(market)))
                .andDo(print())
                .andExpect(
                        status().isCreated()
                );





    }

    private static String asJsonString(Market content){
        try{
            return new ObjectMapper().writeValueAsString(content);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}