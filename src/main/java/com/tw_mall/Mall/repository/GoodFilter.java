//package com.tw_mall.Mall.repository;
//
//
//import com.tw_mall.Mall.model.Commodity;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//@Repository
//public class GoodFilter{
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//    CriteriaQuery<Commodity> query = criteriaBuilder.createQuery(Commodity.class);
//    Root root = query.from(Commodity.class);
//
//
//}
