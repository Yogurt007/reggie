package com.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reggie.entity.Setmeal;
import com.reggie.service.SetmealService;
import com.reggie.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    @GetMapping("/page")
    public R page(int page, int pageSize){
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        setmealService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    @PostMapping
    public R save(@RequestBody Setmeal setmeal){
        log.info("添加套餐：{}",setmeal);
        setmealService.save(setmeal);
        return R.success("添加套餐成功");
    }

    @DeleteMapping
    public R delete(Long id){
        log.info("要删除的套餐：{}",id);
        setmealService.removeById(id);
        return R.success("删除套餐成功");
    }

    @PutMapping
    public R update(@RequestBody Setmeal setmeal){
        log.info("更新套餐：{}",setmeal);
        setmealService.updateById(setmeal);
        return R.success("更新套餐成功");
    }

}
