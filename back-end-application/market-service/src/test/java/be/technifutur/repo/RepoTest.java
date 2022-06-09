package be.technifutur.repo;

import be.technifutur.model.entity.Market;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@DataJpaTest
@DisplayName("Repository unit test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RepoTest {

    @Autowired
    private MarketRepo underTest;

    @BeforeEach
    void setup() {
        underTest.deleteAll();
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void it_should_return_1_market_entity(){
        //given
        Market market = Market.builder()
                .id(0L)
                .gameRef(UUID.randomUUID())
                .price(100)
                .stock(50)
                .build();
        UUID ref = market.getGameRef();
        underTest.save(market);
        //when
        Market entity = underTest.findByGameRef(ref).get();
        //then
        assertThat(entity).isNotNull();
    }

    @Test
    void it_should_not_return_1_market_entity_and_throw_exception(){
        //given
        Market market = Market.builder()
                .id(0L)
                .gameRef(UUID.randomUUID())
                .price(100)
                .stock(50)
                .build();
        underTest.save(market);
        //then
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(()->{
            underTest.findByGameRef(UUID.randomUUID()).get();
        });
    }
    @Test
    void it_should_delete_one_entity(){
        //given
        Market market1 = Market.builder()
                .id(0L)
                .gameRef(UUID.randomUUID())
                .price(100)
                .stock(50)
                .build();
        Market market2 = Market.builder()
                .id(1L)
                .gameRef(UUID.randomUUID())
                .price(100)
                .stock(50)
                .build();
        underTest.saveAll(List.of(market1,market2));
        //when
        underTest.deleteByGameRef(market1.getGameRef());
        //then
        assertThat(underTest.findAll().size()).isEqualTo(1);
    }

}
