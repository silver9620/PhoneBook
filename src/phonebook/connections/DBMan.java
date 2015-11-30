/*
 * Copyright (c) 2015 Silver.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Silver - initial API and implementation and/or initial documentation
 */
package phonebook.connections;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silver
 */
public class DBMan extends dbconn{
    
    public DBMan()
    {
        
    }
    
    public boolean deleteEntry(String name, int pid)
    {
        try {
            stmt = conn.createStatement();
            String sql = "";
        } catch (SQLException ex) {
            Logger.getLogger(DBMan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
