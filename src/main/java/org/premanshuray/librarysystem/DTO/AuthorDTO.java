package org.premanshuray.librarysystem.DTO;

import lombok.*;
import org.premanshuray.librarysystem.Entity.Book;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Long id;
    private String name;
    private String email;

    private List<BookDTO> books;

}
