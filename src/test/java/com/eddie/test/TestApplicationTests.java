package com.eddie.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eddie.test.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TestApplicationTests {
	@Resource
	DemoService demoService;

	@Test
	void contextLoads() {
	}

	@Test
	public void test1(){
		Integer[] arr={2,3};
		System.out.println("Input:"+ JSON.toJSONString(arr));
		List<Integer> t=Arrays.asList(arr);

		List<String> result=demoService.getWords(t);
		System.out.println("Output:"+JSONObject.toJSONString(result));
	}
}
