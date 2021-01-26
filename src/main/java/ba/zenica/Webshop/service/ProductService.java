package ba.zenica.Webshop.service;

import ba.zenica.Webshop.domain.Product;
import ba.zenica.Webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductByCategory_Id(Integer idCategory) {
        return productRepository.getProductByCategory_Id(idCategory);
    }

    public  List<Product> listAll(){
        return productRepository.findAll();
    }

    public Product getProducts(Integer productId){
        return productRepository.findAllById(productId);
    }
}
