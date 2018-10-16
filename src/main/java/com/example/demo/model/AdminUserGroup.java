package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the admin_user_group database table.
 * 
 */
@Entity
@Table(name="admin_user_group")
@NamedQuery(name="AdminUserGroup.findAll", query="SELECT a FROM AdminUserGroup a")
public class AdminUserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="admin_group_id")
	private int adminGroupId;

	//bi-directional many-to-one association to AdminUser
	@ManyToOne
	@JoinColumn(name="admin_user_id")
	private AdminUser adminUser;

	public AdminUserGroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdminGroupId() {
		return this.adminGroupId;
	}

	public void setAdminGroupId(int adminGroupId) {
		this.adminGroupId = adminGroupId;
	}

	public AdminUser getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

}