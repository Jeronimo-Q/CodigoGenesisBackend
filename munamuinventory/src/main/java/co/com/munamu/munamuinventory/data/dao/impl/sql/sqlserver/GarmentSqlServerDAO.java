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
import co.com.munamu.munamuinventory.data.dao.GarmentDAO;
import co.com.munamu.munamuinventory.data.dao.impl.sql.SqlDAO;
import co.com.munamu.munamuinventory.entity.CategoryEntity;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;
import co.com.munamu.munamuinventory.entity.GarmentEntity;
import co.com.munamu.munamuinventory.entity.GenreEntity;
import co.com.munamu.munamuinventory.entity.TypeGarmentEntity;

final class GarmentSqlServerDAO extends SqlDAO implements GarmentDAO{

	protected GarmentSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public GarmentEntity findByID(UUID id) {
		var garmentEntityFilter = new GarmentEntity();
		garmentEntityFilter.setId(id);
		
		var result = findByFilter(garmentEntityFilter);
		
		return (result.isEmpty())? new GarmentEntity() : result.get(0);
	}

	@Override
	public List<GarmentEntity> findAll() {
		return findByFilter(new GarmentEntity());
	}

	@Override
	public List<GarmentEntity> findByFilter(GarmentEntity filter) {
		
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect = new ArrayList<GarmentEntity>();	
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
				
				var garmentEntityTmp = new GarmentEntity();
				var garmentConfigurationTmp = new GarmentConfigurationEntity();
				var categoryEntityTmp = new CategoryEntity();
				var genreEntityTmp = new GenreEntity();
				var typeGarmentEntityTmp = new TypeGarmentEntity();
				
				categoryEntityTmp.setName(result.getString("name"));
				genreEntityTmp.setName(result.getString("name"));
				typeGarmentEntityTmp.setName(result.getString("name"));
				
				
				garmentConfigurationTmp.setId(UUIDHelper.convertToUUID("garmentConfiguration"));
				garmentConfigurationTmp.setCategory(categoryEntityTmp);
				garmentConfigurationTmp.setGenre(genreEntityTmp);
				garmentConfigurationTmp.setTypeGarment(typeGarmentEntityTmp);

				garmentEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				garmentEntityTmp.setReference(result.getString("reference"));
				garmentEntityTmp.setDescription((result.getString("description")));
				garmentEntityTmp.setGarmentConfiguration(garmentConfigurationTmp);
				resultSelect.add(garmentEntityTmp);
			}
				
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo la consulta de las prendas por el filtro deseado.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratando de preparar la consulta de la información de las prendas por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			if(statementWasPrepared) {
				technicalMessage="Se ha presentado un problema al tratando de ejecutar la consultar la información de las prendas por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			}
		throw DataMunamuInventoryException.create(userMessage,technicalMessage,exception);
		}
		return resultSelect;
	}

	@Override
	public void delete(UUID data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM Garment WHERE id = ? ");
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){

			preparedStatement.setObject(1, data);
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo la eliminacion del registro prenda. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratar de eliminar la informacion prenda en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			throw DataMunamuInventoryException.create(userMessage, technicalMessage, exception);
		}
		
	}

	@Override
	public void create(GarmentEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO Garment(id, reference, description, garmentConfiguration) VALUES (?, ?, ?, ?) ");
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			preparedStatement.setObject(1, data.getId());
			preparedStatement.setString(2, data.getReference());
			preparedStatement.setString(3, data.getDescription());
			preparedStatement.setObject(4, data.getGarmentConfiguration().getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la informacion de la nueva prenda. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage="Se ha presentado un problema al tratar de registrar la informacion de la nueva prenda en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			throw DataMunamuInventoryException.create(userMessage, technicalMessage, exception);
		}
		
	}

	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, referencia, descripcion, garmentConfiguration ");
	} 

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM Garment ");
	} 
	
	private void createWhere(final StringBuilder statemet, final GarmentEntity filter, final ArrayList<Object> parameters) {
		if(!ObjectHelper.isNull(filter)) {
			if(UUIDHelper.isDefault(filter.getId())) {
				statemet.append("WHERE id = ? ");
				parameters.add(filter.getId());
			}
			if(!TextHelper.isEmptyAppplyingTrim(filter.getReference())) {
				statemet.append((parameters.isEmpty()) ?"WHERE "  : "AND ");
				statemet.append("referencia = ? ");
				parameters.add(filter.getId());
			}
			if(!TextHelper.isEmptyAppplyingTrim(filter.getDescription())) {
				statemet.append((parameters.isEmpty()) ?"WHERE "  : "AND ");
				statemet.append("descripcion = ? ");
				parameters.add(filter.getId());
			}
			if(!ObjectHelper.isNull(filter.getGarmentConfiguration())) {
				statemet.append((parameters.isEmpty()) ?"WHERE "  : "AND ");
				statemet.append("garmentConfiguration = ? ");
				parameters.add(filter.getId());
			}
		}
		
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY referencia ASC ");
	}

}
