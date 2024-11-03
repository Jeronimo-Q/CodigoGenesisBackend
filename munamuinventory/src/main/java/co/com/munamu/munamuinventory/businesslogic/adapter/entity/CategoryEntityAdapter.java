package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.entity.CategoryEntity;

public final class CategoryEntityAdapter implements Adapter<CategoryDomain,CategoryEntity> {
	private static final Adapter<CategoryDomain,CategoryEntity> instance = new CategoryEntityAdapter();
	
	private CategoryEntityAdapter() {
		
	}
	
	public static Adapter<CategoryDomain,CategoryEntity> getCategoryEntityAdapter(){
		return instance;
	}
	
	@Override
	public CategoryDomain adaptTarjet(final CategoryEntity data) {
		var entityToAdapt=ObjectHelper.getDefault(data,CategoryEntity.create());
		return CategoryDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}
	
	@Override
	public CategoryEntity adaptSource(final CategoryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				CategoryDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new CategoryEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}
}


