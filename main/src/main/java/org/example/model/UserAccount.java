package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    private Long userAccountId;

    private User user;
    private double balance;

    public UserAccount(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }
}
