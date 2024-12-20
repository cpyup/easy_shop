package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProfileDao;
import org.yearup.data.UserDao;
import org.yearup.models.Profile;
import org.yearup.models.User;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/profile")
@PreAuthorize("isAuthenticated()")
public class ProfileController {
    private final ProfileDao profileDao;
    private final UserDao userDao;

    @Autowired
    public ProfileController(ProfileDao profileDao, UserDao userDao) {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }

    @GetMapping
    public Profile getByUserId(Principal principal){
        try{
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);

            if (user == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
            }
            int userId = user.getId();
            return profileDao.getByUserId(userId);
        }catch(Exception e){
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while retrieving the profile. Please try again later.");
        }
    }

    @PutMapping
    public void updateProfile(Principal principal, @RequestBody Profile profile){
        try{
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);

            if (user == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
            }
            int userId = user.getId();
            profileDao.update(userId, profile);
        }catch(Exception e){
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while updating the profile. Please try again later.");
        }
    }
}
