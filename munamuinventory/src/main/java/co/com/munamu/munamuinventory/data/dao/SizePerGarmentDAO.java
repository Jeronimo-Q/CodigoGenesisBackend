package co.com.munamu.munamuinventory.data.dao;

import java.util.UUID;

import co.com.munamu.munamuinventory.entity.SizePerGarmentEntity;

public interface SizePerGarmentDAO extends RetrieveDAO<SizePerGarmentEntity, UUID>,DeleteDAO<UUID>,CreateDAO<SizePerGarmentEntity>{

}
