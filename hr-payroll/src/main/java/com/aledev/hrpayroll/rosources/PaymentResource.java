package com.aledev.hrpayroll.rosources;

import com.aledev.hrpayroll.entities.Payment;
import com.aledev.hrpayroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResource {
    private final PaymentService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = service.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }
}
