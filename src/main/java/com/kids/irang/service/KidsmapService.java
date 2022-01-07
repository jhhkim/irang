package com.kids.irang.service;

import com.kids.irang.domain.KidsmapRepository;
import com.kids.irang.dto.KidsmapDto;
import com.kids.irang.utils.ScrapMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class KidsmapService {
    final KidsmapRepository kidsmapRepository;

    public void save(KidsmapDto dto) {
        kidsmapRepository.save(dto.toEntity());
    }

    public List<KidsmapDto> findList(String search) {
        return ScrapMap.scrap(search);
    }

}