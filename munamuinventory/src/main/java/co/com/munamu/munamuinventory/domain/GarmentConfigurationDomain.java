package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;


public class GarmentConfigurationDomain extends Domain{

	private CategoryDomain category;
	private GenreDomain genre;
	private TypeGarmentDomain typeGarment;
	
	private GarmentConfigurationDomain(final UUID id ,final CategoryDomain category,final GenreDomain genre,final TypeGarmentDomain typeGarment) {
		super (id);
		setCategory(category);
		setGenre(genre);
		setTypeGarment(typeGarment);
	}
	
	public static final GarmentConfigurationDomain create(final UUID id , final CategoryDomain category,final GenreDomain genre,final TypeGarmentDomain typeGarment) {
		return new GarmentConfigurationDomain(id, category, genre, typeGarment);
	}
	
    static final GarmentConfigurationDomain create() {
		return new GarmentConfigurationDomain(UUIDHelper.getDefault(), CategoryDomain.create(), GenreDomain.create(), TypeGarmentDomain.create());
	}

	public GenreDomain getGenre() {
		return genre;
	}

	private void setGenre(final GenreDomain genre) {
		this.genre = ObjectHelper.getDefault(genre, GenreDomain.create());
	}

	public CategoryDomain getCategory() {
		return category;
	}

	private void setCategory(final CategoryDomain category) {
		this.category = ObjectHelper.getDefault(category, CategoryDomain.create());
	}

	public TypeGarmentDomain getTypeGarment() {
		return typeGarment;
	}

	private void setTypeGarment(final TypeGarmentDomain typeGarment) {
		this.typeGarment = ObjectHelper.getDefault(typeGarment, TypeGarmentDomain.create());
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
