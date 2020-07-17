/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.items;

import java.io.Serializable;

/**
 *
 * @author donglong
 */
public class ItemsDTO implements Serializable{
    private String title, cartID;
    private int amount;

    public ItemsDTO() {
    }

    public ItemsDTO(String title, String cartID, int amount) {
        this.title = title;
        this.cartID = cartID;
        this.amount = amount;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
