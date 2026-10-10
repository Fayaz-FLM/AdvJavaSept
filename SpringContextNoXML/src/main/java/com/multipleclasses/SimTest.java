package com.multipleclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("test")
public class SimTest {
	
	@Autowired
	Sim sim;
	
	@Autowired
	@Qualifier("jio")
	Sim sim2;
	
	public void test() {
		sim.call();
		sim2.call();
	}

}
