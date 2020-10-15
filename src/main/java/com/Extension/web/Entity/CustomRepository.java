package com.Extension.web.Entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomRepository extends JpaRepository<Custom, Integer> {
	
	@Query(nativeQuery = true,value="SELECT COUNT(*) FROM custom")
	int countCustom();
	
	@Query(nativeQuery = true,value="SELECT * FROM custom")
	List<Custom> findCustom();
	
	@Query(nativeQuery = true,value = "SELECT * FROM custom WHERE extension=:ex")
	List<Custom> load(@Param(value = "ex")String Extension);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "DELETE FROM custom WHERE id=:id")
	int delete(@Param(value = "id")int id);
	
}
