package co.com.munamu.munamuinventory.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.crosscutting.exceptions.DataMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.TypeGarmentDAO;
import co.com.munamu.munamuinventory.data.dao.impl.sql.SqlDAO;
import co.com.munamu.munamuinventory.entity.TypeGarmentEntity;

final class TypeGarmentSqlServerDAO extends SqlDAO implements TypeGarmentDAO{

	protected TypeGarmentSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public TypeGarmentEntity findByID(UUID id) {
		var typeGarmentEntityFilter = new TypeGarmentEntity();
		typeGarmentEntityFilter.setId(id);
		
		var result = findByFilter(typeGarmentEntityFilter);
		
		return (result.isEmpty())? new TypeGarmentEntity() : result.get(0);
	}

	@Override
	public List<TypeGarmentEntity> findAll() {
		return findByFilter(new TypeGarmentEntity());
	}

	@Override
	public List<TypeGarmentEntity> findByFilter(TypeGarmentEntity filter) {
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect = new ArrayList<TypeGarmentEntity>();	
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
				var typeGarmentEntityTmp = new TypeGarmentEntity();
				typeGarmentEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				typeGarmentEntityTmp.setName(result.getString("name"));
				resultSelect.add(typeGarmentEntityTmp);
			}
				
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo la consulta de las tallas por el filtro deseado.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratando de preparar la consulta de la información de las tallas por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			if(statementWasPrepared) {
				technicalMessage="Se ha presentado un problema al tratando de ejecutar la consultar la información de las tallas por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			}
		throw DataMunamuInventoryException.create(userMessage,technicalMessage,exception);
		}
		return resultSelect;
	}


	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, name ");
	} 

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM TypeGarment ");
	} 
	
	private void createWhere(final StringBuilder statemet, final TypeGarmentEntity filter, final ArrayList<Object> parameters) {
		if(!ObjectHelper.isNull(filter)) {
			if(!UUIDHelper.isDefault(filter.getId())) {
				statemet.append("WHERE id = ? ");
				parameters.add(filter.getId());
			}
			if(!TextHelper.isEmptyAppplyingTrim(filter.getName())) {
				statemet.append((parameters.isEmpty()) ?"WHERE "  : "AND ");
				statemet.append("name = ? ");
				parameters.add(filter.getId());
			}
		}
		
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY name ASC ");
	}

}
