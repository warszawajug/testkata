package spockogroovy

class PersonService {

    PersonDao dao

    Person get(long id) {
        if (id == 0) {
            throw new IllegalArgumentException('id must by greater than zero')
        }
        dao.findById(id)
    }

    List<Person> getAllGeorges() {
        dao.findAllByName('George')
    }

    List<Person> getAllAdults() {
        dao.findAllOlderThan(18)
    }

    void save(Person person) {
        if (person.id) {
            Person personFromDb = dao.findById(person.id)
            personFromDb.name = person.name
            personFromDb.age = person.age
            dao.update(personFromDb)
        } else {
            dao.create(person.name, person.age)
        }
    }

}
