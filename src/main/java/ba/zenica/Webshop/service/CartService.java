package ba.zenica.Webshop.service;

import ba.zenica.Webshop.domain.Cart;
import ba.zenica.Webshop.domain.CartItem;
import ba.zenica.Webshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart getAllItemsFromCart(Integer cartId){
        return cartRepository.getAllById(cartId);
    }

    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }
}
