package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(propOrder = {"userId", "name", "email"})
@EqualsAndHashCode
@Document(collection = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -521544420096070102L;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Id
    private String userId;
    private String name;
    private String email;

    @Override
    public String toString() {
        return userId + " " + name + " " + email;
    }
}
