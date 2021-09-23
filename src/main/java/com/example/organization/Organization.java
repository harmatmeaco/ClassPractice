package com.example.organization;

import java.util.ArrayList;
import java.util.List;

import com.example.person.PersonGroup;

public class Organization {

	private final int organizationId;
	private String organizationName;
	private List<PersonGroup> groups = new ArrayList<>();

	public Organization(int organizationId, String organizationName) {
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void addGroup(PersonGroup group) {
		this.groups.add(group);
	}

	public void addGroups(List<PersonGroup> groups) {
		this.groups.addAll(groups);
	}

	public int[] getGroupMemberCounts() {
		int[] counts = new int[3];

		for (int i = 0; i < groups.size(); i++) {
			counts[i] = groups.get(i).getGroupMembers().size();
		}

		return counts;
	}

	public List<Integer> getGroupMemberCountsList() {
		List<Integer> counts = new ArrayList<>();

		for (PersonGroup group : groups) {
			counts.add(Integer.valueOf(group.getGroupMembers().size()));
		}

		return counts;
	}
}
