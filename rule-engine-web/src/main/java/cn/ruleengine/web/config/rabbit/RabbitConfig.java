package cn.ruleengine.web.config.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈消息队列配置〉
 *
 * @author 丁乾文
 * @create 2019/8/14
 * @since 1.0.0
 */
@Slf4j
@ConditionalOnExpression("#{environment.getProperty('spring.rabbitmq.host')!=null}")
@EnableRabbit
@Component
@Import(RabbitAutoConfiguration.class) // 当配置了rabbitmq配置时启用
public class RabbitConfig {

    public RabbitConfig() {
        log.info("load rabbit");
    }

    /**
     * 使用json传输,即使没有实现序列化接口也可以
     *
     * @return MessageConverter
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
