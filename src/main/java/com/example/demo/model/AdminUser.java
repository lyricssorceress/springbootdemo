package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the admin_user database table.
 * 
 */
@Entity
@Table(name = "admin_user")
@EntityListeners(AuditingEntityListener.class)
@NamedQuery(name = "AdminUser.findAll", query = "SELECT a FROM AdminUser a")
public class AdminUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "admin_level")
	private byte adminLevel;

	@Column(name = "admin_role_id")
	private int adminRoleId;

	@Column(name = "admin_token", length = 10)
	private String adminToken;

	@Column(length = 11)
	private String cell;

	@Column(name = "cell_company_count")
	private int cellCompanyCount;

	@Column(name = "cell_row_count")
	private int cellRowCount;

	@Column(name = "company_count")
	private int companyCount;

	@Column(name = "company_id")
	private int companyId;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Timestamp createdAt;

	@Column(name = "gang_id")
	private int gangId;

	@Column(name = "investor_refresh_interval")
	private int investorRefreshInterval;

	@Column(name = "managed_accounts", length = 1000)
	private String managedAccounts;

	@Column(name = "managed_companies", length = 1000)
	private String managedCompanies;

	@Column(name = "managed_groups", length = 1000)
	private String managedGroups;

	@Column(length = 30)
	private String nickname;

	@Column(length = 100)
	private String password;

	@Column(name = "register_date", nullable = false)
	private Timestamp registerDate;

	@Column(name = "retry_count")
	private int retryCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "retry_start_date")
	private Date retryStartDate;

	@Column(name = "retry_threshold")
	private int retryThreshold;

	@Column(name = "row_count")
	private int rowCount;

	@Column(length = 100)
	private String salt;

	private byte status;

	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	private Timestamp updatedAt;

	@Column(length = 50)
	private String username;

	// bi-directional many-to-one association to AdminUserGroup
	@OneToMany(mappedBy = "adminUser")
	private List<AdminUserGroup> adminUserGroups;

	public AdminUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAdminLevel() {
		return this.adminLevel;
	}

	public void setAdminLevel(byte adminLevel) {
		this.adminLevel = adminLevel;
	}

	public int getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(int adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	public String getAdminToken() {
		return this.adminToken;
	}

	public void setAdminToken(String adminToken) {
		this.adminToken = adminToken;
	}

	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public int getCellCompanyCount() {
		return this.cellCompanyCount;
	}

	public void setCellCompanyCount(int cellCompanyCount) {
		this.cellCompanyCount = cellCompanyCount;
	}

	public int getCellRowCount() {
		return this.cellRowCount;
	}

	public void setCellRowCount(int cellRowCount) {
		this.cellRowCount = cellRowCount;
	}

	public int getCompanyCount() {
		return this.companyCount;
	}

	public void setCompanyCount(int companyCount) {
		this.companyCount = companyCount;
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getGangId() {
		return this.gangId;
	}

	public void setGangId(int gangId) {
		this.gangId = gangId;
	}

	public int getInvestorRefreshInterval() {
		return this.investorRefreshInterval;
	}

	public void setInvestorRefreshInterval(int investorRefreshInterval) {
		this.investorRefreshInterval = investorRefreshInterval;
	}

	public String getManagedAccounts() {
		return this.managedAccounts;
	}

	public void setManagedAccounts(String managedAccounts) {
		this.managedAccounts = managedAccounts;
	}

	public String getManagedCompanies() {
		return this.managedCompanies;
	}

	public void setManagedCompanies(String managedCompanies) {
		this.managedCompanies = managedCompanies;
	}

	public String getManagedGroups() {
		return this.managedGroups;
	}

	public void setManagedGroups(String managedGroups) {
		this.managedGroups = managedGroups;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public int getRetryCount() {
		return this.retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public Date getRetryStartDate() {
		return this.retryStartDate;
	}

	public void setRetryStartDate(Date retryStartDate) {
		this.retryStartDate = retryStartDate;
	}

	public int getRetryThreshold() {
		return this.retryThreshold;
	}

	public void setRetryThreshold(int retryThreshold) {
		this.retryThreshold = retryThreshold;
	}

	public int getRowCount() {
		return this.rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AdminUserGroup> getAdminUserGroups() {
		return this.adminUserGroups;
	}

	public void setAdminUserGroups(List<AdminUserGroup> adminUserGroups) {
		this.adminUserGroups = adminUserGroups;
	}

	public AdminUserGroup addAdminUserGroup(AdminUserGroup adminUserGroup) {
		getAdminUserGroups().add(adminUserGroup);
		adminUserGroup.setAdminUser(this);

		return adminUserGroup;
	}

	public AdminUserGroup removeAdminUserGroup(AdminUserGroup adminUserGroup) {
		getAdminUserGroups().remove(adminUserGroup);
		adminUserGroup.setAdminUser(null);

		return adminUserGroup;
	}

}