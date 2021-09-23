package com.example.person;

import java.util.ArrayList;
import java.util.List;

/**
 * PersonGroupクラスは人のグループを表すクラスです。
 * 以下の情報を保持します。
 * - グループID
 * - グループ名
 * - グループのメンバー
 * @author TAKASHIMA, Yusuke
 *
 */
public class PersonGroup {

	private final int groupId;
	private String groupName;
	private List<Person> groupMembers;

	public PersonGroup(int groupId, String groupName) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupMembers = new ArrayList<>();
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public List<Person> getGroupMembers() {
		return this.groupMembers;
	}

	/**
	 * グループに人（メンバー）を追加します。
	 * @param person
	 */
	public void addGroupMember(Person person) {
		this.groupMembers.add(person);
	}

	public void addGroupMembers(List<Person> members) {
		this.groupMembers.addAll(members);
	}

	/**
	 * このグループに、特定の人（Person）が含まれているかを返します。
	 * @param person
	 * @return true if this group contains the argument person, false if not
	 */
	public boolean contains(Person person) {
		for (Person member : groupMembers) {
			if (member.equals(person)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * このグループに、特定の個人番号を持つ人（Person）が含まれているかを返します。
	 * @param personId
	 * @return true if this group contains a person whose personId matches the arguement personId, false if not
	 */
	public boolean contains(int personId) {
		for (Person member : groupMembers) {
			if (member.getPersonId() == personId) {
				return true;
			}
		}
		return false;
	}
}
