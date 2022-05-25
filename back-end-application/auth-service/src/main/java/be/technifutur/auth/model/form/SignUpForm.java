package be.technifutur.auth.model.form;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class SignUpForm {

    @NotBlank
    @Size(max = 30)
    private String firstName;

    @NotBlank
    @Size(max = 30)
    private String lastName;

    @NotNull
    @Past
    private LocalDate birthDate;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotBlank
    private String password;

}
