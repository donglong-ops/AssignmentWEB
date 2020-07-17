/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.book;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import longdh.DBUtils.utils;

/**
 *
 * @author donglong
 */
public class BookDAO implements Serializable {

    public BookDAO() {
    }
    private List<BookDTO> bookList;

    public List<BookDTO> getBookList() {
        return bookList;
    }

    public void getBook() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = utils.makeConnect();
            if (con != null) {
                String sql = "SELECT BookId, Bookname,"
                        + " Price ,  Quantity  FROM Books ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookid = rs.getString("BookId");
                    String bookName = rs.getString("Bookname");
                    int price = rs.getInt("Price");
                    int quantity = rs.getInt("Quantity");
                    BookDTO dto = new BookDTO(bookid, bookName, price, quantity);
                    if (this.bookList == null) {
                        this.bookList = new ArrayList<>();
                    }//End if book List is null
                    this.bookList.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public BookDTO findBookbyBookName(String bookname) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDTO dto = null;
        try {
            con = utils.makeConnect();
            if (con != null) {
                String sql = "SELECT BookId, Bookname, Price, Quantity "
                        + "FROM Books where Bookname =? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookname);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookid = rs.getString("BookId");
                    String bookName = rs.getString("Bookname");
                    int price = rs.getInt("Price");
                    int quantity = rs.getInt("Quantity");
                    dto = new BookDTO(bookid, bookName, price, quantity);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }
}
