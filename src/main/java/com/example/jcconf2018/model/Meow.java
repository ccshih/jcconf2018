package com.example.jcconf2018.model;

public class Meow extends Dialect {

	public Meow() {
		super();
	}

	public Meow(Dialect dialect) {
		super(dialect);
	}
	
	@Override
	protected String myDialect() {
		return "Meow! ";
	}

	@Override
	protected String speaker() {
		return "Cat";
	}
	
}
