package com.juaracoding.rfspringbootrestapi.repo;

import com.juaracoding.rfspringbootrestapi.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepo extends JpaRepository<Menu,Long> {
}
