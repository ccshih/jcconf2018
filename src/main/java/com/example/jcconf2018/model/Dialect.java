package com.example.jcconf2018.model;

public abstract class Dialect {
	
	protected String message;
	protected abstract String myDialect();
	protected abstract String speaker();
	
	public Dialect() {
	}
	
	public Dialect(Dialect dialect) {
		setMessage(dialect.getClass().getSimpleName() + " speaks: " + dialect.getMessage());
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toWords() {
		return myDialect() + message;
	}
	
}
