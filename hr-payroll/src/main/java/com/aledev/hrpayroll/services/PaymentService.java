package com.aledev.hrpayroll.services;

import com.aledev.hrpayroll.client.WorkerFeignClient;
import com.aledev.hrpayroll.entities.Payment;
import com.aledev.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final WorkerFeignClient feignClient;


    public Payment getPayment(long workerId, int days) {

        Worker worker = feignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
