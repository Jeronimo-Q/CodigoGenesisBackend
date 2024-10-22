package co.com.munamu.munamuinventory.data.dao;

import java.util.UUID;

import co.com.munamu.munamuinventory.entity.GarmentEntity;

public interface GarmentDAO extends RetrieveDAO<GarmentEntity, UUID>,DeleteDAO<GarmentEntity>,CreateDAO<GarmentEntity>{

}
