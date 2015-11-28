package phonebook;

import GUI.Login;
import connections.dbconn;
import java.sql.Connection;
import java.sql.Statement;
/**
 *
 * @author Silver
 */
public class Main {
    
    static dbconn db = new dbconn();

    /**
     * @param args the command line arguments
     * This will start the connection/creation process of creating the 
     * database.
     */
    public static void main(String[] args) {
        if(!checkStart())
        {
            createDataBase();
            createLoginDatabase();
            createMainDataBase();
        }
        Login lg = new Login();
    }
    
    /**
     * Checks if there is a database present.
     * If not then it creates one
     * 
     * @return false, Returns this by default if there 
     * is now database so it will create one
     */
    private static boolean checkStart()
    {
        db.startCheckSystem();
        return false;
    }
    
    /**
     * Creates the Login Database filled with users
     */
    private static void createLoginDatabase()
    {
        
        
    }
    
    /**
     * Creates the main database that will
     * hold most if not all the info
     */
    private static void createMainDataBase()
    {
        
    }

    private static void createDataBase() {
        
    }
    
}
