import java.sql.*;
import java.util.ArrayList;

/**
 * This class is handler for Data Base
 * Creating, writing, closing
 * also this class uses Data Base to calculate some things, that task asks
 * There are all methods are static because we don't need to create objects of this class
 * or descendants of it, so it needs only to work with Data Base
 */
public class DbHandler {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    /**
     * This method creating Data Base named People
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists [People] (\n" +
                "[id] INTEGER  NOT NULL PRIMARY KEY,\n" +
                "[Name] TEXT  NOT NULL,\n" +
                "[Surname] TEXT  NOT NULL,\n" +
                "[Sex] TEXT  NOT NULL,\n" +
                "[Age] INTEGER  NOT NULL\n" +
                ");");

        System.out.println("Table is made or already exists.");
    }

    /**
     * This metod is cleaning DB, but isn't using somewhere yet
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void CleanDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("DELETE FROM People");

        System.out.println("Table is made or already exists.");
    }

    /**
     * This method get object of People and put it in DB
     * @param people
     * @throws SQLException
     */
    public static void WriteDB(People people) throws SQLException
    {
        Integer id = people.getId();
        String name = people.getName();
        String surname = people.getSurname();
        String sex = people.getSex();
        Integer age = people.getAge();

        String request = "INSERT INTO 'People' ('id', 'Name', 'Surname', 'Sex', 'Age') " +
                "VALUES (" + id + ",'" + name + "','" +  surname + "','" +  sex + "'," +  age + "); ";
        statmt.execute(request);
    }

    /**
     * This method uses to connect DB to program
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void Connect() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:People.s3db");
        System.out.println("Database connected!");
    }

    /**
     * This method closes Db with ending of program
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
    }

    /**
     * This method uses to calculate average age of all users in DB
     * @return average age
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static double calculateAverageAge() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM People");

        int k = 0; //counter of people, who have age
        Integer sum = 0; //variable to hold and sum people's ages

        while(resSet.next()) {
          Integer age = resSet.getInt("Age");
          sum += age;
          k++;
        }
        return sum/k;
    }

    /**
     * this method return the most older user as object of People
     * @throws SQLException
     */
    public static People mostOldUser () throws SQLException {

        resSet = statmt.executeQuery("SELECT * FROM People ORDER BY Age DESC");

        String name = resSet.getString("Name");
        String surname = resSet.getString("Surname");
        String sex = resSet.getString("Sex");
        Integer age = resSet.getInt("Age");

        return new People(name, surname, sex, age);
    }

    /**
     * This method return the most popular female name from DB leaning SQL-queries
     * @throws SQLException
     */
    public static String mostPopularFemName() throws SQLException {

        return resSet.getString("SELECT Name, COUNT(*) FROM People GROUP BY Name WHERE Sex='Female' " +
                "ORDER BY DESC");
    }

    /**
     * @param surname
     * @return Array List of People with similar _surname as parameter
     * @throws SQLException
     */
    public static ArrayList<People> getPeopleWithThisSurname (String surname) throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM People WHERE Surname='" + surname + "'");

        ArrayList<People> similarSurnamePeople = new ArrayList<People>();
        while (resSet.next()) {
          String name = resSet.getString("Name");
          String sex = resSet.getString("Sex");
          Integer age = resSet.getInt("Age");

          similarSurnamePeople.add(new People(name, surname, sex, age));
        }
        return similarSurnamePeople;
    }

}
