package vttp.batch5.sdf.task01;
//
// IMPORTANT: DO NOT MODIFY THIS CLASS



public class MyBikeEntry {

    private int weekday;
    private int weather;
	private int season;
	private int casual;
	private int registered;
    private int total;
    private int month;
    private boolean holiday;


	public int getWeekday() {
		return weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}
	public int getWeather() {
		return weather;
	}
	public void setWeather(int weather) {
		this.weather = weather;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public int getCasual() {
		return casual;
	}
	public void setCasual(int casual) {
		this.casual = casual;
	}
	public int getRegistered() {
		return registered;
	}
	public void setRegistered(int registered) {
		this.registered = registered;
	}
	public int getTotal(int casual, int registered) {
        int total = casual + registered;
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public boolean isHoliday() {
		return holiday;
	}
	public void setHoliday(boolean holiday) {
		this.holiday = holiday;
	}


	private static int toInt(String col) { //from BikeEntry.java
        return Integer.parseInt(col);
    }

	private static boolean toBoolean(String col) { //from BikeEntry.java
        return toInt(col) == 1;
    }

	public static MyBikeEntry toBikeEntryClass(String[] cols) {
        MyBikeEntry entry = new MyBikeEntry();
        entry.setSeason(toInt(cols[0]));
        entry.setMonth(toInt(cols[1]));
        entry.setHoliday(toBoolean(cols[2]));
        entry.setWeekday(toInt(cols[3]));
        entry.setCasual(toInt(cols[4]));
        entry.setRegistered(toInt(cols[5]));
        entry.setTotal(toInt(cols[6]));
        return entry;
    }

	public static final String[] SEASON = {"Spring", "Summer", "Fall", "Winter"};
    public static final String[] DAY = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final String[] MONTH = {"January", "Febuary", "March", "April", "May",
        "June", "July", "August", "September", "October", "November", "December"
    };

	public static String actualSeason(int season) {
        switch (season) { //season (1:spring, 2:summer, 3:fall, 4:winter), referenced from Utilities
            case 1:
                return "spring";

            case 2:
                return "summer";

            case 3:
                return "fall";

            case 4:
                return "winter";

            default:
                return "funny Season";

        }
    }

	public static String toWeekday(int weekday) {
        switch (weekday) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "wrong day";
        }
    
    }

	public static String toMonth(int month) {
        switch (month) {

            case 1:
			return "January";
			case 2:
			return "February";
			case 3:
			return "March";
			case 4:
			return "April";
			case 5:
			return "May";
			case 6:
			return "June";
			case 7:
			return "July";
			case 8:
			return "August";
			case 9:
			return "September";
			case 10:
			return "October";
			case 11:
			return "November";
			case 12:
			return "December";
				
			default:
				return "unknown month";
          
        }
    }
  
	
}

