package edu.upenn.cit594;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.upenn.cit594.datamanagement.PopulationReader;
import edu.upenn.cit594.processor.Processor;
import edu.upenn.cit594.util.Population;

public class TestforFun {
	
	public static void main(String[] args) {
		String rr = "--properties=house_hunting_info.csv"; 
		String pattern = "^--(?<name>.+?)=(?<value>.+)$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(rr);
		
		
		if(m.find()) {
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		
		 else {
	         System.out.println("NO MATCH");
	      }
		
		List<Population> Pops = new ArrayList<Population>();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("population.csv"),"UTF-8"));
			int interation = 0;
		    while((line = br.readLine())!= null) {
		    	if(interation == 0) {
		    		interation++;
		    		continue;
		    	}
		    	 String[] data = line.split(",");
		    	 for(String a:data) {
		    		 System.out.println(a);
		    		 System.out.println(a.getClass());
		    	 }
			     
			}	
		}
		catch(Exception e) {
			throw new IllegalStateException(e);
		}
		
		
		
		
		
		
	}

}



