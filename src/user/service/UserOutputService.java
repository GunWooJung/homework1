package user.service;

import java.util.List;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserOutputService implements UserService {
	
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<UserDTO> list = userDAO.getUserList();
		System.out.println("이름\t아이디\t비밀 번호");
		for(UserDTO dto : list) {
			System.out.println(dto);
		}
		
	}
}
