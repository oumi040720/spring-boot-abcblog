package vn.com.abcblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.abcblog.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRoleCode(String roleCode);
	
}
