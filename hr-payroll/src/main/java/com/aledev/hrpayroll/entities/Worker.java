package com.aledev.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;


}
