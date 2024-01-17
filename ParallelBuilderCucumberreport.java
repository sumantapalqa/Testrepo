package com.api.automation;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner.Builder;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ParallelBuilderCucumberreport 
{

	@Test
	public void executeKarateTest() 
	{
		Builder aRunner = new Builder();
		Results result = aRunner.path("classpath:com/api/automation").parallel(5);
		System.out.println("Total feature =" + result.getFeaturesTotal());
		System.out.println("Total Scenarios =" + result.getScenariosTotal());
		System.out.println("Passed scenarios=" + result.getScenariosPassed());
		generateCucumberReport(result.getReportDir());
		
		// Assertion (Based on this the Test method will mark as Pass or failed
		
		Assertions.assertEquals(0, result.getFailCount(), "There are some failed scenarios");
		
		
	}
	
	// report dir location >> D:\KARATE\AllPrograms\karateframework\target\karate-reports
	private void generateCucumberReport(String reportDirLocation) {
		File reportoutputdir = new File(reportDirLocation);
		Collection<File> jsoncollection = FileUtils.listFiles(reportoutputdir, new String[] {"json"}, true);
		
		List<String> jsonfiles = new ArrayList<String>();
		jsoncollection.forEach(file -> jsonfiles.add(file.getAbsolutePath()));
		
		Configuration configuration = new Configuration(reportoutputdir, "Karate Report");
		ReportBuilder reportBuilder = new ReportBuilder(jsonfiles,configuration);
		reportBuilder.generateReports();
				
		
	}
	
	
}
