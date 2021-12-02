package com.upm.prof.a.services;

import com.upm.prof.a.persistence.User;
import com.upm.prof.a.repository.UserRepo;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidKeyException;
import java.util.NoSuchElementException;


public class LogService {

    @Autowired
    private UserRepo userRepo;

    public long getIdActualUser(String userName)  {
        long id = 0;

        id =  userRepo.findByUserName(userName).getId();

       return id;
    }


    public boolean correctLogin (String userName, String password) throws NotFoundException {
       boolean correctCredentials = false;
       User user = userRepo.findByUserName(userName);

       if (null != user.getUsername()) {
           if (user.getPassword().equals(password))
               return true;
       } else {
           throw new NoSuchElementException("You have to SignUp before using our services");
       }
       return correctCredentials;
    }

    public boolean addUser (Long id, String userName, String password, String email) {
        boolean add = true;
        User user = new User();

        if(null != userRepo.findByUserName(userName).getUsername()) {
            add = false;
        } else if(null != userRepo.findByEmail(email).getUsername()) {
            add = false;
        }
        user.setId(id);
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);

        return add;
    }
}
