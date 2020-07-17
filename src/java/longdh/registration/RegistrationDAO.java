/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.registration;

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
public class RegistrationDAO implements Serializable {


    public RegistrationDTO checkLogin(String username, String password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        RegistrationDTO dto = null;
        try {
            //1. Open connection
            con = utils.makeConnect();
            //5.Process
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT username,lastname "
                        + " FROM Account "
                        + "WHERE username = ? AND password = ?";
                //3. Create Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Execute 
                rs = stm.executeQuery();
                while (rs.next()) {
                    String user = rs.getString("username");
                    String last = rs.getString("lastname");
                    dto = new RegistrationDTO(user, last);
                }
            }// end if con is not null
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

    private List<RegistrationDTO> accountList;

    public List<RegistrationDTO> getAccountList() {
        return accountList;
    }

    public void searchLastname(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Open connection
            con = utils.makeConnect();

            if (con != null) {
                //2. Create SQL String

                String sql = "SELECT username, password, lastname, isAdmin "
                        + "FROM Account "
                        + "WHERE lastname LIKE ? ";

                //3. Create Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");

                //4. Execute 
                rs = stm.executeQuery();

                //5.Process
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();
                    }//End if student List is null
                    this.accountList.add(dto);

                }//End while rs
            }// end if con is not null
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

    public boolean deleteAccount(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Open connection
            con = utils.makeConnect();

            if (con != null) {
                //2. Create SQL String

                String sql = "DELETE FROM Account "
                        + " WHERE username = ? ";

                //3. Create Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, username);

                int row = stm.executeUpdate();
                //4. Execute 

                if (row > 0) {
                    return true;
                }

                //5.Process
                //End while rs
            }// end if con is not null
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return false;
    }

    public boolean updatePassRole(String username, String password, boolean role)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Open connection
            con = utils.makeConnect();

            if (con != null) {
                //2. Create SQL String

                String sql = "UPDATE Account "
                        + "SET password = ? , isAdmin = ? "
                        + "WHERE username = ? ";

                //3. Create Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);

                int row = stm.executeUpdate();
                //4. Execute 

                if (row > 0) {
                    return true;
                }

                //5.Process
                //End while rs
            }// end if con is not null
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return false;
    }

    public boolean insertAccount(RegistrationDTO dto)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Open connection
            con = utils.makeConnect();

            if (con != null) {
                //2. Create SQL String

                String sql = "Insert into Account( username ,password,lastname,isAdmin) "
                        + " values (? , ? , ? , ?) ";

                //3. Create Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getLastname());
                stm.setBoolean(4, dto.isRole());

                int row = stm.executeUpdate();
                //4. Execute 

                if (row > 0) {
                    return true;
                }

                //5.Process
                //End while rs
            }// end if con is not null
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public boolean eDitInfo(String username, String password,String lastname, boolean role)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Open connection
            con = utils.makeConnect();

            if (con != null) {
                //2. Create SQL String

                String sql = "UPDATE Account "
                        + "SET password = ? , isAdmin = ?, lastname = ? "
                        + "WHERE username = ? ";

                //3. Create Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, lastname);
                stm.setString(4, username);
                

                int row = stm.executeUpdate();
                //4. Execute 

                if (row > 0) {
                    return true;
                }

                //5.Process
                //End while rs
            }// end if con is not null
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return false;
    }
}
