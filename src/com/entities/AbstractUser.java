package com.entities;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String password;
	private String emailAddress;
	private String nickName;
	private String firstName;
	private Short isFirstNamePublic;
	private String lastName;
	private Short isLastNamePublic;
	private String yearOfBirth;
	private Short isYearOfBirthPublic;
	private Integer favGenre;
	private Short isFavGenrePublic;
	private String favActors;
	private Short isFavActorsPublic;
	private String roleId;
	private Short isVaildate;
	private Short isCompletePrivate;

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(String userId, String userName, String password,
			String emailAddress, Short isFirstNamePublic,
			Short isLastNamePublic, Short isYearOfBirthPublic,
			Short isFavGenrePublic, Short isFavActorsPublic, Short isVaildate,
			Short isCompletePrivate) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.isFirstNamePublic = isFirstNamePublic;
		this.isLastNamePublic = isLastNamePublic;
		this.isYearOfBirthPublic = isYearOfBirthPublic;
		this.isFavGenrePublic = isFavGenrePublic;
		this.isFavActorsPublic = isFavActorsPublic;
		this.isVaildate = isVaildate;
		this.isCompletePrivate = isCompletePrivate;
	}

	/** full constructor */
	public AbstractUser(String userId, String userName, String password,
			String emailAddress, String nickName, String firstName,
			Short isFirstNamePublic, String lastName, Short isLastNamePublic,
			String yearOfBirth, Short isYearOfBirthPublic, Integer favGenre,
			Short isFavGenrePublic, String favActors, Short isFavActorsPublic,
			String roleId, Short isVaildate, Short isCompletePrivate) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.nickName = nickName;
		this.firstName = firstName;
		this.isFirstNamePublic = isFirstNamePublic;
		this.lastName = lastName;
		this.isLastNamePublic = isLastNamePublic;
		this.yearOfBirth = yearOfBirth;
		this.isYearOfBirthPublic = isYearOfBirthPublic;
		this.favGenre = favGenre;
		this.isFavGenrePublic = isFavGenrePublic;
		this.favActors = favActors;
		this.isFavActorsPublic = isFavActorsPublic;
		this.roleId = roleId;
		this.isVaildate = isVaildate;
		this.isCompletePrivate = isCompletePrivate;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Short getIsFirstNamePublic() {
		return this.isFirstNamePublic;
	}

	public void setIsFirstNamePublic(Short isFirstNamePublic) {
		this.isFirstNamePublic = isFirstNamePublic;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Short getIsLastNamePublic() {
		return this.isLastNamePublic;
	}

	public void setIsLastNamePublic(Short isLastNamePublic) {
		this.isLastNamePublic = isLastNamePublic;
	}

	public String getYearOfBirth() {
		return this.yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public Short getIsYearOfBirthPublic() {
		return this.isYearOfBirthPublic;
	}

	public void setIsYearOfBirthPublic(Short isYearOfBirthPublic) {
		this.isYearOfBirthPublic = isYearOfBirthPublic;
	}

	public Integer getFavGenre() {
		return this.favGenre;
	}

	public void setFavGenre(Integer favGenre) {
		this.favGenre = favGenre;
	}

	public Short getIsFavGenrePublic() {
		return this.isFavGenrePublic;
	}

	public void setIsFavGenrePublic(Short isFavGenrePublic) {
		this.isFavGenrePublic = isFavGenrePublic;
	}

	public String getFavActors() {
		return this.favActors;
	}

	public void setFavActors(String favActors) {
		this.favActors = favActors;
	}

	public Short getIsFavActorsPublic() {
		return this.isFavActorsPublic;
	}

	public void setIsFavActorsPublic(Short isFavActorsPublic) {
		this.isFavActorsPublic = isFavActorsPublic;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Short getIsVaildate() {
		return this.isVaildate;
	}

	public void setIsVaildate(Short isVaildate) {
		this.isVaildate = isVaildate;
	}

	public Short getIsCompletePrivate() {
		return this.isCompletePrivate;
	}

	public void setIsCompletePrivate(Short isCompletePrivate) {
		this.isCompletePrivate = isCompletePrivate;
	}

}