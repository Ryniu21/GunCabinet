package kr.guncabinet.guncabinet.repository;

import kr.guncabinet.guncabinet.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository <Training, Long>{

    @Query("Select t From Training t Where t.user.username=?1")
    List<Training> getTrainingByUserUsername(String username);
}
