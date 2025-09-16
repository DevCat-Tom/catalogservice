Task add jakarta.validation.constraints.* validation annotations to the fields of the Book record in order to enforce data integrity and ensure that the values provided for each field meet specific criteria.
When writing messages prefer: "The book author must be defined." vs "Author cannot be blank."

**Recall available annotations:**
AssertFalse
AssertTrue
DecimalMax
DecimalMin
Digits
Email
Future
FutureOrPresent
Max
Min
Negative
NegativeOrZero
NotBlank
NotEmpty
NotNull
Null
Past
PastOrPresent
Pattern
Positive
PositiveOrZero
Size

Here's a breakdown of what needed to be done:

Validate ISBN:
It must be defined and not blank.
It must conform to either a 10-digit or 13-digit format (@Pattern with regex ^([0-9]{10}|[0-9]{13})$).

Validate Title:
It must be defined and not blank.

Validate Author:
It must be defined and not blank.

Validate Price:
It must be defined.
It must be a positive number, meaning greater than zero.

public record Book(String isbn,
String title,
String author,
Double price) {
}