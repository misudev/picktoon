package com.project.picktoon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    @JsonIgnore
    private String passwd;
    @Column(name="nickname", length = 45)
    private String nickName;
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;

    public User(){
        roles = new HashSet<>();
        createdDate = new Date();
    }

    public void addRoles(Role role){
        roles.add(role);
    }
}
