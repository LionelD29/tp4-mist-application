package be.technifutur.user.receiver;

import be.technifutur.shared.model.form.UserForm;
import be.technifutur.user.business.service.UserService;
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
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "sign-up")
    public void receiveSignUpForm(String message) throws IOException {
        UserForm form = objectMapper.readValue(message, UserForm.class);
        logger.info("USER RECEIVED - insert query");
        userService.addUser(form);
    }

    @RabbitListener(queues = "update-user-info")
    public void receiveUpdateUserForm(String message) throws IOException {
        UserForm form = objectMapper.readValue(message, UserForm.class);
        logger.info("USER RECEIVED - update query");
        userService.updateUserInfo(form);
    }

}
