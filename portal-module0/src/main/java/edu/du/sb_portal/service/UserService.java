package edu.du.sb_portal.service;

import edu.du.sb_portal.entity.User;
import edu.du.sb_portal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if(userRepository.existsById(user.getId())) {
            return null;
        }
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

}
