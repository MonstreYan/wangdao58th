package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.bo.AddGoodsBo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 15:09
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/goods")
public class AdminGoodsController {

    /**
     * {
     * 	"goods": {
     * 		"picUrl": "http://39.101.189.16:8083/wx/storage/fetch/i8eloy9uou6au25pgj3y.png",
     * 		"gallery": ["http://39.101.189.16:8083/wx/storage/fetch/lhcazrdar3g69q32trjx.png"],
     * 		"isHot": true,
     * 		"isNew": true,
     * 		"isOnSale": true,
     * 		"goodsSn": "1365478",
     * 		"name": "iphone16",
     * 		"counterPrice": "5999",
     * 		"unit": "件",
     * 		"keywords": "新款iphone",
     * 		"categoryId": 1005007,
     * 		"brandId": 1001008,
     * 		"brief": "新款iphone16",
     * 		"detail": "阿达是的"
     * 	    },
     * 	"specifications": [{
     * 		"specification": "容量",
     * 		"value": "256GB",
     * 		"picUrl": ""
     *    }, {
     * 		"specification": "容量",
     * 		"value": "512GB",
     * 		"picUrl": ""
     *    }, {
     * 		"specification": "颜色",
     * 		"value": "黑色",
     * 		"picUrl": ""
     *    }, {
     * 		"specification": "颜色",
     * 		"value": "白色",
     * 		"picUrl": ""
     *    }],
     * 	"products": [{
     * 		"id": 0,
     * 		"specifications": ["256GB", "黑色"],
     * 		"price": "5999",
     * 		"number": "100",
     * 		"url": ""
     *    }, {
     * 		"id": 1,
     * 		"specifications": ["256GB", "白色"],
     * 		"price": "6299",
     * 		"number": "100",
     * 		"url": ""
     *    }, {
     * 		"id": 2,
     * 		"specifications": ["512GB", "黑色"],
     * 		"price": "7999",
     * 		"number": "100",
     * 		"url": ""
     *    }, {
     * 		"id": 3,
     * 		"specifications": ["512GB", "白色"],
     * 		"price": "8999",
     * 		"number": "190",
     * 		"url": ""
     *    }],
     * 	"attributes": [{
     * 		"attribute": "网络",
     * 		"value": "全网通5G"
     *    }, {
     * 		"attribute": "生产地址",
     * 		"value": "中国大陆"
     *    }]
     * }
     * @return
     */
    @PostMapping("create")
    public Object create(@RequestBody AddGoodsBo addGoodsBo){
        System.out.println(addGoodsBo);
        return null;
    }
}
