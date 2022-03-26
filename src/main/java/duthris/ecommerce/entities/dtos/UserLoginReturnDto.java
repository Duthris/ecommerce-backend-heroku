package duthris.ecommerce.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginReturnDto {
	private int id;
	private String username;
	private String name;
	private int userType;
}
