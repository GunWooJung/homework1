package user.dao.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void write(UserDTO userDTO) {
		// TODO Auto-generated method stub
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public UserDTO getById(String id) {
		String sql = "select * from usertable where id = ?";
		
		 try {
		        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(UserDTO.class));
		    } catch (EmptyResultDataAccessException e) {
		        // 결과가 없을 때는 null을 반환
		        return null;
		    }
	}


	@Override
	public void updateUser(String id, String changedName, String changedPwd) {
		// TODO Auto-generated method stub
		String sql = "update usertable set name = ? , pwd = ? where id = ?";
		jdbcTemplate.update(sql, changedName, changedPwd , id);
	}
	
	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from usertable where id = ?";
		jdbcTemplate.update(sql, id);
	}

}
