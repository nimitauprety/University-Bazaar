package CSE3310.UBSProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDatabaseServiceImpl implements ProjectDatabaseService {
	
	@Autowired ProjectdDatabaseRepository UserRepository;
	
	@Override
	public String addUserInfo(UserDTO userdto) {
		String result = null;
		UserDTO unit = UserRepository.save(userdto);

		if(unit.equals(null)) {
			result = "Failure";
		}
		else {
			result = "Success";
		}
		
		return result;
	}

	@Override
	public UserDTO getUserInfo(String utaId) {
		
		UserDTO result = UserRepository.findByutaId(utaId);
		
		
		return result;
	}
	
	public List<UserDTO> getAllInfo(){
		List<UserDTO> result = (List<UserDTO>) UserRepository.findAll();
		
		return result;
	}
}
