package com.jyy.riskctrl.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
   Junit4 需要RunWith(SpringRunner.class)
   Junit5用@extendwith(SpringExtension.class)代替了RunWith()
   @SpringBootTest包含了@extendwith(SpringExtension.class)

 */

/*
  @SpringBootTest默认去寻找Spring的启动类
  就是被@SpringBootApplication修饰的启动类

 */

/*

 */

// 指定启动类为当前类
//@SpringBootTest(classes = ApiTest.class)
@SpringBootTest(classes = Application.class)
// 启动方法优先级，需要配合@Order来来使用
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class ApiTest {

    @Autowired
    private MockMvc mockMvc;


    // 测试展示的名称
    @DisplayName("测试Hello")
    @Test
    @Order(2)
    public void testHello() {
        System.out.println("testHello: order 2");
    }

    @DisplayName("测试Hello1")
    @Test
    @Order(1)
    public void testHello1() {
        System.out.println("testHello: order 1");
    }


    // 每个测试方法运行前，都会运行该方法
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @DisplayName("mock mvc test")
    @Test
    @Order(3)
    public void testMockMvc() throws Exception {
        MvcResult result  = mockMvc.perform(
                        post(
                                "/hello/test"
                        ).contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                // 断言
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}
