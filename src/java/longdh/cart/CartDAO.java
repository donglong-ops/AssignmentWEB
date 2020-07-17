/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.cart;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.naming.NamingException;
import longdh.DBUtils.utils;

/**
 *
 * @author donglong
 */
public class CartDAO implements Serializable {

    public CartDAO() {
    }
    private List<CartObject> bookListInCart;

    public List<CartObject> getBookList() {
        return bookListInCart;
    }

    public boolean insertCart(CartDTO cart) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement preStm = null;
        String sql = "Insert into Carts(CartID, Username,Address) "
                + " values(?,?,?,)";

        int rt = 0;
        try {
//            LocalDate date = java.time.LocalDate.now();
//            Date buydate = Date.valueOf(date);

            conn = utils.makeConnect();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, cart.getCartID());
            preStm.setString(2, cart.getUsername());
            preStm.setString(3, cart.getAddress());

            rt = preStm.executeUpdate();
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return rt  > 0;

    }
}
