package main.java.com.park.service;

import com.park.entity.CarSpace;

public interface CarspaceService {
	
	public boolean reserveCarspace(CarSpace car);
	
	public int checkCarspace(CarSpace car);
	
	public String parkCarspace(CarSpace car);
	
	public boolean takeCarspace(CarSpace car);

}
