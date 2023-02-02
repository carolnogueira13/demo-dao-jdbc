package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() { // ele retorna um tipo de interface
		return new SellerDaoJDBC(DB.getConnection()); // "esconde" a implementação protegida dentro do método
	}

}
