package com.talent.exchange.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.talent.exchange.demo.model.MoUserEnum.GENDER;
import com.talent.exchange.demo.model.MoUserEnum.USER_ACCOUNT_STATUS;
import com.talent.exchange.demo.model.MoUserEnum.USER_TYPE;

@NamedQueries({
	@NamedQuery(name = "artist.by.isNotDeleted", query = "from MoUser user where user.isArtist = true and user.isDeleted = false"),
	@NamedQuery(name = "fan.bio", query = "from MoUser user where user.isFan = true and user.isDeleted = false")	
})

@Entity
@Table(name = "tex_user")
public class MoUser extends MoBase{
	
	public static final String QUERY_TO_GET_ALL_ARTISTS = "artist.by.isNotDeleted";
	public static final String QUERY_FAN_BIO = "fan.bio";
	
	@Column(name = "user_name", nullable = false, length = 255)
	private String userName;

	@Column(name = "password", nullable = true, length = 255)
	private String password;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;

	@Column(name = "gender", length = 2)
	@Enumerated(EnumType.STRING)
	private GENDER gender;

	@Column(name = "email", length = 128)
	private String email;

	@Column(name = "mobile", length = 30)
	private String mobile;

	@Column(name = "locale", length = 30)
	private String locale;

	@Column(name = "email_verified")
	private boolean isEmailVerified = false;

	@Column(name = "account_deleted")
	private boolean isDeleted = false;
	
	@Column(name = "is_fan")
	private boolean isFan; // default true;
	
	@Column(name = "is_artist")
	private boolean isArtist;
	
	@Column(name = "is_talent")
	private boolean isTalent;
	
	@Column(name = "is_Investor")
	private boolean isInvestor;  // for time being true	
	
	@Column(name = "user_type", length = 16)
	@Enumerated(EnumType.STRING)
	private USER_TYPE userType = USER_TYPE.FAN;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private MoUserProfile userProfile;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_user_address_useraddress"))
	private MoAddress address;
	
	@Column(name = "reset_password")
	private boolean resetPassword;

	@Column(name = "account_status", length = 16)
	@Enumerated(EnumType.STRING)
	private USER_ACCOUNT_STATUS accountStatus = USER_ACCOUNT_STATUS.ACTIVE;

	@Column(name = "accepted_tou")
	private boolean acceptedTermsOfUsage;

	@Column(name = "random_salt")
	private String randomSalt;
	
	@Column(name = "phone", length = 30)
	private String phone;

	@Column(name = "dial_code", length = 16)
	private String dialcode;
	
	@Column(name = "token", nullable = true, length = 255)
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public MoUser() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public USER_TYPE getUserType() {
		return userType;
	}

	public void setAuthType(USER_TYPE userType) {
		this.userType = userType;
	}

	public MoAddress getAddress() {
		return address;
	}

	public void setAddress(MoAddress address) {
		this.address = address;
	}

	public MoUserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(MoUserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public boolean isResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}	

	public boolean isAcceptedTermsOfUsage() {
		return acceptedTermsOfUsage;
	}

	public void setAcceptedTermsOfUsage(boolean acceptedTermsOfUsage) {
		this.acceptedTermsOfUsage = acceptedTermsOfUsage;
	}

	@Override
	public String toString() {
		return "MoUser [userName=" + userName + ", id=" + getId() + "]";
	}

	public String getRandomSalt() {
		return randomSalt;
	}

	public void setRandomSalt(String randomSalt) {
		this.randomSalt = randomSalt;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDialcode() {
		return dialcode;
	}

	public void setDialcode(String dialcode) {
		this.dialcode = dialcode;
	}
	
	public boolean isFan() {
		return isFan;
	}

	public void setFan(boolean isFan) {
		this.isFan = isFan;
	}

	public boolean isArtist() {
		return isArtist;
	}

	public void setArtist(boolean isArtist) {
		this.isArtist = isArtist;
	}

	public boolean isTalent() {
		return isTalent;
	}

	public void setTalent(boolean isTalent) {
		this.isTalent = isTalent;
	}

	public boolean isInvestor() {
		return isInvestor;
	}

	public void setInvestor(boolean isInvestor) {
		this.isInvestor = isInvestor;
	}

	public USER_ACCOUNT_STATUS getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(USER_ACCOUNT_STATUS accountStatus) {
		this.accountStatus = accountStatus;
	}

}
