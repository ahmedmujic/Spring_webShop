package ba.zenica.Webshop.repository;

import ba.zenica.Webshop.domain.Cart;
import ba.zenica.Webshop.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart getAllById(Integer id);
}
