package main.java.com.park.dao;


import org.springframework.stereotype.Repository;


import main.java.com.park.entity.CarSpace;

@Repository
public interface CarspaceDao {
	
	/*车位状态：-1:坏车位 
	 * 			0：空车位 
	 * 			1：已经预定的车位 
	 * 			2：正在使用的车位
	  * 
	 */
	
	public int findStatus(String parking_id,String space_location); //查看停车场中的一个车位的状态
	
	//预定车位
	public boolean reserveCarspace(CarSpace car);
	
	public boolean parkCarspace(CarSpace car);
	
	public boolean takeCarspace(CarSpace car);
	
	public int findCarspaceStatus(String space_id);
	
	public int compareCarspace(CarSpace car);
	
	public boolean taskCarspace();
	
	
	
	
	
	//public boolean TaskCarspace();
 	//public List<Carspace> findEmptyCarspace(String parking_id);//查找一个停车场中的所有空车位
	//public List<Carspace> findAllCarspace(String parking_id);//根据停车场编号查找所有的车位
	//public int findStatus(String parking_id,String space_location); //茶渣停车场中的一个车位的状态
	
	
	/* 1.预定车位    置为1
	 * 2.停车            置为2
	 * 3.取车            置为0
	 * 4.查看所有空闲车位
	 * 5.查看某一个车位的状态
	 * 6.查看所有车位状态
	 */
}
