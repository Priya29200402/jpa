package com.xworkz.hydro.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
    private Integer id;
    private String name;
    private String email;
    private Long mobileNo;
    private String password;
    private String confirmPassword;

    public RegisterDTO(String name, String email, Long mobileNo, String password, String confirmPassword) {
    }
}
