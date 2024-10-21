package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class CategoryDomain extends Domain{
	
	private String name;
	
	private CategoryDomain(final UUID id , final String name) {
		super (id);
		setName(name);
	}
	
	public static CategoryDomain create(final UUID id , final String name) {
		return new CategoryDomain(id,name);
	}
	
	static final CategoryDomain create() {
		return new CategoryDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
