package be.technifutur.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("sign_up")
    public Queue signUpQueue() {
        return new Queue("sign-up", true);
    }

    @Bean("update_user_info")
    public Queue updateUserInfoQueue() {
        return new Queue("update-user-info", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("authUserExchange");
    }

    @Bean
    public Binding signUpBinding(@Qualifier("sign_up") Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("sign-up");
    }

    @Bean
    public Binding updateUserInfoBinding(@Qualifier("update_user_info") Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("update-user-info");
    }

}
