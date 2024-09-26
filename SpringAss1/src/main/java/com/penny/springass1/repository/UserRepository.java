package com.penny.springass1.repository;


import com.penny.springass1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserRepository {

    private static final String URL_PREFIX = "https://jsonplaceholder.typicode.com/users";
    private final RestTemplate restTemplate;

    @Autowired
    public UserRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User[] getUsers(){
        User[] users = restTemplate.getForObject(URL_PREFIX, User[].class);
        return users != null ? users : new User[0];  // 返回空数组而不是 null
    }

    public User getUsersById(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> request = new HttpEntity<>(headers);
        HttpEntity<User> response = restTemplate.exchange(URL_PREFIX + "/" + id, HttpMethod.GET, request, User.class);
        return response.getBody();
    }

    public User creatNewUser(User user){
        User newUser = restTemplate.postForObject(this.URL_PREFIX, user, User.class);
        return newUser != null ? newUser : new User();
    }

    public User updateUserById(Long id, User user){
        HttpEntity<User> updatedUser = new HttpEntity<>(user);
        HttpEntity<User> response = restTemplate.exchange(URL_PREFIX + "/" + id, HttpMethod.PUT, updatedUser, User.class);
        return response.getBody();
    }

    public boolean deleteUserById(Long id){
        restTemplate.delete(URL_PREFIX + "/" + id);
        return true;
    }

}

