package ba.zenica.Webshop.service;

import ba.zenica.Webshop.domain.User;
import ba.zenica.Webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer id){
        return userRepository.findAllById(id);
    }
    public User findUserByUsername(String username){
        return userRepository.findByUserName(username);
    }


}
