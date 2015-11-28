/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        return false;
    }
    
    public boolean reisterService(String userName, String pwd)
    {
        
        return false;
    }
    
    
    
}
