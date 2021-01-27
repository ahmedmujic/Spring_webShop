package ba.zenica.Webshop.repository;

import ba.zenica.Webshop.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {



}
