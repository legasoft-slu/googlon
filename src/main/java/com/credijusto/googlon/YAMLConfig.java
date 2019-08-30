/**
 * 
 */
package com.credijusto.googlon;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.credijusto.googlon.bean.Test;

/**
 * @author Rafael León Gómez
 *
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
  
	/**
	 * The test of YAML config
	 */
    private Test test;

	/**
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}
 
    // standard getters and setters
 
}
