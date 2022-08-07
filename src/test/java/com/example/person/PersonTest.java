package com.example.person;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testSetPersonId() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		person.setPersonId(1);
		Field field = Person.class.getDeclaredField("personId");
		field.setAccessible(true);
		assertThat(Integer.valueOf(String.valueOf(field.get(person))), is(Integer.valueOf(1)));
	}

	@Test
	void testGetPersonId() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		Field field = Person.class.getDeclaredField("personId");
		field.setAccessible(true);
		field.setInt(person, 1);
		assertThat(Integer.valueOf(person.getPersonId()), is(Integer.valueOf(1)));

		Person personUnSet = new Person();
		assertThat(Integer.valueOf(personUnSet.getPersonId()), is(Integer.valueOf(0)));
	}

	@Test
	void testSetFirstName() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		person.setFirstName("Yuichi");
		Field field = Person.class.getDeclaredField("firstName");
		field.setAccessible(true);
		assertThat(String.valueOf(field.get(person)), is("Yuichi"));
	}

	@Test
	void testGetFirstName() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		Field field = Person.class.getDeclaredField("firstName");
		field.setAccessible(true);
		field.set(person, "Yuichi");
		assertThat(person.getFirstName(), is("Yuichi"));

		Person personUnSet = new Person();
		assertNull(personUnSet.getFirstName());
	}

	@Test
	void testSetLastName() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		person.setLastName("Tanaka");
		Field field = Person.class.getDeclaredField("lastName");
		field.setAccessible(true);
		assertThat(String.valueOf(field.get(person)), is("Tanaka"));
	}

	@Test
	void testGetLastName() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		Field field = Person.class.getDeclaredField("lastName");
		field.setAccessible(true);
		field.set(person, "Tanaka");
		assertThat(person.getLastName(), is("Tanaka"));

		Person personUnSet = new Person();
		assertNull(personUnSet.getLastName());
	}

	@Test
	void testSetBirthDate() throws ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		Date birthDate = getBirthDate();

		person.setBirthDate(birthDate);
		Field field = Person.class.getDeclaredField("birthDate");
		field.setAccessible(true);
		assertThat((Date)field.get(person), is(birthDate));
	}

	@Test
	void testGetBirthDate() throws ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Person person = new Person();
		Date birthDate = getBirthDate();
		Field field = Person.class.getDeclaredField("birthDate");
		field.setAccessible(true);
		field.set(person, birthDate);
		assertThat(person.getBirthDate(), is(birthDate));

		Person personUnSet = new Person();
		assertNull(personUnSet.getBirthDate());
	}

	private Date getBirthDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		return sdf.parse("1990-01-05");
	}

}
