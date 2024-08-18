package com.jyy.riskctrl.utils.json;

import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = JsonUtilTest.class)
public class JsonUtilTest {

    @DisplayName("Json字符串转Java对象")
    @Test
    public void testJsonStr2Obj() {
        String json = "{\"color\":\"黑色\",\"specs\":\"16GB\"}";

        Product product = JsonUtils.jsonStr2Object(json, Product.class);
        System.out.println(product);
    }


    @DisplayName("Java对象转Json字符串")
    @Test
    public void testObj2JsonStr() {
        Product product = new Product();
        product.setColor("黑色");
        product.setSpecs("16GB");
        String jsonStr = JsonUtils.obj2JsonStr(product);
        System.out.println(jsonStr);
    }

    @DisplayName("Json字符串转指定对象的Map")
    @Test
    public void testJsonStr2Map() {
        String json ="{\"data\":[" +
                "{\"color\":\"黑色\",\"specs\":\"16GB\"}," +
                "{\"color\":\"白色\",\"specs\":\"124GB\"}]}";

        Map<String, List<Product>> map = JsonUtils.jsonStr2Map(json, String.class, Product.class);
        List<Product> products = map.get("data");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    @DisplayName("Json字符串转对象的List")
    @Test
    public void testJsonStr2List() {
        String json = "[" +
                "{\"color\":\"黑色\",\"specs\":\"16GB\"}," +
                "{\"color\":\"白色\",\"specs\":\"124GB\"}" + "]";

        List<Product> products = JsonUtils.jsonStr2List(json, Product.class);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Data
    @ToString
    class Product {
        private String color;
        private String specs;
    }
}
