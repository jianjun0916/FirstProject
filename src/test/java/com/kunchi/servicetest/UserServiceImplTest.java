package com.kunchi.servicetest;

import com.kunchi.Application;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();  //构造MockMvc
    }

    @Test
    public void login() throws Exception {

        //拼接请求参数
        JSONObject param = new JSONObject();

        param.put("pwd", "admin");

        param.put("userName", "admin");

        String JsonStr = param.toString();

        System.out.println("=========请求入参：" + JsonStr);

        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(JsonStr);

        MvcResult mvcResult = mvc.perform(request).andReturn();

        System.out.println("=========请求状态：" + mvcResult.getResponse().getStatus());

        System.out.println("=========返回信息：" + mvcResult.getResponse().getContentAsString());
    }

}