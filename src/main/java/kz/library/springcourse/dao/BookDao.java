package kz.library.springcourse.dao;

import kz.library.springcourse.models.Book;
import kz.library.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title, author, year) VALUES(?, ?, ?)", book.getTitle(), book.getAuthor(),
                book.getYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=? WHERE id=?", updatedBook.getTitle(), updatedBook.getAuthor(),
                updatedBook.getYear(), id);
    }

    public void delete(int id) {jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);}

    // Joining Book and Person tables and getting people, who have books with id
    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT FROM Person.* FROM Book JOIN Person ON Book.person_id = Person.id " +
                "WHERE Book.id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    // Releasing a book (method is called when a person brings back the book)
    public void release(int id) {jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);}

    // Assigning a person for a book (method is called when a person takes a book)
    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }
}

