package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GenreDomain extends Domain{
	
	private String name;
	
	private GenreDomain(final UUID id , final String name) {
		super (id);
		setName(name);
	}
	
	public static GenreDomain create(final UUID id , final String name) {
		return new GenreDomain(id, name);
	}
	
	static final GenreDomain create() {
		return new GenreDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
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
