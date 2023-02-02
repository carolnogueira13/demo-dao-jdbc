package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() { // ele retorna um tipo de interface
		return new SellerDaoJDBC(); // "esconde" a implementação protegida dentro do método
	}

}
