package uk.ac.reigate.rm13030.musicshop.instruments;

import uk.ac.reigate.rm13030.musicshop.core.Launch;

public class Keyboard implements Instrument {
	
	/**
	 * @author Robbie McLeod <rm13030>
	 */
	
	private String name;
	private String manufacturer;
	private int stock;
	private KeyboardType keyboardType;
	
	public Keyboard(String name, String manufacturer, int stock, KeyboardType keyboardType) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.keyboardType = keyboardType;
		this.stock = stock;
		
		if (stock > 0) {
			Launch.instrumentMap.put(this, stock);
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getManufacturer() {
		return manufacturer;
	}
	
	@Override
	public int getStock() {
		return stock;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setKeyboardType(KeyboardType keyboardType) {
		this.keyboardType = keyboardType;
	}
	
	public KeyboardType getKeyboardType() {
		return keyboardType;
	}

	public enum KeyboardType {
		PIANO,
		ORGAN,
		SYNTHESIZER,
		CELESTA,
		CARILLON;
	}

	@Override
	public void setStock(int stock) {
		this.stock = stock;
		Launch.instrumentMap.put(this, stock);
	}

}
