package model;

import ctrl.CustomerDao;

public class Room {
	
	private int roomId;
	private String type;
	private int size;
	private int maxCapasity;
	private String description;
	private double price;
	private boolean isUseable;
	
	public Room(int roomId) {
		this.roomId = roomId;
		String[] info = CustomerDao.getRoomInfo(roomId);
		type = info[0];
		size = Integer.parseInt(info[1]);
		maxCapasity = Integer.parseInt(info[2]);
		description = info[3];
		price = Double.parseDouble(info[4]);
		if(info[5].equals("0")) {
			isUseable = true;
		}
		else {
			isUseable = false;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isUseable() {
		return isUseable;
	}

	public void setUseable(boolean isUseable) {
		this.isUseable = isUseable;
	}

	public int getRoomId() {
		return roomId;
	}

	public String getType() {
		return type;
	}

	public int getSize() {
		return size;
	}

	public int getMaxCapasity() {
		return maxCapasity;
	}
}
