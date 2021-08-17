package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Caliber;
import kr.guncabinet.guncabinet.repository.CaliberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CaliberService {
    private final CaliberRepository caliberRepository;

    @ModelAttribute("caliber")
    public List<Caliber> getAllCalibers(){return caliberRepository.findAll();}
}
