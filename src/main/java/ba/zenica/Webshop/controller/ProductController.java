package ba.zenica.Webshop.controller;

import ba.zenica.Webshop.domain.Product;
import ba.zenica.Webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String viewProductPage(Model model){
        List<Product> productList = productService.listAll();
        model.addAttribute("productsList",productList);
        return "products";
    }

    @GetMapping("/category/{id}")
    public String getProductsByCategory(@PathVariable("id") Integer id, Model model){
        List<Product> productList  = productService.getProductByCategory_Id(id);
        model.addAttribute("productsList", productList);
        return "products";
    }
    @GetMapping("/details/{id}")
    public String getProductsDetails(@PathVariable("id") Integer id, Model model){
        Product productList = productService.getProducts(id);
        model.addAttribute("product", productList);
        return "productDetails";

    }
}
