package uk.ac.reigate.rm13030.musicshop.instruments;

import uk.ac.reigate.rm13030.musicshop.core.Launch;

public class Guitar implements Instrument {
	
	/**
	 * @author Robbie McLeod <rm13030>
	 */
	
	private String name;
	private String manufacturer;
	private GuitarType guitarType;
	private int numberOfFrets;
	private boolean hasStrapPin;

	private int stock;
	
	public Guitar(String name, String manufacturer, int stock, GuitarType guitarType, int numberOfFrets, boolean hasStrapPin) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.guitarType = guitarType;
		this.numberOfFrets = numberOfFrets;
		this.hasStrapPin = hasStrapPin;
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
	public void setStock(int stock) {
		this.stock = stock;
		Launch.instrumentMap.put(this, stock);
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public GuitarType getGuitarType() {
		return guitarType;
	}

	public int getFrets() {
		return numberOfFrets;
	}

	public boolean hasStrapPin() {
		return hasStrapPin;
	}
	
	public void setStrapPin(boolean hasStrapPin) {
		this.hasStrapPin = hasStrapPin;
	}

	public void setGuitarType(GuitarType guitarType) {
		this.guitarType = guitarType;
	}

	public void setFrets(int numberOfFrets) {
		this.numberOfFrets = numberOfFrets;
	}

	public enum GuitarType {
		ACOUSTIC,
		ELECTRIC;
	}

}
