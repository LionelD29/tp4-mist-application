package be.technifutur.market.receiver;

import be.technifutur.market.business.service.MarketService;
import be.technifutur.shared.model.form.MarketForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class MessageReceiver {

    private final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
    private final MarketService marketService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "add-game-to-market")
    public void receiveMarketForm(String message) throws IOException {
        MarketForm form = objectMapper.readValue(message, MarketForm.class);
        logger.info("MARKET RECEIVED - add game to market service");
        marketService.addMarket(form);
    }

}
