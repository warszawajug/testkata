package spockogroovy

interface PersonDao {

    Person findById(long id)

    List<Person> findAllByName(String name)

    List<Person> findAllOlderThan(int age)

    /** @return auto-generated id */
    int create(String name, int age)

    void update(Person person)
}
