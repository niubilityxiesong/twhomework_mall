package com.tw_mall.Mall.service;

import com.tw_mall.Mall.model.Commodity;
import com.tw_mall.Mall.repository.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalMallService{

    @Autowired
    private MallRepository mallRepository;


    public List<String> displayAll() {
        List<Commodity> commodities = mallRepository.findAll();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < commodities.size(); i++) {
            String productMeg = "";
            productMeg += commodities.get(i).getName();
            productMeg += " 价格：";
            productMeg += commodities.get(i).getPrice();
            productMeg += " 类别：";
            productMeg += commodities.get(i).getClassification();
            productMeg += " 品牌：";
            productMeg += commodities.get(i).getBrand();
            result.add(productMeg);
        }
        return result;
    }


    public Commodity displayDetail(int id) {
        return mallRepository.findAll().get(id);
    }


    public Commodity addCommodity(Commodity commodity) {
        mallRepository.save(commodity);
        return commodity;
    }


    public Commodity exchangeCommodity(int id, Commodity commodity) {
        if(mallRepository.findById(id).isPresent()){
            List<Commodity> commodities = mallRepository.findAll();
            Commodity commodityOne = commodities.get(id - 1);
            commodityOne.setName(commodity.getName());
            commodityOne.setPrice(commodity.getPrice());
            commodityOne.setClassification(commodity.getClassification());
            commodityOne.setBrand(commodity.getBrand());
            commodityOne.setDescribed(commodity.getDescribed());
            commodityOne.setDates(commodity.getDates());
            commodityOne.setPlace(commodity.getPlace());
            mallRepository.save(commodityOne);
        }
        return mallRepository.findAll().get(id - 1);
    }


    public List<Commodity> choiceCommodity(int low, int high, String brand, String classification) {

        List<Commodity> commodities = mallRepository.findAll();
        List<Commodity> result = new ArrayList<>();
        if(low != -1 && high != -1){
            result = commodities.stream().filter(element -> {
                if(element.getPrice() > low && element.getPrice() < high){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }
        else {
            result.addAll(commodities);
        }


        if(!brand.isEmpty()){
            result = result.stream().filter(element -> {
                if (element.getBrand().equals(brand)){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }

        if(!classification.isEmpty()){
            result = result.stream().filter(element -> {
                if(element.getClassification().equals(classification)){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }

        return result;
    }


    public List<Commodity> sortCommodities(String order) {
        Sort sort;
        if(order.equals("ASC")){
            sort = new Sort(Sort.Direction.ASC, "price");
        }
        else{
            sort = new Sort(Sort.Direction.DESC, "price");
        }
        List<Commodity> result = mallRepository.findAll(sort);
        return result;
    }
}
