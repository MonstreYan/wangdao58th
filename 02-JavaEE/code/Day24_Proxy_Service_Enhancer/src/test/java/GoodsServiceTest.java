import com.cskaoyan.market.db.domain.MarketGoods;
import com.cskaoyan.market.db.domain.MarketGoodsAttribute;
import com.cskaoyan.market.db.domain.MarketGoodsProduct;
import com.cskaoyan.market.db.domain.MarketGoodsSpecification;
import com.cskaoyan.market.preview.DynamicProxyUtils;
import com.cskaoyan.market.service.MarketGoodsService;
import com.cskaoyan.market.service.MarketGoodsServiceImpl;
import com.cskaoyan.market.util.MapperEnhancerProxyUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/10 15:13
 * @Version 1.0
 */
public class GoodsServiceTest {


    @Test
    public void testList(){
        MarketGoodsService target = new MarketGoodsServiceImpl();
        MarketGoodsService proxy = (MarketGoodsService) MapperEnhancerProxyUtils.getProxyInstance(target);

        List<MarketGoods> marketGoods = proxy.list(1, 20, "add_time", "desc", null, null, null);
        System.out.println(marketGoods.size());
        for (MarketGoods marketGood : marketGoods) {
            System.out.println(marketGood);
        }
    }

    @Test
    public void testInsert(){
        MarketGoodsService target = new MarketGoodsServiceImpl();
        MarketGoodsService proxy = (MarketGoodsService) MapperEnhancerProxyUtils.getProxyInstance(target);

        MarketGoods marketGoods = new MarketGoods();
        marketGoods.setDeleted(false);
        marketGoods.setName("iphone15");

        //相当于在controller里面接收数据s
        List<MarketGoodsSpecification> specifications = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MarketGoodsSpecification sp = new MarketGoodsSpecification();
            sp.setDeleted(false);
            sp.setSpecification("256GB");
            specifications.add(sp);
        }

        List<MarketGoodsProduct> products = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MarketGoodsProduct pro = new MarketGoodsProduct();
            pro.setPrice(new BigDecimal(Math.random() * 100));
            pro.setSpecifications(new String[]{"abc", "def"});
            pro.setDeleted(false);
            products.add(pro);
        }

        List<MarketGoodsAttribute> attributes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MarketGoodsAttribute attribute = new MarketGoodsAttribute();
            attribute.setValue("aaaa");
            attribute.setAttribute("key");
            attributes.add(attribute);
        }
        proxy.create(marketGoods, specifications, products, attributes);
    }
}
