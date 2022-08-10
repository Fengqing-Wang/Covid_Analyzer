package edu.upenn.cit594.processor;

import java.util.Collections;
import java.util.List;

import edu.upenn.cit594.datamanagement.CovidReader;
import edu.upenn.cit594.datamanagement.PopulationReader;
import edu.upenn.cit594.datamanagement.PropertiesReader;
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
		System.out.println(total);
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
