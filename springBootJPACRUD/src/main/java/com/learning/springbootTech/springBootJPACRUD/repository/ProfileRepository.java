package com.learning.springbootTech.springBootJPACRUD.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springbootTech.springBootJPACRUD.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

}