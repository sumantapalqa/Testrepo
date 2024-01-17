package com.api.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner.Builder;

public class ParallelRunnerwithTags 
{

	@Test
	public void executeKarateTest() 
	{
		Builder aRunner = new Builder();
		aRunner.path("classpath:com/api/automation");
		aRunner.tags("@regression, @smoke");
		aRunner.parallel(5);
		
		
		
		
	}
	
	
}
