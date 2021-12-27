package com.example.polls.role;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;

@Data
@Document(collection = "roles")
@Getter
@Setter
public class Role {
    @MongoId(targetType = FieldType.INT64)
//    @Field(name = "role_id", targetType = FieldType.INT64)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleName roleName;

    public Role() {

    }

    public Role(RoleName name) {
        this.roleName = name;
    }
}
