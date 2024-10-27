package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GarmentDomain;
import co.com.munamu.munamuinventory.entity.GarmentEntity;

public class GarmentEntityAdapter implements Adapter<GarmentDomain,GarmentEntity> {

	@Override
	public GarmentDomain adaptSource(final GarmentEntity data) {
		return null;
	}
	
	@Override
	public GarmentEntity adaptTarget(final GarmentDomain data) {
		return null;
	}
}


