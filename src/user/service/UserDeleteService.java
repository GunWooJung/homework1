package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

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
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 아이디를 입력 : ");
		String id = sc.next();
		
		UserDTO userDTO = userDAO.getById(id);
		
		if(userDTO != null) {

			userDAO.deleteUser(id);
			
			System.out.println(id+"님의 데이터가 삭제되었습니다.");
		}
		else {
			System.out.println("삭제할 아이디가 없습니다.");
		}
		
	}

}
