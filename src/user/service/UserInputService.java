package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;


public class UserInputService implements UserService {
	
	@Setter
	private UserDTO userDTO;
	
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.next();
		
		userDTO.setId(id);
		userDTO.setName(name);
		userDTO.setPwd(pwd);
		
		userDAO.write(userDTO);
		
		System.out.println(name+"님의 데이터를 저장하였습니다.");
	}
}
