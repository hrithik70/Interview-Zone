package com.hrithik.controller.master;

import com.hrithik.dataObjects.ContentDO;
import com.hrithik.executor.master.ContentExecutor;
import com.hrithik.interfaceObjects.ContentIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentExecutor contentExecutor;

    @PostMapping("/save")
    public ResponseEntity<ContentIO> save(@RequestBody ContentIO io){
        return new ResponseEntity<ContentIO>((ContentIO) contentExecutor.save(io), HttpStatus.OK);
    }
    @PostMapping("/submit")
    public ResponseEntity<ContentIO> submit(@RequestBody ContentIO io){
        return new ResponseEntity<ContentIO>((ContentIO) contentExecutor.submit(io), HttpStatus.OK);
    }
    @PostMapping("/submit-verification")
    public ResponseEntity<ContentIO> submitVerification(@RequestBody ContentIO io){
        return new ResponseEntity<ContentIO>((ContentIO) contentExecutor.submitVerification(io), HttpStatus.OK);
    }

    @GetMapping("/fetch-by-guid/{guid}")
    public ResponseEntity<ContentIO> fetchByGuid(@PathVariable("guid") String guid){
        ContentIO io = (ContentIO) contentExecutor.fetchByGuid(guid);
        return new ResponseEntity<ContentIO>(io,HttpStatus.OK);
    }
    @GetMapping("/fetch-by-subjectCd/{subjectCd}")
    public ResponseEntity<List<ContentDO>> fetchBySubjectCode(@PathVariable("subjectCd") String subjectCd){
        List<ContentDO> contentList = contentExecutor.fetchBySubjectCd(subjectCd);
        return new ResponseEntity<List<ContentDO>>(contentList,HttpStatus.OK);
    }

    @GetMapping("/fetchSubjectCd")
    public ResponseEntity<List<String>> fetchSubjectCd(){
        List<String> subjectList = contentExecutor.fetchSubject();
        return new ResponseEntity<List<String>>(subjectList,HttpStatus.OK);
    }

}
