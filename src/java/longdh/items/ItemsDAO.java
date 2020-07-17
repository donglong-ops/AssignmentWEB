/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.items;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import longdh.DBUtils.utils;

/**
 *
 * @author donglong
 */
public class ItemsDAO implements Serializable {

    public ItemsDAO() {
    }

    public boolean insertItem(ItemsDTO item) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement preStm = null;

        String sql = "Insert into Items(title, cartID, amount) "
                + "values(?,?,?)";

        int result = 0;
        try {
            conn = utils.makeConnect();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, item.getTitle());
            preStm.setString(2, item.getCartID());
            preStm.setInt(3, item.getAmount());
            
            result = preStm.executeUpdate();
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result > 0;
    }
}
