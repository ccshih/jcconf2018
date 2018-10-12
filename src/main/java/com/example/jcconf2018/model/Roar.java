package com.example.jcconf2018.model;

public class Roar extends Dialect {

	public Roar() {
		super();
	}

	@Override
	protected String myDialect() {
		return "Roar!! ";
	}

	@Override
	protected String speaker() {
		return "Lion";
	}

}
