package org.example.dao;

import org.example.enity.Bpi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface BpiDao extends CrudRepository<Bpi, Integer> {

    /*
    @Modifying
    @Transactional
    @Query("delete from BPI b where b.code=?1")
    */
    @Modifying
    @Transactional
    int deleteBpiByCode( String code) ;

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO BPI(code, symbol, rate, description, rate_float, update_Time) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    int insertBpi(String code, String symbol, String rate, String description, double rateFloat, Date updateTime);

    @Transactional
    @Modifying
    @Query(value = "UPDATE BPI b set symbol =:symbol , rate =:rate, description =:description, rate_float =:rate_float, update_Time =:updateTime  " +
            "where b.code = :code",
            nativeQuery = true)
    void updateBpiByCode(@Param("code") String code, @Param("symbol") String symbol, @Param("rate") String rate,
                    @Param("description") String description, @Param("rate_float") double rate_float, Date updateTime);

    @Query(value = "SELECT * FROM bpi", nativeQuery = true)
    List<Bpi> getAllBpi();

    Bpi getBpiByCode(String code);

}
