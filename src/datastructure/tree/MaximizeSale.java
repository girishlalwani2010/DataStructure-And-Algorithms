package datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

class Vendor{
	private int startTime;
	private int endTime;
	private int price;
	
	private List<Integer> timeList = new ArrayList<Integer>(); 
	
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Integer> getTimeList() {
		return timeList;
	}
	public void setTimeList(List<Integer> timeList) {
		this.timeList = timeList;
	}
}


public class MaximizeSale {

	private static void createMapTimeToLeastPrice(List<Vendor> vendorsList) {
		HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
		for(Vendor vendor : vendorsList){
			for(int i=vendor.getStartTime(); i<=vendor.getEndTime(); i++){
				hashmap.put(i, vendor.getPrice());
			}
		}
		
		for(Vendor vendor : vendorsList){
			List<Integer> timeList = new ArrayList<Integer>();
			for(Entry<Integer, Integer> entry : hashmap.entrySet()){
				if(entry.getValue()==vendor.getPrice()){
					timeList.add(entry.getKey());
					vendor.setTimeList(timeList);
				}
			}
		}
		
		for(Vendor vendor : vendorsList){
			List<Integer> timeList = vendor.getTimeList();
			if(timeList!=null){
			int minTime=Integer.MAX_VALUE,maxTime=Integer.MIN_VALUE;
				for(Integer obj : timeList){
					if (obj.intValue() > maxTime){
						maxTime = obj.intValue();
					}
					if (obj.intValue() < minTime){
						minTime = obj.intValue();
					}
				}
				System.out.println(minTime+" "+maxTime+" "+vendor.getPrice());
			}
		}
	}
	
	public static void main(String args[]){
		Scanner scanner  = new Scanner(System.in);
		List<Vendor> vendorsList= new ArrayList<Vendor>();
		int numberOfVendors = scanner.nextInt();
		for(int i=0; i<numberOfVendors; i++){
			Vendor vendor = new Vendor();
			vendor.setStartTime(scanner.nextInt());
			vendor.setEndTime(scanner.nextInt());
			vendor.setPrice(scanner.nextInt());
			vendorsList.add(vendor);
		}
		
		createMapTimeToLeastPrice(vendorsList);
	}

	
	
}
