package com.juaracoding.rfspringbootrestapi.service;

import com.juaracoding.rfspringbootrestapi.model.MstUser;
import com.juaracoding.rfspringbootrestapi.model.User;
import com.juaracoding.rfspringbootrestapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class MstUserService implements UserDetailsService {
    private UserRepo userRepo;

    @Autowired
    public MstUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public Object save (MstUser user){

        try{
            userRepo.save(user);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }
        return "Berhasil Disimpan";
    }


    public Object login(MstUser user){

        String userName = user.getUsername();
        Optional<MstUser> opUser = userRepo.findByUsernameOrNoHpOrEmail(userName,userName,userName);
        try{
            if(!opUser.isEmpty())
            {
                MstUser nextUser = opUser.get();
                /*
                    compare password di database
                    apakah sama dengan yang diinput user
                 */
                if(nextUser.getPassword().equals(user.getPassword()))
                {
                    return "Login Berhasil";
                }
                else
                {
                    return "Username dan Password salah";
                }
            }else {
                return "User Tidak Terdaftar !!";
            }
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }
    }



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /*
        WARNING !!
        userName yang ada di parameter belum tentu adalah username...
        karena sistem memperbolehkan login dengan email, nohp ataupun username

            Proses Check ke database
         */
        Optional<MstUser> opUser = userRepo.findByUsernameOrNoHpOrEmail(userName,userName,userName);
        if(opUser.isEmpty())
        {
            return null;
        }
        MstUser userNext = opUser.get();
        return new org.springframework.security.core.userdetails.User(userNext.getUsername(),userNext.getPassword(),new ArrayList<>());
    }
}
