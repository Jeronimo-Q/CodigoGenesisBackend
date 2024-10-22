package co.com.munamu.munamuinventory.data.dao.impl.sql;

import java.sql.Connection;

import co.com.munamu.crosscutting.helpers.SqlConnectionHelper;
import co.com.munamu.munamuinventory.crosscutting.exceptions.DataMunamuInventoryException;

public class SqlDAO {
	
	private Connection connection;
	
	protected SqlDAO(final Connection connection) {
		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		validateIfConnectionIsOpen(connection);
		this.connection = connection;
	}
	
	private void validateIfConnectionIsOpen(final Connection connection) {
		if(!SqlConnectionHelper.connectionIsOpen(connection)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada";
			var technicalMessage = "No es posible crear un acceso a datos de tipo sql con una conexion nula o cerrada ";
		
			throw DataMunamuInventoryException.create(userMessage,technicalMessage);
		}
	}
	
}
