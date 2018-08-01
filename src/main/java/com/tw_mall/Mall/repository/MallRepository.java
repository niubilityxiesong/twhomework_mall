package com.tw_mall.Mall.repository;


import com.tw_mall.Mall.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallRepository extends JpaRepository<Commodity, Integer> {
}
