package com.example.organization;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.person.Person;
import com.example.person.PersonGroup;
import com.opencsv.bean.CsvToBeanBuilder;

class OrganizationTest {

	@Test
	void testGetGroupMemberCounts() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		Organization organization = new Organization(1, "HQ");
		organization.addGroups(getPersonGroups());

		int[] counts = organization.getGroupMemberCounts();
		int[] expected = new int[] { 4, 5, 3 };

		assertThat(counts, is(expected));
	}

	@Test
	void testGetGroupMemberCountsList() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		Organization organization = new Organization(1, "HQ");
		organization.addGroups(getPersonGroups());

		List<Integer> counts = organization.getGroupMemberCountsList();
		List<Integer> expected = new ArrayList<>();
		expected.add(Integer.valueOf(4));
		expected.add(Integer.valueOf(5));
		expected.add(Integer.valueOf(3));

		assertThat(counts, is(expected));
	}

	private List<PersonGroup> getPersonGroups() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		PersonGroup group1 = new PersonGroup(1, "Group1");
		group1.addGroupMembers(getGroupMembers("Group1.csv"));

		PersonGroup group2 = new PersonGroup(2, "Group2");
		group2.addGroupMembers(getGroupMembers("Group2.csv"));

		PersonGroup group3 = new PersonGroup(3, "Group3");
		group3.addGroupMembers(getGroupMembers("Group3.csv"));

		List<PersonGroup> groups = new ArrayList<>();
		groups.add(group1);
		groups.add(group2);
		groups.add(group3);
		return groups;
	}

	private List<Person> getGroupMembers(String filePath) throws UnsupportedEncodingException, FileNotFoundException,
			IOException {
		List<Person> groupMembers = null;

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.getClass()
				.getResource(filePath).getPath()), "UTF-8"))) {
			CsvToBeanBuilder<Person> builder = new CsvToBeanBuilder<Person>(reader);
			builder.withType(Person.class);

			groupMembers = builder.build().parse();
		}
		return groupMembers;
	}

}
