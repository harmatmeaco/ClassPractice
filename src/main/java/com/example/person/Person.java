package com.example.person;

import java.util.Date;

public class Person {

	private int personId = 0;
	private String firstName;
	private String lastName;
	private Date birthDate;

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getPersonId() {
		return personId;
	}

	//TODO personId以外のgetterとsetterを実装してください。

}
