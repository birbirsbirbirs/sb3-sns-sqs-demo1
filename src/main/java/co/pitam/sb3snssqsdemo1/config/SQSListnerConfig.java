package co.pitam.sb3snssqsdemo1.config;

import co.pitam.sb3snssqsdemo1.entity.SampleRecord;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration
public class SQSListnerConfig {
    private static final String QUEUE_NAME="sqs-1";

    @SqsListener(queueNames = QUEUE_NAME)
    void listen(SampleRecord message){
        log.info("Received message {} {}",message.propertyOne(),message.propertyTwo());
    }

    @Bean
    public ApplicationRunner sendMessageToSQSQueue(SqsTemplate sqsTemplate){
        return args->sqsTemplate.send(QUEUE_NAME,new SampleRecord("Hello!","From SQS!"));
    }

}
