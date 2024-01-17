package com.api.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner.Builder;

public class ParallelBuilder 
{

	@Test
	public void executeKarateTest() 
	{
		Builder aRunner = new Builder();
		Results result = aRunner.path("classpath:com/api/automation").parallel(5);
		System.out.println("Total feature =" + result.getFeaturesTotal());
		System.out.println("Total Scenarios =" + result.getScenariosTotal());
		System.out.println("Passed scenarios=" + result.getScenariosPassed());
		
		// Assertion (Based on this the Test method will mark as Pass or failed
		
		Assertions.assertEquals(0, result.getFailCount(), "There are some failed scenarios");
		
		
	}
	
	
	
}
