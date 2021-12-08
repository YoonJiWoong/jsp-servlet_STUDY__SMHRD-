package test111;

public class BVO {

	int board_num;
	String board_title;
	String board_contents;
	String board_date;
	String m_id;
	
	
	public BVO(int board_num, String board_title, String board_contents, String board_date, String m_id) {
		
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_contents = board_contents;
		this.board_date = board_date;
		this.m_id = m_id;
	}
	
public BVO(int board_num, String board_title, String board_date, String m_id) {
		
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_date = board_date;
		this.m_id = m_id;
	}
	
	
	
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
	
	
	
	
}
