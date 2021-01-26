package ba.zenica.Webshop.repository;

import ba.zenica.Webshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getProductByCategory_Id(Integer idCategory);
    Product findAllById(Integer productId);
}
