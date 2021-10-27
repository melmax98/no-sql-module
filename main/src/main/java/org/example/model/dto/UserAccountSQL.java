package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_account")
public class UserAccountSQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAccountId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserSQL user;
    private double balance;

    public UserAccountSQL(UserSQL user, double balance) {
        this.user = user;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserAccountSQL that = (UserAccountSQL) o;
        return userAccountId != null && Objects.equals(userAccountId, that.userAccountId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
