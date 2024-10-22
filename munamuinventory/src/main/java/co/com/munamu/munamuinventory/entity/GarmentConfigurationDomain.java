package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentConfigurationDomain extends DomainEntity{
	
	private GenreDomain genre;
	private CategoryEntity category;
	private TypeGarmentEntity typeGarment;
	
	public GarmentConfigurationDomain() {
		super(UUIDHelper.getDefault());
		setGenre(GenreDomain.create());
		setTypeGarment(TypeGarmentEntity.create());
		setCategory(CategoryEntity.create());
	}
	
	public static final GarmentConfigurationDomain create() {
		return new GarmentConfigurationDomain();
	}

	public GenreDomain getGenre() {
		return genre;
	}

	public GarmentConfigurationDomain setGenre(final GenreDomain genre) {
		this.genre = ObjectHelper.getDefault(genre, GenreDomain.create());
		return this;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public GarmentConfigurationDomain setCategory(final CategoryEntity category) {
		this.category = ObjectHelper.getDefault(category, CategoryEntity.create());
		return this;
	}

	public TypeGarmentEntity getTypeGarment() {
		return typeGarment;
	}

	public GarmentConfigurationDomain setTypeGarment(final TypeGarmentEntity typeGarment) {
		this.typeGarment = ObjectHelper.getDefault(typeGarment, TypeGarmentEntity.create());
		return this;
	}
	
	@Override
	public void setId(final UUID id) {
		super.setId(id);
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}	
	
}
