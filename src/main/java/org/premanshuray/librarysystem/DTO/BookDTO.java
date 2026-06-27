package org.premanshuray.librarysystem.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    @NotBlank(message = "Book name is required")
    private String name;

    private LocalDate publishedDate;

    @NotNull(message = "Author ID is required")
    private Long authorId;
}
