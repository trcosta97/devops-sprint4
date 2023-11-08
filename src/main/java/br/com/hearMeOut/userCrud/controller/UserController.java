package br.com.hearMeOut.userCrud.controller;

import br.com.hearMeOut.userCrud.domain.address.Address;
import br.com.hearMeOut.userCrud.domain.address.AddressRepository;
import br.com.hearMeOut.userCrud.domain.user.User;
import br.com.hearMeOut.userCrud.domain.user.UserRepository;
import br.com.hearMeOut.userCrud.domain.user.UserSignInData;
import br.com.hearMeOut.userCrud.domain.user.UserUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/post")
    public ResponseEntity cadastro(@RequestBody UserSignInData data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        var address = new Address(data.address());

        Address savedAddress = addressRepository.save(address);
        user.setAddress(savedAddress);

        User savedUser = userRepository.save(user);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).body(savedUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        var optionalUser = userRepository.findByIdAndStatusTrue(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return ResponseEntity.ok(user);
        }
        return null;
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers(){
        var allUsers = userRepository.findAllByStatusTrue();
        return ResponseEntity.ok(allUsers);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserUpdateData data){
        var user = new User(data);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User updatedUser = optionalUser.get();
            if(data.password() != null){
                updatedUser.setPassword(data.password());
            }
            if(data.email() != null){
                updatedUser.setEmail(data.email());
            }
            return ResponseEntity.ok(updatedUser);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User deletedUser = optionalUser.get();
            deletedUser.setStatus(false);
            userRepository.save(deletedUser);
            return ResponseEntity.ok(deletedUser);
        }
        return null;
    }
}
