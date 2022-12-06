package com.reggie.controller;

import com.reggie.entity.ShoppingCart;
import com.reggie.service.ShoppingCartService;
import com.reggie.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/list")
    public R list(){
        List<ShoppingCart> list = shoppingCartService.list();
        return R.success(list);
    }

}
