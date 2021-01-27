package ba.zenica.Webshop.service;

import ba.zenica.Webshop.domain.CartItem;
import ba.zenica.Webshop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {


    @Autowired
    CartItemRepository cartItemRepository ;

    public void saveCartItem(CartItem cartItem){
        cartItemRepository.save(cartItem);
    }
    public void deleteCartItem(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }
}
