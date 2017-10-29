
package rmi.dto;

import java.io.Serializable;


public class AvailablePhoneDTO implements Serializable {
    
    private String maker;
    
    private String model;
    
    private int quantity;

    public AvailablePhoneDTO(String maker, String model, int quantity) {
        this.maker = maker;
        this.model = model;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
    
}
