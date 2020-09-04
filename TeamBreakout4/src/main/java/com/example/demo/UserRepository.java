package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, ObjectId>{

    @Query(value="{ 'username' : ?0}")
    List<User> findUserByUsername(String username);

    @Query(value="{ 'fullname' : ?0}")
    List<User> findUserByFullName(String fullName);

    @Query(value="{ 'username' : ?0}", delete = true)
    void deleteUserByUsername(String username);

}
