package com.juaracoding.rfspringbootrestapi.repo;


import com.juaracoding.rfspringbootrestapi.model.MstUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<MstUser, Long> {
    Optional<MstUser> findByUsernameOrNoHpOrEmail(String userName, String noHp, String email);
}

