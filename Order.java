package model;

import java.util.HashMap;

import ctrl.CustomerDao;
import model.Enums.GENDER;

public class Order {

	private int oid;
	private Customer customer;
	private String arrivateDate;
	private String leaveDate;
	
	// Customer personal info
	private String[] nameList = new String[2];
	private String[] idList = new String[2];
	
	private Room room;
	private double total;
	private String comment = "";
	
	public Order(int oid, int uid, String arriveDate, String leaveDate, 
			String name1, String name2, String id1, String id2, int roomId, 
			double total, String comment) {
		
		this.oid = oid;
		this.arrivateDate = arriveDate;
		this.leaveDate = leaveDate;
		this.nameList[0] = name1;
		this.nameList[1] = name2;
		this.idList[0] = id1;
		this.idList[1] = id2;
		this.total = total;
		this.comment = comment;
		
		HashMap<String, String> custInfo = CustomerDao.getPersonalInfo(uid);
		
		// Process the attribute gender
		GENDER gender;
		if(custInfo.get("gender").equals("M")) {
			gender = GENDER.MALE;
		}
		else if(custInfo.get("gender").equals("F")) {
			gender = GENDER.FEMALE;
		}
		else {
			gender = GENDER.SECRET;
		}
		
		this.customer = new Customer(custInfo.get("usr"), custInfo.get("pwd"),
				custInfo.get("phone"), custInfo.get("nickname"), gender,
				custInfo.get("birthday"), custInfo.get("address"), custInfo.get("email"));
		
		this.room = new Room(roomId);
		
		System.out.println("Done");
	}

	public int getOid() {
		return oid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getArrivateDate() {
		return arrivateDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public String[] getNameList() {
		return nameList;
	}

	public String[] getIdList() {
		return idList;
	}

	public Room getRoom() {
		return room;
	}

	public double getTotal() {
		return total;
	}

	public String getComment() {
		return comment;
	}
}
