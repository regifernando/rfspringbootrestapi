package com.juaracoding.rfspringbootrestapi.repo;

import com.juaracoding.rfspringbootrestapi.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,Long> {

}
