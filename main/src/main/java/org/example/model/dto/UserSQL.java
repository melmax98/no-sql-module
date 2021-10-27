package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(propOrder = {"userId", "name", "email"})
@Entity
@Table(name = "user")
public class UserSQL implements Serializable {

    private static final long serialVersionUID = -521544420096070102L;

    public UserSQL(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;

    @Override
    public String toString() {
        return userId + " " + name + " " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserSQL userSQL = (UserSQL) o;
        return userId != null && Objects.equals(userId, userSQL.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
