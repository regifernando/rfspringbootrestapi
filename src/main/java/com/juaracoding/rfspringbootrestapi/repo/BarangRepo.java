package com.juaracoding.rfspringbootrestapi.repo;

import com.juaracoding.rfspringbootrestapi.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepo extends JpaRepository<Barang,Long> {
}
