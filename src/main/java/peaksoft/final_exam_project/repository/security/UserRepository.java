package peaksoft.final_exam_project.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.final_exam_project.model.security.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select u from User u where u.username = :username")
    User getUserByUsername(@Param("username") String username);
}
