package kz.library.springcourse.util;


import kz.library.springcourse.dao.PersonDao;
import kz.library.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDao personDao;

    @Autowired
    public PersonValidator(PersonDao personDao) {this.personDao = personDao;}

    @Override
    public boolean supports(Class<?> aClass) {return Person.class.equals(aClass);}

    @Override
    public void validate(Object o, Errors errors){
        Person person = (Person) o;

        if (personDao.getPersonByFullName(person.getFullName()).isPresent())
            errors.rejectValue("fullName", "", "Person with same Full Name already exists.");
    }


}
