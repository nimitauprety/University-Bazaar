package CSE3310.UBSProject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectdDatabaseRepository extends CrudRepository<UserDTO, String> {
	@Override UserDTO save(UserDTO userdto);
	UserDTO findByutaId(String utaId);
	List<UserDTO> findAll();
}
