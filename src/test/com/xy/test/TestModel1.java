package com.xy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-*.xml"})
public class TestModel1 {

//	@Resource(name="modelService")
//	private IModelService modelService;
//	
//	@Test
//	public void testSaveModel(){
//		Model1 model1 = new Model1();
//		model1.setTname("test1");
//		model1.setTdate("2014-04-27");
//		modelService.addModel(model1);
//	}
	
}
