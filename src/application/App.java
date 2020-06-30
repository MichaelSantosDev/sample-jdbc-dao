package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entity.Department;
import model.entity.Seller;

public class App {

	public static void main(String[] args) {		
		
		System.out.println("Seller findById");
		System.out.println("---------------");
		SellerDao sellerDao = DaoFactory.createSellerDao();		
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
			
		

	}

}
