package activeMq.Repo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
@EnableJpaRepositories
public interface ScanRequestRepo extends CrudRepository<ScanRequestModel,String>{

	//@Query("select r.profile_Id from Scan_Request_Model r where r.trns_Ref = %1")
   public ScanRequestModel findByTxnSrcRef(final String trnRef); 
	


}