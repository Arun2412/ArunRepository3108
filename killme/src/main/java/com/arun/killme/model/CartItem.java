package com.arun.killme.model;

import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.io.Serializable;

@Entity
public class CartItem implements Serializable
{
    private static final long serialVersionUID = 14L;
    @Id
    @GeneratedValue
    private int cartItemId;
    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
    @OneToOne
    @JoinColumn(name = "itemId")
    @JsonIgnore
    private AddItem addItem;
    private int quantity;
    private double totalPrice;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public AddItem getAddItem() {
        return addItem;
    }

    public void setAddItem(AddItem addItem) {
        this.addItem = addItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
