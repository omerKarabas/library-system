package com.sahabt.library.applications;

import java.util.Optional;

import com.sahabt.library.domain.user.IdentityNo;
import com.sahabt.library.domain.user.User;

public interface UserApplication {

	Optional<User> addUser(User user);
	Optional<User> removeUser(IdentityNo identityNo );
	Optional<User> editUser(User user);
	Optional<User> getInformationUser(IdentityNo identityNo);

}
