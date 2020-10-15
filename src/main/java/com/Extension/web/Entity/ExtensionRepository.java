package com.Extension.web.Entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension, Integer> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM extension WHERE extension=:ex")
	int deleteByExtension(@Param(value = "ex") String value);

	@Query(nativeQuery = true, value = "SELECT * FROM extension WHERE extension=:ex")
	Extension findByExtension(@Param(value = "ex") String Extension);

	@Query(nativeQuery = true, value = "SELECT * FROM extension")
	List<Extension> findValues();

}
