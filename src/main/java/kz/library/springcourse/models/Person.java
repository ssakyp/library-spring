package kz.library.springcourse.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "The Name must not be empty.")
    @Size(min = 2, max = 100, message = "The length of the name must be between 2 and 100 characters.")
    private String fullName;

    @Min(value = 1900, message = "The year of birht must be more than 1900")
    private int yearOfBirth;

    // we need an empty constructor for Spring
    public Person(){}

    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public @NotEmpty(message = "The Name must not be empty.") @Size(min = 2, max = 100, message = "The length of the name must be between 2 and 100 characters.") String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty(message = "The Name must not be empty.") @Size(min = 2, max = 100, message = "The length of the name must be between 2 and 100 characters.") String fullName) {
        this.fullName = fullName;
    }

    @Min(value = 1900, message = "The year of birht must be more than 1900")
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(@Min(value = 1900, message = "The year of birht must be more than 1900") int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
