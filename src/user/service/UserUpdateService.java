package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {
	
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();
		System.out.println("이름\t아이디\t비밀 번호");
		for(UserDTO dto : list) {
			System.out.println(dto);
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 아이디를 입력 : ");
		String id = sc.next();
		
		UserDTO userDTO = userDAO.getById(id);
		
		if(userDTO != null) {
			System.out.println("이름\t아이디\t비밀 번호");
			System.out.println(userDTO);
			System.out.print("수정할 이름 입력 : ");
			String changedName = sc.next();
			System.out.print("수정할 비밀 번호 입력 : ");
			String changedPwd = sc.next();
			
			userDAO.updateUser(id, changedName, changedPwd);
			
			System.out.println(id+"님의 데이터가 수정되었습니다.");
		}
		else {
			System.out.println("찾고자 하는 아이디가 없습니다.");
		}
		
	}
}
