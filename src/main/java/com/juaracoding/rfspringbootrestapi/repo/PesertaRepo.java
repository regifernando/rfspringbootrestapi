package com.juaracoding.rfspringbootrestapi.repo;

import com.juaracoding.rfspringbootrestapi.model.Peserta;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PesertaRepo extends JpaRepository<Peserta,Long> {


    /*
        SELECT * FROM MstPeserta
        WHERE Nama = 'Aziz';
        SELECT
            *
        FROM
            batch18.MstPeserta peserta0_
        WHERE
            peserta0_.Namax=?

     SELECT * FROM MstPeserta
        WHERE Nama = 'Aziz' AND Batch = 1;
     */
    List<Peserta> findByNamaAndBatch(String strNama, String strBatch);

    /*
        SELECT COUNT(*) FROM MstPeserta
        Where Batch = ?
     */
    Integer countByBatch(String strBatch);
    void deleteByNama(String strNama);
    List<Peserta> findDistinctBatchByBatch(String strBatch);
//    findByNamaAndBatch
//    find
//    By
//    Nama -> nama
//    And -> And
//    Batch -> batch


}