package CSE3310.UBSProject;

import java.util.List;

public interface ProjectDatabaseService {
	public String addUserInfo(UserDTO userdto);

	public UserDTO getUserInfo(String utaId);
	
	public List<UserDTO> getAllInfo();
}
