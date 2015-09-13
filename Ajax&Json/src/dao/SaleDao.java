package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Sale;

public class SaleDao {
	public List<Sale> findAll()throws Exception{
		List<Sale> sales = new ArrayList<Sale>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT * FROM t_sale ORDER BY qty DESC)aa LIMIT 0,3");
			res = pstmt.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String prodName = res.getString("prodName");
				int qty = res.getInt("qty");
				Sale sale = new Sale(id, prodName, qty);
				sales.add(sale);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
		return sales;
	}
	public void Save(Sale sale) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO t_sale VALUES(NULL,?,?)");
			pstmt.setString(1, sale.getProdName());
			pstmt.setInt(2, sale.getQty());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	public static void main(String[] args) {
		SaleDao dao = new SaleDao();
		try {
			List<Sale> list = dao.findAll();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
