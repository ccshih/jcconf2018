package com.example.jcconf2018.model;

public class Bark extends Dialect {

	public Bark() {
		super();
	}

	public Bark(Dialect dialect) {
		super(dialect);
	}
	
	@Override
	protected String myDialect() {
		return "Bark! ";
	}

	@Override
	protected String speaker() {
		return "Dog";
	}

}
