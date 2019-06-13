package com.example.projectm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface userrepo extends CrudRepository<user, String> {

    List<user> findAll();


    @Query("SELECT o FROM user o WHERE o.user_name=:#{#uname}")
    user getUser(@Param("uname") String uname);

    

}