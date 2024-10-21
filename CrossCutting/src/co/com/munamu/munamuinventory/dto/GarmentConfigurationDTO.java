package co.com.munamu.munamuinventory.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentConfigurationDTO extends DomainDTO{
	
	private GenreDTO genre;
	private CategoryDTO category;
	private TypeGarmentDTO typeGarment;
	
	public GarmentConfigurationDTO() {
		super(UUIDHelper.getDefaultAssString());
		setGenre(GenreDTO.create());
		setTypeGarment(TypeGarmentDTO.create());
		setCategory(CategoryDTO.create());
	}
	
	public static final GarmentConfigurationDTO create() {
		return new GarmentConfigurationDTO();
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public GarmentConfigurationDTO setGenre(final GenreDTO genre) {
		this.genre = ObjectHelper.getDefault(genre, GenreDTO.create());
		return this;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public GarmentConfigurationDTO setCategory(final CategoryDTO category) {
		this.category = ObjectHelper.getDefault(category, CategoryDTO.create());
		return this;
	}

	public TypeGarmentDTO getTypeGarment() {
		return typeGarment;
	}

	public GarmentConfigurationDTO setTypeGarment(final TypeGarmentDTO typeGarment) {
		this.typeGarment = ObjectHelper.getDefault(typeGarment, TypeGarmentDTO.create());
		return this;
	}
	
	public GarmentConfigurationDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public  String getId() {
		return super.getId();
	}	
	
}
