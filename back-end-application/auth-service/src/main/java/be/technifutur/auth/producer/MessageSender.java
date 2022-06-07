package be.technifutur.auth.producer;

import be.technifutur.shared.model.form.UserForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void askForUserCreation(UserForm message) {
        try {
            String json = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend("authUserExchange", "sign-up", json);
        } catch (JsonProcessingException ignored) { }
    }

    public void askForUserUpdate(UserForm message) {
        try {
            String json = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend("authUserExchange", "update-user-info", json);
        } catch (JsonProcessingException ignored) { }
    }
}
