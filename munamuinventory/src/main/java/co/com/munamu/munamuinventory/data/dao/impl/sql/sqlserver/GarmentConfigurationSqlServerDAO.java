package co.com.munamu.munamuinventory.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.crosscutting.exceptions.DataMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.GarmentConfigurationDAO;
import co.com.munamu.munamuinventory.data.dao.impl.sql.SqlDAO;
import co.com.munamu.munamuinventory.entity.CategoryEntity;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;
import co.com.munamu.munamuinventory.entity.GenreEntity;
import co.com.munamu.munamuinventory.entity.TypeGarmentEntity;

final class GarmentConfigurationSqlServerDAO extends SqlDAO implements GarmentConfigurationDAO {

	protected GarmentConfigurationSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public GarmentConfigurationEntity findByID(final UUID id) {
		var garmentConfigurationEntityFilter = new GarmentConfigurationEntity();
		garmentConfigurationEntityFilter.setId(id);

		var result = findByFilter(garmentConfigurationEntityFilter);

		return (result.isEmpty()) ? new GarmentConfigurationEntity() : result.get(0);
	}

	@Override
	public List<GarmentConfigurationEntity> findAll() {
		return findByFilter(new GarmentConfigurationEntity());
	}

	@Override
	public List<GarmentConfigurationEntity> findByFilter(final GarmentConfigurationEntity filter) {

		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect = new ArrayList<GarmentConfigurationEntity>();
		var statementWasPrepared = false;

		createSelect(statement);
		createFrom(statement);
		createJoin(statement);
		createWhere(statement, filter, parameters);
		createOrderBy(statement);

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {

			for (var arrayIndex = 0; arrayIndex < parameters.size(); arrayIndex++) {
				var statementIndex = arrayIndex + 1;
				preparedStatement.setObject(statementIndex, parameters.get(arrayIndex));
			}

			statementWasPrepared = true;

			final var result = preparedStatement.executeQuery();

			while (result.next()) {
				var garmentConfigurationEntityTmp = new GarmentConfigurationEntity();
				
				
				garmentConfigurationEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				
				var categoryEntityTmp = new CategoryEntity();
				var genreEntityTmp = new GenreEntity();
				var typeGarmentEntityTmp = new TypeGarmentEntity();
				
				categoryEntityTmp.setId(UUIDHelper.convertToUUID(result.getObject("category")));
				categoryEntityTmp.setName(result.getString("category_name"));
				genreEntityTmp.setId(UUIDHelper.convertToUUID(result.getObject("genre")));
				genreEntityTmp.setName(result.getString("genre_name"));
				typeGarmentEntityTmp.setId(UUIDHelper.convertToUUID(result.getObject("typeGarment")));
				typeGarmentEntityTmp.setName(result.getString("type_garment_name"));
				
				garmentConfigurationEntityTmp.setId(UUIDHelper.convertToUUID(result.getObject("id")));
				garmentConfigurationEntityTmp.setCategory(categoryEntityTmp);
				garmentConfigurationEntityTmp.setGenre(genreEntityTmp);
				garmentConfigurationEntityTmp.setTypeGarment(typeGarmentEntityTmp);
				resultSelect.add(garmentConfigurationEntityTmp);
			}

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo la consulta de las configuracion de prenda por el filtro deseado.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratando de preparar la consulta de la información de las configuracion de las prendas por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			if (statementWasPrepared) {
				technicalMessage = "Se ha presentado un problema al tratando de ejecutar la consultar la información de las configuracion de las prendas por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			}
			throw DataMunamuInventoryException.create(userMessage, technicalMessage, exception);
		}
		return resultSelect;
	}

	@Override
	public void delete(UUID data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM GarmentConfiguration WHERE id = ? ");

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {

			preparedStatement.setObject(1, data);

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo la eliminacion del registro de la configuracion de la prenda. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de eliminar la informacion de la configuracion de la prenda en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataMunamuInventoryException.create(userMessage, technicalMessage, exception);
		}

	}

	@Override
	public void create(GarmentConfigurationEntity data) {

		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO GarmentConfiguration(id, genre, category, typeGarment) VALUES (?, ?, ?, ?) ");

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {

			preparedStatement.setObject(1, data.getId());
			preparedStatement.setObject(2, data.getGenre().getId());
			preparedStatement.setObject(3, data.getCategory().getId());
			preparedStatement.setObject(4, data.getTypeGarment().getId());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el registro de la informacion de la nueva configuracion de la prenda. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la informacion de la nueva  configuracion de la prenda en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataMunamuInventoryException.create(userMessage, technicalMessage, exception);
		}

	}

	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT gc.id,gc.category, c.name AS category_name,gc.genre, g.name AS genre_name, gc.typeGarment, tg.name AS type_garment_name ");
	}

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM GarmentConfiguration gc ");
	}
	
	private void createJoin(final StringBuilder statement) {
		statement.append("JOIN Category c ON gc.category = c.id JOIN Genre g ON gc.genre = g.id JOIN TypeGarment tg ON gc.typeGarment = tg.id ");
	}

	private void createWhere(final StringBuilder statemet, final GarmentConfigurationEntity filter,
			final ArrayList<Object> parameters) {
		if(!UUIDHelper.isDefault(filter.getId())) {
			statemet.append("WHERE id = ? ");
			parameters.add(filter.getId());
		}
		if(!ObjectHelper.isNull(filter.getCategory())) {
			statemet.append((parameters.isEmpty()) ?"WHERE "  : "AND ");
			statemet.append("category = ? ");
			parameters.add(filter.getCategory().getId());
		}
		if(!ObjectHelper.isNull(filter.getGenre())) {
			statemet.append((parameters.isEmpty()) ?"WHERE "  : "AND ");
			statemet.append("genre = ? ");
			parameters.add(filter.getGenre().getId());
		}
		if(!ObjectHelper.isNull(filter.getTypeGarment())) {
			statemet.append((parameters.isEmpty()) ?"WHERE "  : "AND ");
			statemet.append("typeGarment = ? ");
			parameters.add(filter.getTypeGarment().getId());
		}
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY category ASC ");
	}

}
