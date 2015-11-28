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

package phonebook;

import phonebook.GUI.Login;
import phonebook.connections.dbconn;
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
        Main.Start();
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
    private static void Start()
    {
        dbconn db = new dbconn();
        
    }
    

}
