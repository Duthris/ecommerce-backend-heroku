package duthris.ecommerce.business.abstracts;

import java.util.List;

import duthris.ecommerce.core.utilities.results.DataResult;
import duthris.ecommerce.entities.concretes.User;
import duthris.ecommerce.entities.dtos.UserLoginDto;
import duthris.ecommerce.entities.dtos.UserLoginReturnDto;

public interface UserService {
	DataResult<List<User>> getAll();
	
	User add(User user);
	User update(User user);
	User delete(User user);
	
	DataResult<UserLoginReturnDto> login (UserLoginDto userLoginDto);
}
