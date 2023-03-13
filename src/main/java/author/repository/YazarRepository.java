package author.repository;

import author.beans.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface YazarRepository extends JpaRepository<Yazar,Long> {

}
