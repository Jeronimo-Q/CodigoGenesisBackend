package co.com.munamu.munamuinventory.data.dao;

import co.com.munamu.munamuinventory.data.dao.enums.DAOSource;

public abstract class DAOFactory {
	
	
	public final static DAOFactory getFactory(final DAOSource source) {
		return null;
	}
	
	protected abstract void openConnection();
	
	public abstract void initTransaction();

	public abstract void commitTransaction();
	
	public abstract void rollbackTransaction();
	
	public abstract void closeTransaction();
	
	public abstract GenreDAO getGenreDAO();
	
	public abstract CategoryDAO getCategoryDAO();
	
	public abstract TypeGarmentDAO getTypeGarmentDAO();
	
	public abstract GarmentConfigurationDAO getGarmentConfigurationDAO();
	
	public abstract GarmentDAO getGarmentDAO();
	
	public abstract SizePerGarmentDAO getSizePerGarmentDAO();
	
	public abstract SizeDAO getSizeDAO();
	
}
