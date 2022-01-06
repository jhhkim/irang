package com.kids.irang.service;

import com.kids.irang.domain.KidsmapRepository;
import com.kids.irang.dto.KidsmapDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KidsmapService {
    private final KidsmapRepository kidsmapRepository;

    //insert data
    @Transactional
    public Long save(KidsmapDto requestDto){
        return kidsmapRepository.save(requestDto.toEntity()).getId();
    }
}
