package edu.upenn.cit594.ui;

import java.util.Scanner;

import edu.upenn.cit594.processor.Processor;

public class Ui {
	
	private Processor processor;
	
	public Ui(Processor processor) {
		this.processor = processor;
		start();
	}

	private void start() {
		boolean start = true;
		
		while(start) {
			showmenu();
			
			String input = null;
	        Scanner scan = new Scanner(System.in);
	        
	        	input = scan.nextLine();
	        	switch(input) {
	        	case "0":
	        		start = false;
	        		break;
	        	case "1":
	        		processor.PrintDataset();
	        		break;
	        	case "2":
	        		processor.PrintTotalPop();
	        		break;
	        	case "3":
	        		System.out.println("Wait to implement");
	        		break;
	        	case "4":
	        		System.out.println("Wait to implement");
	        		break;
	        	case "5":
	        		System.out.println("Wait to implement");
	        		break;
	        	case "6":
	        		System.out.println("Wait to implement");
	        		break;
	        }
			
		}
	}
		
        
	
	private void showmenu() {
		System.out.println("0. Exit the program.");
        System.out.println("1. Show the available data sets.");
        System.out.println("2. Show the total population for all ZIP Codes.");
        System.out.println("3. Show the total vaccinations per capita for each ZIP Code for the specified date.");
        System.out.println("4. Show the average market value for properties in a specified ZIP Code.");
        System.out.println("5. Show the average total livable area for properties in a specified ZIP Code.");
        System.out.println("6. Show the total market value of properties, per capita, for a specified ZIP Code.");
        System.out.println("7. Show the results of your custom feature.");
	}
	
	}


