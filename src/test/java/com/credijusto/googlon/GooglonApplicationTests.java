package com.credijusto.googlon;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.credijusto.googlon.controllers.GooglonController;

/**
 * @author Rafael León Gómez
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GooglonApplicationTests {

    @Autowired
    private YAMLConfig testConfig;
	
	private GooglonController googlonController;
	
	private String inputTextA, inputTextB, inputTextC, inputTextD, inputTextE;
	private String outputTextA, outputTextB, outputTextC, outputTextD, outputTextE;
	
	@Before
    public void setUp() throws Exception {
		
		googlonController = new GooglonController();
		
		inputTextA = testConfig.getTest().getInput().getTextA();
		inputTextB = testConfig.getTest().getInput().getTextB();
		inputTextC = testConfig.getTest().getInput().getTextC();
		inputTextD = testConfig.getTest().getInput().getTextD();
		inputTextE = testConfig.getTest().getInput().getTextE();
		
		outputTextA = testConfig.getTest().getOutput().getTextA();
		outputTextB = testConfig.getTest().getOutput().getTextB();
		outputTextC = testConfig.getTest().getOutput().getTextC();
		outputTextD = testConfig.getTest().getOutput().getTextD();		
		outputTextE = testConfig.getTest().getOutput().getTextE();
		
	}
	
	@Test
	public void testTextA() {
		assertEquals(googlonController.googlon(inputTextA), outputTextA);
	}
	
	@Test
	public void testTextB() {
		assertEquals(googlonController.googlon(inputTextB), outputTextB);
	}
	
	@Test
	public void testTextC() {
		assertEquals(googlonController.googlon(inputTextC), outputTextC);
	}
	
	@Test
	public void testTextD() {
		assertEquals(googlonController.googlon(inputTextD), outputTextD);
	}

	@Test
	public void testTextE() {
		assertEquals(googlonController.googlon(inputTextE), outputTextE);
	}
	
}
