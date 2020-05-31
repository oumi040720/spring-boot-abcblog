package vn.com.abcblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.abcblog.entity.Tag;
import vn.com.abcblog.entity.id.TagID;

@Repository
public interface TagRepository extends JpaRepository<Tag, TagID> {

}
