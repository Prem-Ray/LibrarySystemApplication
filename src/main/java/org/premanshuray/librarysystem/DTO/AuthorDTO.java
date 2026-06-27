package org.premanshuray.librarysystem.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Long id;

    @NotBlank(message = "Author name is required")
    private String name;

    @NotBlank(message = "Author email is required")
    @Email(message = "Email should be valid")
    private String email;

    private List<BookDTO> books;

}
