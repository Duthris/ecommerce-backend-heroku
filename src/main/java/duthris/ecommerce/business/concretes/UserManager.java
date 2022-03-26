package duthris.ecommerce.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duthris.ecommerce.business.abstracts.UserService;
import duthris.ecommerce.core.utilities.results.DataResult;
import duthris.ecommerce.core.utilities.results.ErrorDataResult;
import duthris.ecommerce.core.utilities.results.SuccessDataResult;
import duthris.ecommerce.dataAccess.abstracts.UserDao;
import duthris.ecommerce.entities.concretes.User;
import duthris.ecommerce.entities.dtos.UserLoginDto;
import duthris.ecommerce.entities.dtos.UserLoginReturnDto;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kayıtlı tüm kullanıcılar listelendi.");
	}

	@Override
	public User add(User user) {
		return userDao.save(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto) {
		User user = this.userDao.findByUsername(userLoginDto.getUsername());
		
		if (user == null) {
			return new ErrorDataResult<UserLoginReturnDto>("Geçersiz Kullanıcı Adı!");
		}
		
		else if (!user.getPassword().equals(userLoginDto.getPassword())) {
			return new ErrorDataResult<UserLoginReturnDto>("Geçersiz Şifre!");
		}
		
		UserLoginReturnDto userLoginReturnDto = new UserLoginReturnDto();
		userLoginReturnDto.setId(user.getId());
		userLoginReturnDto.setUsername(user.getUsername());
		userLoginReturnDto.setUserType(1);
		userLoginReturnDto.setName("Admin");
		
		return new SuccessDataResult<UserLoginReturnDto>(userLoginReturnDto, "Başarıyla giriş yapıldı!");
	}

}
