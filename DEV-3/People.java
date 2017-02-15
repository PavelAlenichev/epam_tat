/**
 * This method uses to describe human as object of People, which has name, surname, sex, age
 */
public class People {
    private String name;
    private String surname;
    private String sex;
    private Integer age;
    private static Integer id = 0;

    public People(String name, String surname, String sex, Integer age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }

    public static Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {

        return sex;
    }

    public String getSurname() {

        return surname;
    }

    public String getName() {

        return name;
    }

    /**
     * incrementing id of people for Data Base
     */
    public static void incrementId() {
        People.id++;
    }
}
