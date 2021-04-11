package learning.springboot.repositories;

import learning.springboot.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long>{
}
