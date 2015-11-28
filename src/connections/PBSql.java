package connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silver
 */
public class PBSql extends dbconn{
    
    public boolean loginService(String userName, String pwd)
    {
        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM USERN WHERE userNa='" + userName + "' AND passwd='" + pwd + "'");
            if(res.next())
            {
                stmt.close();
                return true;
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PBSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean checkUserService(String userName)
    {
        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM USERN WHERE userNa='" + userName + "'");
            if(res.next())
            {
                stmt.close();
                return true;
            }
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    public boolean reisterService(String userName, String pwd)
    {
        try {
            stmt = conn.createStatement();
            String SQLRU = "INSERT INTO USERN (userNa, passwd) VALUES ('" + userName + "', '" + pwd +"')";
            stmt.execute(SQLRU);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PBSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
}
