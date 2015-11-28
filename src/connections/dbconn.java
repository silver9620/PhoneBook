package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    /**
     * JDBC Connections
     */
    private Connection conn = null;
    private Statement stmt = null;
    
    
    public Connection createConn()
    {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(dbUrl);
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(dbconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
