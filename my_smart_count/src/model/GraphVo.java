package model;

public class GraphVo {
	
	
	
	String id;
	int R_COUNT;
	String date;

	public String getDate() {
		return date;
	}

	public GraphVo(String get_id, int get_R_COUNT, String get_day) {

		this.id = get_id;
		R_COUNT = get_R_COUNT;
		date = get_day;

	}

	public String getId() {
		return id;
	}

	public int getR_COUNT() {
		return R_COUNT;
	}


}
