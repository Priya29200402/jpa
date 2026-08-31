package com.xworkz.hydro.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name="register_info")
public class RegisterEntity{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="mobileNo")
    private Long mobileNo;
    @Column(name="password")
    private String password;
    @Column(name="confirmPassword")
    private String confirmPassword;

    public RegisterEntity(String email, String name, Long mobileNo, String password, String confirmPassword) {
        this.email = email;
        this.name = name;
        this.mobileNo = mobileNo;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
