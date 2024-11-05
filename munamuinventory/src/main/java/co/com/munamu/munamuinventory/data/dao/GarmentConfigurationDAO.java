package co.com.munamu.munamuinventory.data.dao;

import java.util.UUID;

import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;

public interface GarmentConfigurationDAO extends RetrieveDAO<GarmentConfigurationEntity, UUID>,DeleteDAO<UUID>,CreateDAO<GarmentConfigurationEntity>{

}
