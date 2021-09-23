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
		// TODO 実装してください
	}

	public void addGroups(List<PersonGroup> groups) {
		// TODO 実装してください
	}

	public int[] getGroupMemberCounts() {
		int[] counts = new int[3];

		// TODO 実装してください

		return counts;
	}

	public List<Integer> getGroupMemberCountsList() {
		List<Integer> counts = new ArrayList<>();

		// TODO 実装してください

		return counts;
	}
}
