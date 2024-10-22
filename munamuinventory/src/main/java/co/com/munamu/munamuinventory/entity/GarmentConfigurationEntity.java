package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentConfigurationEntity extends DomainEntity{
	
	private GenreEntity genre;
	private CategoryEntity category;
	private TypeGarmentEntity typeGarment;
	
	public GarmentConfigurationEntity() {
		super(UUIDHelper.getDefault());
		setGenre(GenreEntity.create());
		setTypeGarment(TypeGarmentEntity.create());
		setCategory(CategoryEntity.create());
	}
	
	public static final GarmentConfigurationEntity create() {
		return new GarmentConfigurationEntity();
	}

	public GenreEntity getGenre() {
		return genre;
	}

	public GarmentConfigurationEntity setGenre(final GenreEntity genre) {
		this.genre = ObjectHelper.getDefault(genre, GenreEntity.create());
		return this;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public GarmentConfigurationEntity setCategory(final CategoryEntity category) {
		this.category = ObjectHelper.getDefault(category, CategoryEntity.create());
		return this;
	}

	public TypeGarmentEntity getTypeGarment() {
		return typeGarment;
	}

	public GarmentConfigurationEntity setTypeGarment(final TypeGarmentEntity typeGarment) {
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
