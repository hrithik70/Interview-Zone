package com.hrithik.controller.utility;

import com.hrithik.Constants.Constant;
import com.hrithik.Utility.ExcelReaderUtility;
import com.hrithik.controller.master.ContentController;
import com.hrithik.dataObjects.ContentDO;
import com.hrithik.interfaceObjects.ContentIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelReaderController {

    @Autowired
    private ExcelReaderUtility excelReaderUtility;

    @Autowired
    private ContentController contentController;

    @GetMapping("/getSheetList")
    public ResponseEntity<List<String>> getSheetList(){
        List<String> allSheetName = excelReaderUtility.getAllSheetName();
        return new ResponseEntity<>(allSheetName, HttpStatus.OK);
    }

    @GetMapping("/getSheetData/{columnNum}/{sheetName}")
    public ResponseEntity<List<String>> getSheetData(@PathVariable("columnNum") int columnNum,@PathVariable("sheetName") String sheetName){
        List<String> allSheetData = excelReaderUtility.getDataByColumn(sheetName,columnNum);
        return new ResponseEntity<>(allSheetData, HttpStatus.OK);
    }
    @PostMapping("/saveContent/{sheetName}")
    public ResponseEntity<List<ContentDO>> saveContentByExcel(@PathVariable("sheetName") String sheetName){
        List<String> allSheetData = excelReaderUtility.getDataByColumn(sheetName,0);
        List<ContentDO> contentList = new ArrayList<>();
        for(String contentName : allSheetData){
            ContentIO io = new ContentIO();
            ContentDO contentDO = new ContentDO();
            contentDO.setContentName(contentName);
            contentDO.setDisplayName(contentName);
            contentDO.setEntityType(Constant.SYSTEM);
            contentDO.setSubjectCd("CORE_JAVA");
            io.setContent(contentDO);
            contentController.save(io);
            contentList.add(contentDO);
        }
        return new ResponseEntity<>(contentList,HttpStatus.OK);
    }
}
