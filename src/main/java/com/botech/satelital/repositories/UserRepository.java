package com.botech.satelital.repositories;
import org.springframework.data.repository.CrudRepository;
import com.botech.satelital.models.entities.User;

public interface UserRepository 
extends CrudRepository<User, Long>{

}
