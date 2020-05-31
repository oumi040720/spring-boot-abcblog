package vn.com.abcblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.abcblog.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
