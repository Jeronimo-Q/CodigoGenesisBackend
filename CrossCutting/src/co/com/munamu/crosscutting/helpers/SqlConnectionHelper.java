package co.com.munamu.crosscutting.helpers;

import java.sql.Connection;
import java.sql.SQLException;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.crosscutting.exceptions.enums.Layer;


public final class SqlConnectionHelper {
	
	private SqlConnectionHelper() {
		
	}
	
	public static boolean connectionIsNull(final Connection connection) {
		return ObjectHelper.isNull(connection);
	}
	
	public static boolean connectionIsOpen(final Connection connection) {
		try {
			return !connectionIsNull(connection)&& !connection.isClosed();
		}catch (final SQLException exception) {
			var userMessages = "Se ha presentado un problema inesperado a la horade llevar a cabo la operacion deseada...";
			var technicalMessage = "No es posible crear un acceso a datos de tipo SQL con una conexion nula o cerrada...";
			throw new MunamuApplicationException (userMessages,technicalMessage,exception,Layer.DATA);
		}
	}

}
