package co.com.munamu.munamuinventory.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.crosscutting.exceptions.DataMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.SizePerGarmentDAO;
import co.com.munamu.munamuinventory.data.dao.impl.sql.SqlDAO;
import co.com.munamu.munamuinventory.entity.GarmentEntity;
import co.com.munamu.munamuinventory.entity.SizeEntity;
import co.com.munamu.munamuinventory.entity.SizePerGarmentEntity;

final class SizePerGarmentSqlServerDAO extends SqlDAO implements SizePerGarmentDAO{

	protected SizePerGarmentSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public SizePerGarmentEntity findByID(UUID id) {
		var sizePerGarmentEntityFilter = new SizePerGarmentEntity();
		sizePerGarmentEntityFilter.setId(id);
		
		var result = findByFilter(sizePerGarmentEntityFilter);
		
		return (result.isEmpty())? new SizePerGarmentEntity() : result.get(0);
	}

	@Override
	public List<SizePerGarmentEntity> findAll() {
		return findByFilter(new SizePerGarmentEntity());
	}

	@Override
	public List<SizePerGarmentEntity> findByFilter(SizePerGarmentEntity filter) {
		
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect = new ArrayList<SizePerGarmentEntity>();	
		var statementWasPrepared = false;
		
		createSelect(statement);
		createFrom(statement);
		createWhere(statement, filter, parameters);
		createOrderBy(statement);
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			for (var arrayIndex = 0; arrayIndex < parameters.size(); arrayIndex++) {
				var statementIndex = arrayIndex + 1;
				preparedStatement.setObject(statementIndex, parameters.get(arrayIndex));
			}
			
			statementWasPrepared = true;
			
			final var result = preparedStatement.executeQuery();
				
			while (result.next()) {
				var sizePerGarmentEntityTmp = new SizePerGarmentEntity();
				sizePerGarmentEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				sizePerGarmentEntityTmp.setGarment((GarmentEntity) result.getObject("garment"));
				sizePerGarmentEntityTmp.setSize((SizeEntity) result.getObject("size"));
				resultSelect.add(sizePerGarmentEntityTmp);
			}
				
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo la consulta de las tallas por prenda por el filtro deseado.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratando de preparar la consulta de la información de las tallas por prenda por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			if(statementWasPrepared) {
				technicalMessage="Se ha presentado un problema al tratando de ejecutar la consultar la información de las tallas de las prendas por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			}
		throw DataMunamuInventoryException.create(userMessage,technicalMessage,exception);
		}
		return resultSelect;
	}

	@Override
	public void delete(SizePerGarmentEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM SizePerGarment WHERE id = ? ");
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){

			preparedStatement.setObject(1, data);
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo la eliminacion del registro de la talla por prenda. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratar de eliminar la informacion de la talla por prenda en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			throw DataMunamuInventoryException.create(userMessage, technicalMessage, exception);
		}
		
	}

	@Override
	public void create(SizePerGarmentEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO SizePerGarment(id, garment, size) VALUES (?, ?, ?) ");
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			preparedStatement.setObject(1, data.getId());
			preparedStatement.setObject(2, data.getGarment().getId());
			preparedStatement.setObject(3, data.getSize().getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la informacion de la nueva talla por prenda. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratar de registrar la informacion de la nueva talla por prenda en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			throw DataMunamuInventoryException.create(userMessage, technicalMessage, exception);
		}
		
	}
	
	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, garment, size ");
	} 

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM SizePerGarment ");
	} 
	
	private void createWhere(final StringBuilder statemet, final SizePerGarmentEntity filter, final ArrayList<Object> parameters) {
		if(!ObjectHelper.isNull(filter)) {
			if(UUIDHelper.isDefault(filter.getId())) {
				statemet.append("WHERE id = ? ");
				parameters.add(filter.getId());
			}
		}
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY garment ASC ");
	}

}
