package main.java.com.park.service;

import java.util.List;

import com.park.entity.CarSpace;
import com.park.entity.ParkinglotInfo;
import com.park.vo.ParkingInformation;



public interface ParkingInfoService {
	public List<ParkinglotInfo>getLocalPark(double longitude,double latitude );
	public ParkinglotInfo getParking_Information(String parking_id);
	public List<ParkingInformation>searchParkByName(String parking_name);//根据停车场的名称模糊查找停车场
	public int getEmptyCarSpace(String parking_id);
	public int getCollectUser(String parking_id);
	public List<CarSpace> getAllCarspace(String parking_id);
	

}
