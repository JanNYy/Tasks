package courses.task1.people;

public class Human {

    protected String name;
    protected int age;
    protected Gender gender;

    private static final int MIN_HUMAN_AGE = 0;
    private static final int MAX_HUMAN_AGE = 150;

    private void nameCheck(String name) throws PeopleException {
        if (name == null) throw new PeopleException("Name is null");
    }

    private void ageCheck(int age) throws PeopleException {
        if (age < MIN_HUMAN_AGE) throw new PeopleException("Age is less than "+ MIN_HUMAN_AGE);
        if (age > MAX_HUMAN_AGE) throw new PeopleException("Age is greater than "+MAX_HUMAN_AGE);
    }

    public Human(String humanName, int humanAge, Gender humanGender) throws PeopleException {
        nameCheck(humanName);
        ageCheck(humanAge);
        name = humanName;
        age = humanAge;
        gender = humanGender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String toString() {
        return "Name: "+name+", age: "+age+", gender: "+gender;
    }

}
