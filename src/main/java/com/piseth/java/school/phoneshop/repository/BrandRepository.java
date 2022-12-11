package com.piseth.java.school.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piseth.java.school.phoneshop.model.Brand;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
    boolean existsByName(String name);
    List<Brand> findByIdIn(List<Integer> id);

}
