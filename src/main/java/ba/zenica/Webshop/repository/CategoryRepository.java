package ba.zenica.Webshop.repository;

import ba.zenica.Webshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
