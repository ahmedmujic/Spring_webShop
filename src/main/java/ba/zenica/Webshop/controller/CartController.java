package ba.zenica.Webshop.controller;

import ba.zenica.Webshop.domain.MyUserDetails;
import ba.zenica.Webshop.domain.User;
import ba.zenica.Webshop.service.CartService;
import ba.zenica.Webshop.service.UserDetails;
import ba.zenica.Webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @RequestMapping("/cart")
    public String getCartPage(Model model,@RequestParam Integer cartId){
        //get current user
        MyUserDetails u = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //get logged user
        User loggedUser = userService.findUserByUsername(u.getUsername());
        model.addAttribute("cart", cartService.getAllItemsFromCart(loggedUser.getCart().getId()));

        return "cart";

    }

}
