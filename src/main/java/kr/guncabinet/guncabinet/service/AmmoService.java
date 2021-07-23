package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.repository.AmmoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AmmoService {
    private final AmmoRepository ammoRepository;

    @ModelAttribute("ammunitions")
    public List<Ammo> getAllCalibers(){return ammoRepository.findAll();}
}
