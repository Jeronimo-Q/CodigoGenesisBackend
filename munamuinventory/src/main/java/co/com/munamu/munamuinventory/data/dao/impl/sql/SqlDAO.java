package co.com.munamu.munamuinventory.data.dao.impl.sql;

import java.sql.Connection;

import co.com.munamu.crosscutting.helpers.SqlConnectionHelper;

public class SqlDAO {
	
	private Connection connection;
	
	protected SqlDAO(final Connection connection) {
		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		SqlConnectionHelper.validateIfConnectionIsClosed(connection);
		this.connection = connection;
	}
	
}
