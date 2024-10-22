package co.com.munamu.munamuinventory.data.dao;

import java.util.UUID;

import co.com.munamu.munamuinventory.entity.CategoryEntity;

public interface GarmentDAO extends RetrieveDAO<CategoryEntity, UUID>,DeleteDAO<CategoryEntity>,CreateDAO<CategoryEntity>{

}
