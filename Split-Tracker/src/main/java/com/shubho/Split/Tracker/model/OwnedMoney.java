package com.shubho.Split.Tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OwnedMoney {
    private User user;
    private double amount;
    // 20133936
}