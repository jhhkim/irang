package com.kids.irang.web;
import com.kids.irang.dto.KidsmapDto;
import com.kids.irang.service.KidsmapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class KidsmapApiController {

    final KidsmapService kidsmapService;

    @GetMapping("/api/v1/scrap")
    public List<KidsmapDto> cate(@RequestParam(name = "search") String search){
        return kidsmapService.findList(search);
    }


//    @PostMapping("/api/v1/cate")
//    public ResponseEntity cateSave(@RequestBody KidsmapDto dto){
//        kidsmapService.save(dto);
//        return new ResponseEntity(HttpStatus.OK);
//    }
 }