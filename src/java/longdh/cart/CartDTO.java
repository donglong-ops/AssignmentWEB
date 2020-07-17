/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.cart;

import java.io.Serializable;

/**
 *
 * @author donglong
 */
public class CartDTO implements Serializable{
    private String cartID, username,address;

    public CartDTO() {
    }

    public CartDTO(String cartID, String username, String address) {
        this.cartID = cartID;
        this.username = username;
        this.address = address;
    }

     
    public CartDTO(String cartID, String username) {
        this.cartID = cartID;
        this.username = username;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
