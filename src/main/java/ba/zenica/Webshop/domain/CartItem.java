package ba.zenica.Webshop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
public class CartItem implements Serializable{

    @Id
   @ManyToOne
   @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false, referencedColumnName = "id")
    private Cart cart;

    private int quantity;
    private Double totalPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity && Objects.equals(product, cartItem.product) && Objects.equals(cart, cartItem.cart) && Objects.equals(totalPrice, cartItem.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, cart, quantity, totalPrice);
    }
}
