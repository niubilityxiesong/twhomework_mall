package com.tw_mall.Mall.controller;


import com.tw_mall.Mall.model.Commodity;
import com.tw_mall.Mall.service.LocalMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MallController {

    @Autowired
    private LocalMallService localMallService;

    @GetMapping("/test")
    public String testController(){
        return "success";
    }

    @GetMapping("/commodities")
    public List<String> displayList(){
        return localMallService.displayAll();
    }

    @GetMapping("/commodities/{id}")
    public Commodity displayDetails(@PathVariable int id){
        return localMallService.displayDetail(id - 1);
    }

    @PostMapping("/commodities")
    public Commodity add(@RequestBody Commodity commodity){
        return localMallService.addCommodity(commodity);
    }

    @PutMapping("/commodities/{id}")
    public Commodity update(@PathVariable int id,@RequestBody Commodity commodity){
        return localMallService.exchangeCommodity(id, commodity);
    }

    @GetMapping("/commodities/choice")
    public List<Commodity> choiceCommodity(@RequestParam int low,@RequestParam int high,@RequestParam String brand,@RequestParam String classification){
        return localMallService.choiceCommodity(low, high, brand, classification);
    }

    @GetMapping("/commodities/sort")
    public List<Commodity> sortCommodity(@RequestParam String order){
        return localMallService.sortCommodities(order);
    }

    @GetMapping("/commodities/page")
    public List<Commodity> pageCommodity(){
        return null;
    }
}
