package com.aledev.hrpayroll.services;

import com.aledev.hrpayroll.entities.Payment;
import com.aledev.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final RestTemplate restTemplate;
    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", "" + workerId);
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
