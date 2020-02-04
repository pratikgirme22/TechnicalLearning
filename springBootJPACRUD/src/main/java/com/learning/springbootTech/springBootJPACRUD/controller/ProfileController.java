package com.learning.springbootTech.springBootJPACRUD.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springbootTech.springBootJPACRUD.exception.ResourceNotFoundException;
import com.learning.springbootTech.springBootJPACRUD.model.Profile;
import com.learning.springbootTech.springBootJPACRUD.repository.ProfileRepository;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProfileController {
    @Autowired
    private ProfileRepository ProfileRepository;

    @GetMapping("/Profiles")
    public List<Profile> getAllProfiles() {
        return ProfileRepository.findAll();
    }

    @GetMapping("/Profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable(value = "id") Long ProfileId)
        throws ResourceNotFoundException {
        Profile Profile = ProfileRepository.findById(ProfileId)
          .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + ProfileId));
        return ResponseEntity.ok().body(Profile);
    }
    
    @PostMapping("/Profiles")
    public Profile createProfile(@Valid @RequestBody Profile Profile) {
        return ProfileRepository.save(Profile);
    }

    @PutMapping("/Profiles/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Long ProfileId,
         @Valid @RequestBody Profile ProfileDetails) throws ResourceNotFoundException {
        Profile Profile = ProfileRepository.findById(ProfileId)
        .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + ProfileId));

        Profile.setEmailId(ProfileDetails.getEmailId());
        Profile.setLastName(ProfileDetails.getLastName());
        Profile.setFirstName(ProfileDetails.getFirstName());
        final Profile updatedProfile = ProfileRepository.save(Profile);
        return ResponseEntity.ok(updatedProfile);
    }

    @DeleteMapping("/Profiles/{id}")
    public Map<String, Boolean> deleteProfile(@PathVariable(value = "id") Long ProfileId)
         throws ResourceNotFoundException {
        Profile Profile = ProfileRepository.findById(ProfileId)
       .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + ProfileId));

        ProfileRepository.delete(Profile);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}