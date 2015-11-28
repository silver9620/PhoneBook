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
    

    /**
     * @param args the command line arguments
     * This will start the connection/creation process of creating the 
     * database.
     */
    public static void main(String[] args) {
        checkStart();
        Login lg = new Login();
        lg.setVisible(true);
    }
    
    /**
     * Checks if there is a database present.
     * If not then it creates one
     * 
     * @return false, Returns this by default if there 
     * is now database so it will create one
     */
    private static void checkStart()
    {
        dbconn db = new dbconn();
    }
    

}
