package CSE3310.UBSProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ProjectMicroService")
public class ProjectController {
	
	@Autowired ProjectDatabaseService projectDatabaseService;
	
	@PostMapping(value="/registerUser", consumes = {"application/json"}, produces = {"application/json"})
	public String registerUser(@RequestBody UserDTO userDTO) {
		
		String unit = projectDatabaseService.addUserInfo(userDTO);
		
		return unit;
		
	}
	
	@RequestMapping(value = "/getUserInfo/{utaId}", method = RequestMethod.GET, produces = { "application/json" })
	public UserDTO getUserInfo(@PathVariable("utaId") String utaId) {
				
		UserDTO userDto = projectDatabaseService.getUserInfo(utaId);
		
		return userDto;
	}
	
	@RequestMapping(value = "/getAllInfo", method = RequestMethod.GET, produces = { "application/json" })
	public List<UserDTO> getAllInfo() {
				
		List<UserDTO> userDto = projectDatabaseService.getAllInfo();
		
		return userDto;
	}
	


}
