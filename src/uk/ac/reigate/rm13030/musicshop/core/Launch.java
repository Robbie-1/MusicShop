package uk.ac.reigate.rm13030.musicshop.core;

import java.util.HashMap;
import java.util.Scanner;

import uk.ac.reigate.rm13030.musicshop.instruments.Guitar;
import uk.ac.reigate.rm13030.musicshop.instruments.Guitar.GuitarType;
import uk.ac.reigate.rm13030.musicshop.instruments.Instrument;
import uk.ac.reigate.rm13030.musicshop.instruments.Keyboard;
import uk.ac.reigate.rm13030.musicshop.instruments.Keyboard.KeyboardType;
import uk.ac.reigate.rm13030.musicshop.instruments.UserInstrument;

public class Launch {
	
	/**
	 * @author Robbie McLeod <rm13030>
	 */

	public static HashMap<Instrument, Integer> instrumentMap = new HashMap<Instrument, Integer>(); 	//instrument, stock
	private static String UI;
	private static Scanner sc = new Scanner(System.in);
	private static boolean isStaff;

	public Launch() {
		loadInstruments();
		login();
		mainMenu(true);
	}
	
	private void login() {
		System.out.println("[Login] Please enter your name:");
		UI = sc.nextLine();
		if (UI.equalsIgnoreCase("Robbie")) {
			isStaff = true;
		}
	}

	private void mainMenu(boolean breakLine) {
		System.out.println((breakLine ? "\n" : "") + "[Main Menu]: Add (A) : Delete (D) : Edit (E) : Reserve (R) : Print (P)");
		UI = sc.nextLine();

		if (UI.equalsIgnoreCase("A")) {
			//a
			if (isStaff)
				addInstrument();
		} else if (UI.equalsIgnoreCase("D")) {
			//d
			if (isStaff)
				deleteInstrument();
		} else if (UI.equalsIgnoreCase("E")) {
			//e
			if (isStaff)
				editInstrument();
		} else if (UI.equalsIgnoreCase("R")) {
			//r
			reserve();
		} else if (UI.equalsIgnoreCase("P")) {
			//p
			print();
		} else {
			System.out.println("Invalid command; please try again.");
			mainMenu(true);
		}
		mainMenu(true);
	}
	
	private void reserve() {
		System.out.println("Please enter the name of the instrument in which you'd like to reserve:");
		UI = sc.nextLine();
		for (Instrument i : instrumentMap.keySet()) {
			if (UI.equalsIgnoreCase(i.getName())) {
				i.setStock((i.getStock()-1));
				System.out.println("Instrument "+UI+" has been reserved successfully!");
			} else {
				System.out.println("Instrument with given name does not exist; returning to main menu...");
			}
		}
	}
	
	private void addInstrument() {
		String[] instrumentData = new String[3];
		System.out.println("Please enter the name of the instrument you wish to add:");
		instrumentData[0] = sc.nextLine();
		System.out.println("Please enter the manufacturer:");
		instrumentData[1] = sc.nextLine();
		System.out.println("Please enter the stock:");
		instrumentData[2] = sc.nextLine();
		
		Instrument in = new UserInstrument(instrumentData[0], instrumentData[1], Integer.valueOf(instrumentData[2]));
		instrumentMap.put(in, in.getStock());
		
		System.out.println("Successfully added "+in.getName()+"!");
	}
	
	private void deleteInstrument() {
		System.out.println("\nPlease enter the name of the instrument you wish to delete:");
		UI = sc.nextLine();
		Instrument i1 = null;
		for (Instrument i : instrumentMap.keySet()) {
			if (i.getName().equalsIgnoreCase(UI)) {
				i1 = i;
				System.out.println(UI+" has been deleted successfully.");
			} else {
				continue;
			}
		}
		instrumentMap.remove(i1);
	}
	
	private void editInstrument() {
		System.out.println("\nPlease enter the name of the instruent you wish to edit:");
		UI = sc.nextLine();
		Instrument in = null;
		for (Instrument i : instrumentMap.keySet()) {
			if (i.getName().equalsIgnoreCase(UI)) {
				in = i;
			} else {
				continue;
			}
		} if (in != null) {
			System.out.println("What would you like to edit? ([N]=Name/[M]=Manufacturer/[S]=Stock)");
			UI = sc.nextLine();
			edit(in, UI.toLowerCase());
		} else {
			System.out.println("Couldn't find the instrument with name '"+UI+"'");
		}
	}
	
	private void edit(Instrument i, String key) {
		System.out.println("Please enter the new value");
		UI = sc.nextLine();
		switch (key) {
			case "n":
				i.setName(UI);
			break;
			
			case "m":
				i.setManufacturer(UI);
			break;
			
			case "s":
				i.setStock(Integer.valueOf(UI));
			break;
			
			default:
				System.out.println("Key unrecognized, restarting edit process...");
				editInstrument();
			break;
		}
		System.out.println(i.getName()+" has been updated!");
		print();
	}

	private void loadInstruments() {
		new Guitar("Guitar1", "GuitarManufacturer", 10, GuitarType.ACOUSTIC, 5, false);
		new Keyboard("Keyboard1", "KeyboardManufacturer", 52, KeyboardType.SYNTHESIZER);
		//print();
	}
	
	private void print() {
		for (Instrument i: instrumentMap.keySet()) {
			System.out.println("[<*>] Name - " + i.getName() + " : Manufacturer - " + i.getManufacturer() + " : Stock - " + i.getStock());
		}
	}

	public static void main(String args[]) {
		new Launch();
	}

}