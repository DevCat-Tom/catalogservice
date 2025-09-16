Implement a Spring Boot REST API based on a provided endpoint contract. Instead of ResponseEntity use the annotation @ResponseStatus().

The output code represents a complete implementation of that contract, including:

The Book data structure.
A repository interface for interacting with the data store.
A service layer containing the business logic (checking existence, saving/updating/deleting books).
A controller managing incoming HTTP requests and mapping them to the service methods.

| Endpoint             | HTTP Method | Request Body | Response Body      | Description                                                  |
|----------------------|-------------|--------------|--------------------|--------------------------------------------------------------|
| `/books`             | GET         |              | `Book[]`           | Get all the books in the catalog.                            |
| `/books`             | POST        | `Book`       | `Book`             | Add a new book to the catalog.                               |
|                      |             |              | `StatusResponse`   | A book with the same ISBN already exists.                    |
|                      |             |              | `422`              |                                                              |
| `/books/{isbn}`      | GET         |              | `Book`             | Get the book with the given ISBN.                            |
|                      |             |              | `StatusResponse`   | No book with the given ISBN exists.                          |
|                      |             |              | `404`              |                                                              |
| `/books/{isbn}`      | PUT         | `Book`       | `Book`             | Update the book with the given ISBN.                         |
|                      |             |              | `StatusResponse`   | Book created with the given ISBN.                            |
|                      |             |              | `201`              |                                                              |
| `/books/{isbn}`      | DELETE      |              |                    | Delete the book with the given ISBN.                         |

public record Book(String isbn,
String title,
String author,
Double price) {
}

Output code: