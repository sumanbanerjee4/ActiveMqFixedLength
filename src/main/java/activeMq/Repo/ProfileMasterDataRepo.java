package activeMq.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileMasterDataRepo extends CrudRepository<ProfileMasterData,String>{
	
	public ProfileMasterData findByProfileId(String profileId);

}
