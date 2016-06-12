package uk.ac.reigate.rm13030.musicshop.instruments;

import uk.ac.reigate.rm13030.musicshop.core.Launch;

public class UserInstrument implements Instrument {
	
	/**
	 * @author Robbie McLeod <rm13030>
	 */
	
	String name;
	String manufacturer;
	int stock;
	
	public UserInstrument(String name, String manufacturer, int stock) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.stock = stock;
		
		if (stock > 0) {
			Launch.instrumentMap.put(this, stock);
		}
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public int getStock() {
		return stock;
	}

	@Override
	public void setStock(int stock) {
		this.stock = stock;
		Launch.instrumentMap.put(this, stock);
	}

	@Override
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	

}
