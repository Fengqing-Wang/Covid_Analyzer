package edu.upenn.cit594.processor;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.upenn.cit594.datamanagement.CovidComparatorr;
import edu.upenn.cit594.datamanagement.CovidReader;
import edu.upenn.cit594.datamanagement.PopulationReader;
import edu.upenn.cit594.datamanagement.PropertiesReader;
import edu.upenn.cit594.util.Covid;
import edu.upenn.cit594.util.Population;


public class Processor {
	
	private List<String> dataset;
	private PopulationReader popReader;
	private PropertiesReader proReader;
	private CovidReader covidReader;
	
    /*
     * para@ dataset: input dataset from Main args[]
     */
	public Processor(List<String> dataset) {
		Collections.sort(dataset);
		this.dataset = dataset;
	}
	
	/* Show the total population for all ZIP Codes (subsection 3.2). */
	public void PrintDataset() {
		System.out.println("-----BEGIN OUTPUT-----");
		for(int i = 0; i < dataset.size(); i++) {
			System.out.println(dataset.get(i));
		}
		System.out.println("-----END OUTPUT-----");
		System.out.println("                    ");
		System.out.println("                    ");
	}
	
	/* 2. Show the total population for all ZIP Codes (subsection 3.2). */
	public void PrintTotalPop() {
		List<Population> pop = popReader.getAllpop();
		int total = 0;
		for(Population p : pop) {
			total+=p.getPopulation();
		}
		System.out.println("-----BEGIN OUTPUT-----");
		System.out.println(total);
		System.out.println("-----END OUTPUT-----");
		System.out.println("                    ");
		System.out.println("                    ");
	}
	
	
	/* Check the input date*/
	public boolean checkdata(String date) {
		List<Covid> covids;
		if(CovidComparatorr.compare(covidReader.getFilename())) {
			covids = covidReader.getAllcovid_csv();
		}else {
			covids = covidReader.getAllcovid_json();
		}
		
		for(Covid c: covids) {
			if(c.getTime().equals(date)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	/* 3. Show the total vaccinations per capita for each ZIP Code for the specified date (subsection 3.3). */
	public void PrintVaccination(String choice, String data) {
		
		List<Covid> covids;
		if(CovidComparatorr.compare(covidReader.getFilename())) {
			covids = covidReader.getAllcovid_csv();
		}else {
			covids = covidReader.getAllcovid_json();
		}
		
		List<Population> pop = new ArrayList<Population>();
		
		try {
			pop = popReader.getAllpop();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String,Integer> population = new HashMap<String,Integer>();
		
		for(Population p:pop) {
			population.put(p.getZip_code(), p.getPopulation());
		}
		
		
		System.out.println("-----BEGIN OUTPUT-----");
		
		if(choice.equals("full")) {
			for(Covid c:covids) {
				if(c.getTime().equals(data) && c.getFully_vaccinated()!=0 && population.containsKey(c.getZipCode())) {
					System.out.println(c.getZipCode()+" "+String.format("%.4f", ((double) c.getFully_vaccinated()/(double)population.get(c.getZipCode()))));
				}
			}	
		}else if (choice.equals("partial")) {
			for(Covid c:covids) {
				if(c.getTime().equals(data) && c.getPartially_vaccinated()!=0 && population.containsKey(c.getZipCode())) {
					System.out.println(c.getZipCode()+" "+String.format("%.4f", ((double) c.getPartially_vaccinated()/(double)population.get(c.getZipCode()))));
				}
			}
		}
		System.out.println("-----END OUTPUT-----");
		System.out.println("                    ");
		System.out.println("                    ");
		
		
	}
	
	/* methods to set Reader of input files*/
	public void setPopReader(PopulationReader popReader) {
		this.popReader = popReader;
	}

	public void setProReader(PropertiesReader proReader) {
		this.proReader = proReader;
	}

	public void setCovidReader(CovidReader covidReader) {
		this.covidReader = covidReader;
	}
	
	

}
