package com.example.projectm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface supprepo extends CrudRepository<supplier, String> {

    List<supplier> findAll();

}