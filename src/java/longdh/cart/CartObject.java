/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author donglong
 */
public class CartObject implements Serializable{
    
    private String CustomerName;
    private Map<String , Integer> items;

    public CartObject(String CustomerName, Map<String, Integer> items) {
        this.CustomerName = CustomerName;
        this.items = items;
    }

    public CartObject() {
        
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    
    
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    
    public void addItemToCart(String title){
        if(this.items == null){
            this.items = new HashMap<>();
            
        }//End if items is not exited
        
        int quantity = 1;
        if(this.items.containsKey(title)) {
            quantity = this.items.get(title) + 1;   
        }
        this.items.put(title, quantity);
    }
    
    public void removeItemFromCart(String title){
        
        if(this.items == null){
            return;
        }
        if(this.items.containsKey(title)){
            this.items.remove(title);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
}
