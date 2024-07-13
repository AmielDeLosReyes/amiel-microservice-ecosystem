package com.user_service.servicefacade;

//import com.user_service.rest.model.UsersEntity;
//import com.user_service.rest.repository.UsersRepository;
//import com.user_service.rest.request.UserLoginRequestData;
//import com.user_service.rest.request.UserRegisterRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade{

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

//    @Autowired
//    private UsersRepository usersRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public String callSampleService() {
        try {
            String url = "http://sample-service/sample/test";
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return "Error calling sample service: " + e.getMessage();
        }
    }
//
//    @Override
//    public UsersEntity registerUser(UserRegisterRequestData userRegisterRequestData) {
//        // Check if user already exists
//        if (usersRepository.findByUsername(userRegisterRequestData.getUsername()) != null) {
//            throw new RuntimeException("User already exists");
//        }
//
//        // Encode the password
//        String encodedPassword = passwordEncoder.encode(userRegisterRequestData.getPassword());
//
//        // Create new user entity
//        UsersEntity newUser = new UsersEntity();
//        newUser.setUsername(userRegisterRequestData.getUsername());
//        newUser.setPassword(encodedPassword);
//
//        // Save the user to the database
//        return usersRepository.save(newUser);
//    }

}
