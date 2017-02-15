import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 * Entry point in application
 */
public class EntryPoint {

    /**
     * Creating Data base, contacting with user and then closing Data base after all actions
     * @param args
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException,
            ExecutionException, InterruptedException {
        DbHandler.Connect();
        DbHandler.CreateDB();

        Contacter contacter = new Contacter();
        contacter.contact();

        DbHandler.CloseDB();
    }
}