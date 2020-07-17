/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.DBUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author donglong
 */
public class utils implements Serializable {

    public static Connection makeConnect() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context tomContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomContext.lookup("SE1402DS");
        Connection con = ds.getConnection();
        return con;
    }
}
