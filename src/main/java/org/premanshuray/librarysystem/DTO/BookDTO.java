package org.premanshuray.librarysystem.DTO;

import lombok.*;
import org.premanshuray.librarysystem.Entity.Author;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    private String name;

    private LocalDate publishedDate;

    private Long authorId;
}
