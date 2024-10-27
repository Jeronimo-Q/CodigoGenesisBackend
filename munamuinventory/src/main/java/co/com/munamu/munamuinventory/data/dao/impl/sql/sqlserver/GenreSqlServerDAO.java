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
import co.com.munamu.munamuinventory.data.dao.GenreDAO;
import co.com.munamu.munamuinventory.data.dao.impl.sql.SqlDAO;
import co.com.munamu.munamuinventory.entity.GenreEntity;

final class GenreSqlServerDAO extends SqlDAO implements GenreDAO{

	public GenreSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public GenreEntity findByID(final UUID id) {
		var genreEntityFilter = new GenreEntity();
		genreEntityFilter.setId(id);
		
		var result = findByFilter(genreEntityFilter);
		
		return (result.isEmpty())? new GenreEntity() : result.get(0);
	}

	@Override
	public List<GenreEntity> findAll() {
		return findByFilter(new GenreEntity());
	}

	@Override
	public List<GenreEntity> findByFilter(final GenreEntity filter) {
		
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect = new ArrayList<GenreEntity>();	
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
				var genreEntityTmp = new GenreEntity();
				genreEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				genreEntityTmp.setName(result.getString("name"));
				resultSelect.add(genreEntityTmp);
			}
				
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo la consulta de los generos por el filtro deseado.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratando de preparar la consulta de la información de los generos por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			if(statementWasPrepared) {
				technicalMessage="Se ha presentado un problema al tratando de ejecutar la consultar la información de los generos por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			}
		throw DataMunamuInventoryException.create(userMessage,technicalMessage,exception);
		}
		return resultSelect;
	}

	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, name ");
	} 

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM Genre ");
	} 
	
	private void createWhere(final StringBuilder statemet, final GenreEntity filter, final ArrayList<Object> parameters) {
		if(!ObjectHelper.isNull(filter)) {
			if(UUIDHelper.isDefault(filter.getId())) {
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
