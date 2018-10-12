package com.example.jcconf2018.model;

public class Howl extends Dialect {

	public Howl() {
		super();
	}
	
	@Override
	protected String myDialect() {
		return "Howl~ ";
	}

	@Override
	protected String speaker() {
		return "Wolf";
	}

}
