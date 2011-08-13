package com.entities;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, String userName, String password,
			String emailAddress, Short isVaildate) {
		super(userId, userName, password, emailAddress, (short) 0, (short) 0,
				(short) 0, (short) 0, (short) 0, isVaildate, (short) 0);
	}

	/** full constructor */
	public User(String userId, String userName, String password,
			String emailAddress, String nickName, String firstName,
			Short isFirstNamePublic, String lastName, Short isLastNamePublic,
			String yearOfBirth, Short isYearOfBirthPublic, Integer favGenre,
			Short isFavGenrePublic, String favActors, Short isFavActorsPublic,
			String roleId, Short isVaildate) {
		super(userId, userName, password, emailAddress, nickName, firstName,
				isFirstNamePublic, lastName, isLastNamePublic, yearOfBirth,
				isYearOfBirthPublic, favGenre, isFavGenrePublic, favActors,
				isFavActorsPublic, roleId, isVaildate, (short) 0 );
	}

	public String getNickName() {
		if (super.getNickName() == null)
			return "";
		else
			return super.getNickName();
	}

	public String getFirstName() {
		if (super.getFirstName() == null)
			return "";
		else
			return super.getFirstName();
	}

	public String getLastName() {
		if (super.getLastName() == null)
			return "";
		return super.getLastName();
	}

	public String getYearOfBirth() {
		if (super.getYearOfBirth() == null)
			return "";
		else
			return super.getYearOfBirth();
	}

	public String getFavActors() {
		if (super.getFavActors() == null)
			return "";
		return super.getFavActors();
	}
	
	public String getPublicFirstName() {
		if (super.getIsFirstNamePublic() == 1)
			return "checked";
		else
			return "";
	}
	
	public String getPublicLastName() {
		if (super.getIsLastNamePublic() ==1)
			return "checked";
		else
			return "";
	}
	
	public String getPublicYearOfBirth() {
		if (super.getIsYearOfBirthPublic() ==1)
			return "checked";
		else
			return "";
	}
	
	public String getPublicFavActors() {
		if (super.getIsFavActorsPublic() ==1)
			return "checked";
		else
			return "";
	}
	
	public String getPublicFavGenre() {
		if (super.getIsFavGenrePublic() ==1)
			return "checked";
		else
			return "";
	}
	
	public String getCheckedCompletePrivate() {
		if (super.getIsCompletePrivate() ==1)
			return "checked";
		else
			return "";
	}

}
