package cn.tx.controller;

import cn.tx.entity.Result;
import cn.tx.groupEntity.Goods;
import cn.tx.service.GoodsService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    /**
     * 保存商品
     * @param goods
     * @return
     */
    @RequestMapping("/save")
    public Result save(@RequestBody Goods goods){
        try {
            System.out.println(goods);
            // 获取到当前登录的商家id
            String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
            // 设置商家的id
            goods.getTbGoods().setSellerId(sellerId);
            System.out.println(goods);
            // 保存
            goodsService.add(goods);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

}
