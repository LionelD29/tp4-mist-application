package be.technifutur.business.service;

import be.technifutur.business.mapper.MarketMapper;
import be.technifutur.model.dto.MarketDto;
import be.technifutur.model.entity.Market;
import be.technifutur.model.form.MarketForm;
import be.technifutur.repo.MarketRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@IndicativeSentencesGeneration(separator = "  ->  ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class MarketServiceTest {

    @Mock
    private MarketRepo mockRepo;
    private MarketService underTest;
    private MarketMapper mapper;
    private final UUID UUID_TEST = UUID.fromString("c510c434-58dc-4163-b802-828f0698cab0");
    private Market market;

    @BeforeEach
    void setUp() {
        mapper = new MarketMapper();
        underTest = new MarketService(mockRepo, mapper);
        market = Market.builder()
                .id(0L)
                .gameRef(UUID_TEST)
                .price(100)
                .stock(50)
                .download(100)
                .build();

    }

    @Test
    void can_add_market() {
        //given
        MarketForm marketForm = new MarketForm(UUID.randomUUID(),103.34, 20,0, 100);

        //when
        MarketDto addedMarket = underTest.addMarket(marketForm);

        //then
        ArgumentCaptor<Market> argumentCaptor = ArgumentCaptor.forClass(Market.class);
        verify(mockRepo).save(argumentCaptor.capture());
        MarketDto capturedMarket = mapper.entityToDTO(argumentCaptor.getValue());
        assertThat(capturedMarket.getGameRef()).isEqualTo(addedMarket.getGameRef());
    }

    @Test
    void can_get_one_by_gameRef() {

        Optional<Market> opt = Optional.of(market);

        //given
        doReturn(opt).when(mockRepo).findByGameRef(UUID_TEST);

        //when
        underTest.getOneByGameRef(UUID_TEST);

        //then
        verify(mockRepo).findByGameRef(any());
    }

    @Test
    void can_get_all() {
        //when
        underTest.getAll();
        //then
        verify(mockRepo).findAll();
    }

    @Test
    void can_update_Price() {

        //given
        Optional<Market> opt = Optional.of(market);
        doReturn(opt).when(mockRepo).findByGameRef(UUID_TEST);

        //when
        underTest.updatePriceOnly(UUID_TEST, 200);

        //then
        ArgumentCaptor<Market> captor = ArgumentCaptor.forClass(Market.class);
        verify(mockRepo).save(captor.capture());
        MarketDto capturedDTO = mapper.entityToDTO(captor.getValue());
        assertThat(capturedDTO.getPrice()).isEqualTo(200);


    }

    @Test
    void can_update_stock() {
        //given
        Optional<Market> opt = Optional.of(market);
        doReturn(opt).when(mockRepo).findByGameRef(UUID_TEST);

        //when
        underTest.updateStockOnly(UUID_TEST, 155);

        //then
        ArgumentCaptor<Market> captor = ArgumentCaptor.forClass(Market.class);
        verify(mockRepo).save(captor.capture());
        MarketDto capturedDTO = mapper.entityToDTO(captor.getValue());
        assertThat(capturedDTO.getStock()).isEqualTo(155);
    }

    @Test
    void can_update_promo() {
        //given
        Optional<Market> opt = Optional.of(market);
        doReturn(opt).when(mockRepo).findByGameRef(UUID_TEST);

        //when
        underTest.updatePromotionOnly(UUID_TEST, 30);

        //then
        ArgumentCaptor<Market> captor = ArgumentCaptor.forClass(Market.class);
        verify(mockRepo).save(captor.capture());
        MarketDto capturedDTO = mapper.entityToDTO(captor.getValue());
        assertThat(capturedDTO.getPromotion()).isEqualTo(30);
    }

    @Test
    void can_update_all() {
        //given
        Optional<Market> opt = Optional.of(market);
        doReturn(opt).when(mockRepo).findByGameRef(UUID_TEST);

        //when
        underTest.updateAll(UUID_TEST, new MarketForm(UUID.randomUUID(),50.25,33,0,100));

        //then
        ArgumentCaptor<Market> captor = ArgumentCaptor.forClass(Market.class);
        verify(mockRepo).save(captor.capture());
        MarketDto capturedDTO = mapper.entityToDTO(captor.getValue());
        assertThat(capturedDTO)
                .extracting("price", "stock")
                .containsExactly(50.25, 33);
    }

    @Test
    void can_delete_one_market() {
        //given

        //when
        underTest.deleteOneMarket(UUID_TEST);
        //then
        verify(mockRepo).deleteByGameRef(any());
    }
}