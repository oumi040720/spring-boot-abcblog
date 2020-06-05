package vn.com.abcblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.abcblog.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByCategoryCode(String categoryCode);
	
}
