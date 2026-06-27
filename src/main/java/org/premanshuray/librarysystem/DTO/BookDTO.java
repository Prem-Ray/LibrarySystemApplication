package org.premanshuray.librarysystem.DTO;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    private String name;

    private LocalDate publishedDate;

    private Long authorId;
}
