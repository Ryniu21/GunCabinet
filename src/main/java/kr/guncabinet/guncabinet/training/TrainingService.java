package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Training;
import kr.guncabinet.guncabinet.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final UserService userService;
    public void saveTraining(Training training){
        trainingRepository.save(training);
    }
    public List<Training> findTrainingByUserUsername(String username) {return trainingRepository.getTrainingByUserUsername(username);}

    public List<Training> getAllTrainingsForUser() {
        List<Training> trainings = findTrainingByUserUsername((userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getUsername());
        return trainings;
    }

}
