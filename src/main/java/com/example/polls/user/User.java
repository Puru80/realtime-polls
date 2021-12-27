package com.example.polls.user;

import com.example.polls.audit.DateAudit;
import com.example.polls.role.RoleName;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends DateAudit {

    @MongoId(targetType = FieldType.INT64)
//    @Field(name = "id", targetType = FieldType.INT64)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @Indexed(unique = true)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    @Indexed(unique = true)
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany
//    @DBRef(lazy = true)
    @DocumentReference(collection = "roles", lookup = "{ '_id' : ?#{#target} }", lazy = true)
    private Set<RoleName> roleNameSet = new HashSet<>();

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
