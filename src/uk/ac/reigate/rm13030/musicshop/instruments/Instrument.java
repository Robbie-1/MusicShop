package uk.ac.reigate.rm13030.musicshop.instruments;

public interface Instrument {
	
	/**
	 * @author Robbie McLeod <rm13030>
	 */
	
	/*
	 * Every class that implements Instrument must have a given name, manufacturer and stock
	 */
	
	public String getName();
	
	public String getManufacturer();
	
	public int getStock();
	
	public void setStock(int stock);
	
	public void setManufacturer(String manufacturer);
	
	public void setName(String name);

}
