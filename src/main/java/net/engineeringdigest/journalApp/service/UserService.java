package net.engineeringdigest.journalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 
import net.engineeringdigest.journalApp.entity.User;
 
import net.engineeringdigest.journalApp.repository.UserRepository;

@Component
public class UserService {//service section is always for Business logic
    @Autowired
    private UserRepository userRepository;//dependency injection
    
    
    public void saveEntry(User user)
    {
        userRepository.save(user);//.save from the interface
    }

    public List<User>getAll()
    {
        return userRepository.findAll();//.findAll from the interface
    }


    public Optional<User>findById(ObjectId id)//Optonal is a container object which may or may not contain a non-null value and we cannot directly return value from it
    {
        return userRepository.findById(id);
    }


    public void deleteById(ObjectId id)
    {
        userRepository.deleteById(id);
    }


    public User findByUserName(String userName)//this method is used to find a user by username in the database and is related to the UserR
    {
        return userRepository.findByUserName(userName);
    }


    //controller--->service--->repository 
}
