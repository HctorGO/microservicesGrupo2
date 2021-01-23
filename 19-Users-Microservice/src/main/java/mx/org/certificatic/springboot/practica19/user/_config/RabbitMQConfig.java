package mx.org.certificatic.springboot.practica19.user._config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;
	
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory.getRabbitConnectionFactory();
    }
	
	// Define bean FanoutExchange fanoutExchange
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("usercreated.fanout");
	}
	
	// Define bean Queue userCreatedAccountQueue
	@Bean
	public Queue userCreatedAccountQueue() {
		return new Queue("usercreated.account.queue" , true);
	}
	
	// Define bean Queue userCreatedLogQueue
	@Bean
	public Queue userCreatedLogQueue() {
		return new Queue("usercreated.log.queue" , true);
	}
	
	// Define Binding binding1
	@Bean
	public Binding binding1(FanoutExchange fanoutExchange, Queue userCreatedAccountQueue) {
		return BindingBuilder.bind(userCreatedAccountQueue).to(fanoutExchange);
	}
	// Define Binding binding2
	@Bean
	public Binding binding2(FanoutExchange fanoutExchange, Queue userCreatedLogQueue) {
		return BindingBuilder.bind(userCreatedLogQueue).to(fanoutExchange);
	}
}
