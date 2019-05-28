package com.example.projectm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface itemrepo extends CrudRepository<items, String> {

    List<items> findAll();

}