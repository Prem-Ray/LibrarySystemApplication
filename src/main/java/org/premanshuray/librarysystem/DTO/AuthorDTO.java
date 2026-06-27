package org.premanshuray.librarysystem.DTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Long id;
    private String name;
    private String email;

    private List<BookDTO> books;

}
