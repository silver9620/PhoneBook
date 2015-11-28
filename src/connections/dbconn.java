package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonebook.Main;

/**
 *
 * @author Silver
 */
public class dbconn {
    
    public dbconn()
    {
        
    }
    
    private static final String dbUrl = "jdbc:derby:Phonebook;create=true;user=pb;password=silverstudios";
    
    public final String userTable = "USERN";
    public final String pbTable = "PHONEBOOKPB";
    public static final String dbName = "PhoneBook";
    
    /**
     * JDBC Connections
     */
    private static Connection conn = null;
    private Statement stmt = null;
    
    public static boolean startCheckSystem()
    {
        createConn();
        
        return false;
    }
    
    
    private static void createConn()
    {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(dbUrl);
            
            if(!checkDataBase())
            {
                
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(dbconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static String databaseName;
    private static boolean checkDataBase()
    {
        try {
            ResultSet resultSet = conn.getMetaData().getCatalogs();
            
            while(resultSet.next()) {
                databaseName = resultSet.getString(1);
                if(databaseName.equals(dbconn.dbName))
                {
                    System.out.println("YAY");
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
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
