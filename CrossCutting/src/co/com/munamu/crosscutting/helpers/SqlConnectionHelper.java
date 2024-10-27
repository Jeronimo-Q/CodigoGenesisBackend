package co.com.munamu.crosscutting.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public static void initTransaction(final Connection connection) {
		
		validateIfConnectionIsClosed(connection);
		
		try {
			if (!connection.getAutoCommit()) {
				var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
				var technicalMessage = "No es posible iniciar una transaccion que ya ha sido iniciada previamente en la base de datos SQL deseada...";
				throw new MunamuApplicationException(userMessage,technicalMessage,new Exception(),Layer.DATA);
			}
			
			connection.setAutoCommit(false);
			
		}catch (final SQLException exception) {
			var userMessages = "Se ha presentado un problema inesperado a la horade llevar a cabo la operacion deseada...";
			var technicalMessage = "Se ha prensentado un excepcion de tipo SQLException tratando de iniciar la transaccion. Por favor revise el log de errores para obtener mas detalle del error presentado...";
			throw new MunamuApplicationException (userMessages,technicalMessage,exception,Layer.DATA);
		}
	}
	
	public static void commitTransaction(final Connection connection) {
		
		validateIfConnectionIsClosed(connection);
		validateIfTransactionWasNotInitiated(connection);
		
		try {
			connection.commit();
		}catch (final SQLException exception) {
			var userMessages = "Se ha presentado un problema inesperado a la horade llevar a cabo la operacion deseada...";
			var technicalMessage = "Se ha prensentado un excepcion de tipo SQLException tratando de confirmar la transaccion. Por favor revise el log de errores para obtener mas detalle del error presentado...";
			throw new MunamuApplicationException (userMessages,technicalMessage,exception,Layer.DATA);
		}
	}
	
	public static void rollbackTransaction(final Connection connection) {
		
		validateIfConnectionIsClosed(connection);
		validateIfTransactionWasNotInitiated(connection);
		
		try {
			connection.rollback();
		}catch (final SQLException exception) {
			var userMessages = "Se ha presentado un problema inesperado a la horade llevar a cabo la operacion deseada...";
			var technicalMessage = "Se ha prensentado un excepcion de tipo SQLException tratando de cancelar la transaccion. Por favor revise el log de errores para obtener mas detalle del error presentado...";
			throw new MunamuApplicationException (userMessages,technicalMessage,exception,Layer.DATA);
		}
	}
	
	public static void validateIfConnectionIsOpen(final Connection connection) {
		if(SqlConnectionHelper.connectionIsOpen(connection)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No es posible tratar de abrir una conexion hacia la base de datos SQL que ya esta abierta...";
			throw new MunamuApplicationException(userMessage,technicalMessage,new Exception(),Layer.DATA);
		}
	}
	
	public static void validateIfConnectionIsClosed(final Connection connection) {
		if(!SqlConnectionHelper.connectionIsOpen(connection)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "La conexion hacia la base de datos SQL esta cerrada. Por tanto no es posible llevar a cabo la operacion deseada...";
			throw new MunamuApplicationException(userMessage,technicalMessage,new Exception(),Layer.DATA);
		}
	}
	
	public static void validateIfTransactionWasNotInitiated(final Connection connection) {
		try {
			if (connection.getAutoCommit()) {
				var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
				var technicalMessage = "La transaccion no a sido iniciada previamente para realizar la operacionn deseada en la base de datos SQL deseada...";
				throw new MunamuApplicationException(userMessage,technicalMessage,new Exception(),Layer.DATA);
			}
		} catch (SQLException exception) {
			var userMessages = "Se ha presentado un problema inesperado a la horade llevar a cabo la operacion deseada...";
			var technicalMessage = "Se ha prensentado un excepcion de tipo SQLException tratando de validar si la transaccion fue iniciada. Por favor revise el log de errores para obtener mas detalle del error presentado...";
			throw new MunamuApplicationException (userMessages,technicalMessage,exception,Layer.DATA);
		}
	}
	
	public static void closeConnection(final Connection connection) {
		
		validateIfConnectionIsClosed(connection);
		
		try {
			connection.close();
		}catch (final SQLException exception) {
			var userMessages = "Se ha presentado un problema inesperado a la horade llevar a cabo la operacion deseada...";
			var technicalMessage = "Se ha prensentado un excepcion de tipo SQLException tratando de cerrar la conexion. Por favor revise el log de errores para obtener mas detalle del error presentado...";
			throw new MunamuApplicationException (userMessages,technicalMessage,exception,Layer.DATA);
		}
	}

	
	public static Connection openConnection(final String connectionString) {
		try {
			return DriverManager.getConnection(connectionString);
		}catch (final SQLException exception) {
			var userMessages = "Se ha presentado un problema inesperado a la horade llevar a cabo la operacion deseada...";
			var technicalMessage = "Se ha prensentado un excepcion de tipo SQLException tratando de obtener la conexion con la fuente de datos SQL deseada. Por favor revise el log de errores para obtener mas detalle del error presentado...";
			throw new MunamuApplicationException (userMessages,technicalMessage,exception,Layer.DATA);
		}
	}
}
