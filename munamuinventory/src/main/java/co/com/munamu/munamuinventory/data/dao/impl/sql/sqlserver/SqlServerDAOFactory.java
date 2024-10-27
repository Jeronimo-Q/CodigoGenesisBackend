package co.com.munamu.munamuinventory.data.dao.impl.sql.sqlserver;

import java.sql.Connection;


import co.com.munamu.crosscutting.helpers.SqlConnectionHelper;
import co.com.munamu.munamuinventory.data.dao.CategoryDAO;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.data.dao.GarmentConfigurationDAO;
import co.com.munamu.munamuinventory.data.dao.GarmentDAO;
import co.com.munamu.munamuinventory.data.dao.GenreDAO;
import co.com.munamu.munamuinventory.data.dao.SizeDAO;
import co.com.munamu.munamuinventory.data.dao.SizePerGarmentDAO;
import co.com.munamu.munamuinventory.data.dao.TypeGarmentDAO;

public final class SqlServerDAOFactory extends DAOFactory{

	private Connection connection;
	
	public SqlServerDAOFactory() {
		openConnection();
	}
	
	
	@Override
	protected void openConnection() {
		
		SqlConnectionHelper.validateIfConnectionIsOpen(connection);
		var connectionString = "jdbc:sqlserver://munamuinventory-server.database.windows.net:1433;database=munamuinventory-sql;user=administradormunamu@munamuinventory-server;password=Curry3023;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		connection = SqlConnectionHelper.openConnection(connectionString);
	}
	

	@Override
	public void initTransaction() {
		SqlConnectionHelper.initTransaction(connection);
	}

	@Override
	public void commitTransaction() {
		SqlConnectionHelper.commitTransaction(connection);	
	}

	@Override
	public void rollbackTransaction() {
		SqlConnectionHelper.rollbackTransaction(connection);
	}

	@Override
	public void closeTransaction() {
		SqlConnectionHelper.closeConnection(connection);
	}

	@Override
	public GenreDAO getGenreDAO() {
		return new GenreSqlServerDAO(connection);
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		return new CategorySqlServerDAO(connection);
	}

	@Override
	public TypeGarmentDAO getTypeGarmentDAO() {
		return new TypeGarmentSqlServerDAO(connection);
	}

	@Override
	public GarmentConfigurationDAO getGarmentConfigurationDAO() {
		return new GarmentConfigurationSqlServerDAO(connection);
	}

	@Override
	public GarmentDAO getGarmentDAO() {
		return new GarmentSqlServerDAO(connection);
	}

	@Override
	public SizePerGarmentDAO getSizePerGarmentDAO() {
		return new SizePerGarmentSqlServerDAO(connection);
	}

	@Override
	public SizeDAO getSizeDAO() {
		return new SizeSqlServerDAO(connection);
	}

}
