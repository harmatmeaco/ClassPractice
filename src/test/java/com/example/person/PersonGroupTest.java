package com.example.person;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

class PersonGroupTest {

	@Test
	void testAddGroupMember() throws ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		PersonGroup group = new PersonGroup(1, "Group1");
		Field field = PersonGroup.class.getDeclaredField("groupMembers");
		field.setAccessible(true);
		assertTrue(((List<Person>)field.get(group)).isEmpty());

		Person person1 = getPerson(1, "Taichi", "Suzuki", "1980-12-05");
		Person person2 = getPerson(2, "Mari", "Yamada", "1984-05-24");
		Person person3 = getPerson(3, "Max", "Damon", "1989-08-09");
		Person person4 = getPerson(4, "Ha-yoon", "Lee", "1995-10-31");

		group.addGroupMember(person1);
		assertThat((List<Person>)field.get(group), hasItems(person1));

		group.addGroupMember(person2);
		assertThat((List<Person>)field.get(group), hasItems(person2));

		group.addGroupMember(person3);
		assertThat((List<Person>)field.get(group), hasItems(person3));

		group.addGroupMember(person4);
		assertThat((List<Person>)field.get(group), hasItems(person4));

	}

	@Test
	void testContainsPerson() throws NoSuchFieldException, SecurityException, ParseException, IllegalArgumentException,
			IllegalAccessException {
		List<Person> groupMembers = new ArrayList<>();
		groupMembers.add(getPerson(1, "Taichi", "Suzuki", "1980-12-05"));
		groupMembers.add(getPerson(2, "Mari", "Yamada", "1984-05-24"));
		groupMembers.add(getPerson(3, "Max", "Damon", "1989-08-09"));
		groupMembers.add(getPerson(4, "Ha-yoon", "Lee", "1995-10-31"));

		PersonGroup group = new PersonGroup(1, "Group1");
		Field field = PersonGroup.class.getDeclaredField("groupMembers");
		field.setAccessible(true);

		field.set(group, groupMembers);
		assertTrue(group.contains(getPerson(1, "Taichi", "Suzuki", "1980-12-05")));
		assertFalse(group.contains(getPerson(9, "Leon", "Zhang", "1985-04-15")));
	}

	@Test
	void testContainsInt() throws ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		List<Person> groupMembers = new ArrayList<>();
		groupMembers.add(getPerson(1, "Taichi", "Suzuki", "1980-12-05"));
		groupMembers.add(getPerson(2, "Mari", "Yamada", "1984-05-24"));
		groupMembers.add(getPerson(3, "Max", "Damon", "1989-08-09"));
		groupMembers.add(getPerson(4, "Ha-yoon", "Lee", "1995-10-31"));

		PersonGroup group = new PersonGroup(1, "Group1");
		Field field = PersonGroup.class.getDeclaredField("groupMembers");
		field.setAccessible(true);

		field.set(group, groupMembers);
		assertTrue(group.contains(2));
		assertFalse(group.contains(9));
	}

	private Person getPerson(int personId, String firstName, String lastName, String birthDate) throws ParseException {
		Person person = new Person();
		person.setPersonId(personId);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setBirthDate(getDate(birthDate));

		return person;
	}

	private Date getDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		return sdf.parse(date);
	}

}
