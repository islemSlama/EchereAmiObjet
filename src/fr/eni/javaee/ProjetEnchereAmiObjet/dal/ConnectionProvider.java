package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {

	public static DataSource datasource;

	static {
		try {
			Context context = new InitialContext();
			// creation de source de données
			ConnectionProvider.datasource = (DataSource) context.lookup("java:comp/env/jdbc/myconnexion_cnx");
			// et on établie une connection
			Connection cnx = datasource.getConnection();

			// cnx.close();
		} catch (NamingException d) {
			d.printStackTrace();
		} catch (SQLException f) {
			f.printStackTrace();
		}
	}

	public static Connection getConnection() throws DALException {
		Connection connexionEtablie = null;
		try {
			return connexionEtablie = ConnectionProvider.datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connexionEtablie;
	}

}
