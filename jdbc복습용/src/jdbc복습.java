
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc���� {

	public static void main(String[] args) {
		
		// ���� ���ԵǾ� �ִ� ��� ȸ���� ���� ��� (�ܼ�)
		// JDBC_member ���̺� ��� ���� ��� ->����x
		
		ResultSet rs = null; // boolean
		PreparedStatement psmt = null;
		Connection conn = null;
		
		// try-catch : ����ó��(��Ÿ�� ����)
		try {
			// ������ �ڵ�
			// 1. ����̹� �ε� -> ClassNotFoundException
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			// �ٸ� ���� �����Ҷ���... / ��Ʈ��ȣ / 
			String dbid = "hr"; // id
			String dbpw = "hr"; // pw

			// 2. ������ ���̽� ���� (Connection)��ü ����
			 conn= DriverManager.getConnection(url,dbid,dbpw);
			// java.sql �� �ִ� �� ����Ʈ
			// sqlexception -> conn �ȵ� 
			
			String sql = "select * from jdbc_member"; // ; ���� �ۼ�
			// 3. sql ���� /�غ�(PreparedStatement)  ��ü ����
			psmt=conn.prepareStatement(sql);
			
			// excuteUpdate() : insert, delete, update -> ���̺� ��ȭ O
			// -> ��ȯ�� (int) -> ��� �࿡�� ��ȭ�� �Ͼ����
			// excuteQuery() : select -> ���̺� ��ȭx
			// -> ��ȯ�� (ResultSet(Object)) -> select�� ����� ����� + Ŀ��
			// next() : Ŀ���� ��ĭ ������(���� ���� ����Ŵ)
			// -> Ŀ���� ����Ű�� �࿡ ���� �ִ��� �������� �Ǵ� -> ������ true��ȯ / ������ false ��ȯ
			
			
			// 4. sql �� ����
			 rs = psmt.executeQuery(); //����Ʈ
			
			// executeUpdate()-> ������, ������ ���� ���� ��, ��������� �׻� 0���� Ŀ
			// insert, delete, update -> ���̺� �󿡼� ��ȭ
			// select�� ��ȭ ����!! -> �о ���� �ȴ�.
			
			// executeQuery() -> ResultSet (Object)�� ��ȯ�ȴ�.
			// ex) JDBC_Member ���̺��� �ִٸ�... ǥ�� ��ȯ�ȴٰ� �����ϸ��.
			// �÷��� ����Ű�� Ŀ���� �־� - > ���� �ִ� �� �ϳ��ϳ� �����´�?
			// ���� �ϳ��ϳ� ����ų���� next() ��� �޼ҵ尡 �־�
			// 1. Ŀ���� 1ĭ ������
			// 2. ���� ����Ű�� �ִ� �࿡ ���� �ִ��� �������� �Ǵ����ش�. 0�ƴ� 1 �׷��� boolean ��ȯ *�߿�*
			// ������ true �׸��� ������ �о�´�. �׸��� ������ ���� ������ �� �ݺ�
			// ���� ���������� �ݺ��ϴٰ�  Ȯ���ϰ� ������ false
			
			
			//5. ���� ���
			
			while(rs.next()) { // rs.next ��ü�� true �� false
				// ������ �÷��� �о����
				String id = rs.getString(1); // �÷��� ����(1���� ����) ���� / ù��° �������ڴ�. ���⼱ id
				String pw =rs.getString("pw"); // �÷� �̸�(String)�����ؼ� ������ ����
				String nick =rs.getString(3);
				
				// int a = rs.getInt(1) -> �������� ������ �ö�
				// select nick �̶�� �ϸ� �г��� �����͵� rs.getString(1) ���
				
				System.out.println("id :" +id);
				System.out.println("pw :" +pw);
				System.out.println("nick :" +nick);
				System.out.println("==================");
			}
			
			
		} catch (Exception e) {
			// try �� �ȿ��� �߻��� ���� ��Ȳ�� ���� ó��
			e.printStackTrace();
		} finally {
			// try ���ȿ��� �߻��� ���� ��Ȳ�� ���� ó��
			// ������ ���� �ݴ�� �ݾ����
			// 6. ����� ��ü �ݱ� (�ڿ���ȯ)
			try {
				
				// ������ �������� ��!!
				rs.close(); // ��ü������ ���� ���� ��� -> ���ʿ��� ���ܻ�Ȳ �߻� 
							// -> close() ȣ��x -> ��Ÿ�� ����
				psmt.close();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// ���� Ŀ�Եȴ�! db���� Ŀ�Դ�����!!
		
		
		
		
	}

}
