package com.example.comtrade.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.comtrade.entity.Hello;

public interface HelloRepository extends CrudRepository<Hello, Long>{
	
	  @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Hello p WHERE p.language = :language")
	  List<Hello> findByLanguage(String language);
	
}
