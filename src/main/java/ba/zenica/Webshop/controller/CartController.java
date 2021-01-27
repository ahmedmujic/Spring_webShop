package ba.zenica.Webshop.controller;

import ba.zenica.Webshop.domain.*;
import ba.zenica.Webshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;
    @Autowired
    CartItemService cartItemService;

    @Autowired
    ProductService productService;
    @RequestMapping("/cart")
    public String getCartPage(Model model,@RequestParam("id") Integer cartId){
        //get current user
       MyUserDetails u = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //get logged user
        User loggedUser = userService.findUserByUsername(u.getUsername());

        Cart cart = cartService.getAllItemsFromCart(loggedUser.getCart().getId());

        model.addAttribute("cartItemsArray", cart.getCartItems());
        model.addAttribute("total", cart.getGrandTotal());

        return "cart";

    }
    @RequestMapping(value = "/removeItem/{id}", method = RequestMethod.GET)
    public String removeItem(@PathVariable("id") Integer id){
        Product product = productService.getProducts(id);
        //get current user
        MyUserDetails u = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //get logged user
        User loggedUser = userService.findUserByUsername(u.getUsername());
        System.out.println(loggedUser.getCart().getId());
        Cart cart = cartService.getAllItemsFromCart(loggedUser.getCart().getId());


        int b=0;
        for(int i=0;i<cart.getCartItems().size();i++){
            if(cart.getCartItems().get(i).getProduct().getId().equals(product.getId()))
            {
                if(cart.getCartItems().get(i).getQuantity()>0){
                    cart.getCartItems().get(i).setQuantity(cart.getCartItems().get(i).getQuantity()-1);
                    cart.getCartItems().get(i).setTotalPrice(cart.getCartItems().get(i).getTotalPrice()-product.getPrice());
                    cart.setGrandTotal(cart.getGrandTotal()-product.getPrice());
                    cartItemService.saveCartItem(cart.getCartItems().get(i));
                    b++;
                }
                else if(cart.getCartItems().get(i).getQuantity()==0){
                    cartItemService.deleteCartItem(cart.getCartItems().get(i));
                }
            }
        }

        cartService.saveCart(cart);
        return "redirect:/products";

    }
    @RequestMapping(value="/addItem/{id}", method = RequestMethod.GET)
    public String addItem(@PathVariable("id") Integer id)
    {
        Product product = productService.getProducts(id);
        //get current user
        MyUserDetails u = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //get logged user
        User loggedUser = userService.findUserByUsername(u.getUsername());
        System.out.println(loggedUser.getCart().getId());
        Cart cart = cartService.getAllItemsFromCart(loggedUser.getCart().getId());

        int b=0;

            for(int i=0;i<cart.getCartItems().size();i++){
                if(cart.getCartItems().get(i).getProduct().getId().equals(product.getId()))
                {
                    System.out.println("nasli smo");
                    cart.getCartItems().get(i).setQuantity(cart.getCartItems().get(i).getQuantity()+1);
                    cart.getCartItems().get(i).setTotalPrice(cart.getCartItems().get(i).getTotalPrice()+product.getPrice());
                    cart.setGrandTotal(cart.getGrandTotal()+product.getPrice());
                    cartItemService.saveCartItem(cart.getCartItems().get(i));
                    b++;

                }
            }
        if (b==0){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setCart(cart);
            cartItem.setTotalPrice(product.getPrice());
            cart.getCartItems().add(cartItem);
            cartItemService.saveCartItem(cartItem);
        }

        cartService.saveCart(cart);
        return "redirect:/products";
    }


}
