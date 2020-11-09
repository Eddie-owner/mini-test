package com.eddie.test;

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
		Integer[] arr={3,4};

		List<Integer> t=Arrays.asList(arr);

		List<String> result=demoService.getWords(t);
		System.out.println(JSONObject.toJSONString(result));
	}
}
