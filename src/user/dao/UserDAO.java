package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public UserDTO getById(String id);

	public void updateUser(String id, String changedName, String changedPwd);

	public void deleteUser(String id);

}
