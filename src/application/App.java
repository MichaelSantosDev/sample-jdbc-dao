package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entity.Department;
import model.entity.Seller;

public class App {

	public static void main(String[] args) {
		
		Department o = new Department(1, "Customer Service");
		
		Seller s = new Seller(21, "Michael", "m@c.l", new Date(), 999.00, o);
		
		System.out.println(o);
		System.out.println(s);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
			
		

	}

}
