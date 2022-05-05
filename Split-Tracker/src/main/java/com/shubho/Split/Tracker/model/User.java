package com.shubho.Split.Tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private long id;
    private String userName;
    private String mobile;
    private String email;
    private List<OwnedMoney> owners = new ArrayList<>();

    public User(long id, String userName, String mobile, String email) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
        this.email = email;
    }
    // which user owns how much money to him.
}
