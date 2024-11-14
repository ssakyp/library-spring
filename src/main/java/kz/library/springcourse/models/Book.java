package kz.library.springcourse.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message="The name of the book must not be empty.")
    @Size(min=2, max=100, message = "The name of the book must be of length between 2 and 100.")
    private String title;

    @NotEmpty(message = "Author must not be empty")
    @Size(min = 2, max = 100, message = "The name of the author must be of length between 2 and 100")
    private String author;

    @Min(value = 1500, message = "The year must be more than 1500")
    private int year;

    public Book(){}

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public @NotEmpty(message = "The name of the book must not be empty.") @Size(min = 2, max = 100, message = "The name of the book must be of length between 2 and 100.") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "The name of the book must not be empty.") @Size(min = 2, max = 100, message = "The name of the book must be of length between 2 and 100.") String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Author must not be empty") @Size(min = 2, max = 100, message = "The name of the author must be of length between 2 and 100") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotEmpty(message = "Author must not be empty") @Size(min = 2, max = 100, message = "The name of the author must be of length between 2 and 100") String author) {
        this.author = author;
    }

    @Min(value = 1500, message = "The year must be more than 1500")
    public int getYear() {
        return year;
    }

    public void setYear(@Min(value = 1500, message = "The year must be more than 1500") int year) {
        this.year = year;
    }
}

