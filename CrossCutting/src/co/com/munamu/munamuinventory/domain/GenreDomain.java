package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;

public class GenreDomain extends Domain{
	
	private String name;
	
	private GenreDomain(final UUID id , final String name) {
		super (id);
		setName(name);
	}
	
	public static final GenreDomain create(final UUID id , final String name) {
		return new GenreDomain(id, name);
	}
	
	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	protected  UUID getId() {
		return super.getId();
	}
	

}
