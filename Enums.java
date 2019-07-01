package model;

public class Enums {
	
	public static enum LOGIN_STATUS{
		USER_NOT_EXIST, // Can not find the user in the database 
		PWD_NOT_MATCH,  // The user in the database maps another password
		LOGIN_SUCCCESS  // The user exists and matches the password
	}
	
	public static enum GENDER{
		MALE("男"),
		FEMALE("女"),
		SECRET("保密");
		
		private String gender;
		
		private GENDER(String gender) {
			this.gender = gender;
		}
		
		public String getGender() {
			return gender;
		}
		
		public static GENDER getGender(String gender) {
			GENDER result = null;
			if(gender.equals("男")) {
				result = MALE;
			}
			else if(gender.equals("女")){
				result = FEMALE;
			}
			else {
				result = SECRET;
			}
			return result;
		}
	}
	
	// The identity of of the staff
	public static enum POST{
		MANAGER,
		RECEPTIOINIST,
		ATTENDANT
	}
	
	// Return if your user name is duplicated
	public static enum REGIST_STATUS{
		USER_EXIST,
		SUCCESS
	}
}

