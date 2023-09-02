package co.pitam.sb3snssqsdemo1.controller;

import co.pitam.sb3snssqsdemo1.entity.SampleRecord;
import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/sns-controller")
public class SNSController {

    private static final String TOPIC_ARN = "arn:aws:sns:us-east-1:000000000000:sns-1";
    private final SnsTemplate snsTemplate;

    @GetMapping
    public void sendSns() {
        snsTemplate.convertAndSend(TOPIC_ARN, new SampleRecord("property one", UUID.randomUUID().toString()));
    }
}
