package repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Numbers;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Integer> {
	
	List<Numbers> findAll();

}
