package co.com.munamu.munamuinventory.data.dao;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.munamuinventory.crosscutting.exceptions.DataMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.enums.DAOSource;
import co.com.munamu.munamuinventory.data.dao.impl.sql.sqlserver.SqlServerDAOFactory;

public abstract class DAOFactory {
	
	
	public final static DAOFactory getFactory(final DAOSource source) {
		switch (source) {
		case SQLSERVER: {
			return new SqlServerDAOFactory();
		}
		default:
			var userMessage = "Se ha prensentando un problema tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = TextHelper.concat("No existe una factoria implementada para",source.toString());
			throw DataMunamuInventoryException.crear(userMessage,technicalMessage);
		}
	}
	
	protected abstract void openConnection();
	
	public abstract void initTransaction();

	public abstract void commitTransaction();
	
	public abstract void rollbackTransaction();
	
	public abstract void closeConnection();
	
	public abstract GenreDAO getGenreDAO();
	
	public abstract CategoryDAO getCategoryDAO();
	
	public abstract TypeGarmentDAO getTypeGarmentDAO();
	
	public abstract GarmentConfigurationDAO getGarmentConfigurationDAO();
	
	public abstract GarmentDAO getGarmentDAO();
	
	public abstract SizePerGarmentDAO getSizePerGarmentDAO();
	
	public abstract SizeDAO getSizeDAO();
	
}
