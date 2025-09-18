package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

/*
NOTE: Spring Data JPA works with mutating objects, so you can’t use Java
records. JPA entity classes must be marked with the @Entity annotation and
expose a no-args constructor. JPA identifiers are annotated with @Id and
@Version from the javax.persistence package instead of org.spring-
framework.data.annotation.
* */
public record Book(
        @Id
        Long id,
        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$", message = "The ISBN format must be valid.")
        String isbn,
        @NotBlank(message = "The book title must be defined.")
        String title,
        @NotBlank(message = "The book author must be defined.")
        String author,
        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater than zero.")
        Double price,
        @CreatedDate
        Instant createdDate,
        @LastModifiedDate
        Instant lastModifiedDate,
        @Version
        int version
) {

    public static Book of(String isbn, String title, String author, Double price) {
        // An entity is considered new when the ID is null and the version is 0.
        return new Book(null, isbn, title, author, price, null, null, 0);
    }
}


