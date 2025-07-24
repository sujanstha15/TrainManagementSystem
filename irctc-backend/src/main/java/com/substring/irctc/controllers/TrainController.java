package com.substring.irctc.controllers;

import com.substring.irctc.dto.PagedResponse;
import com.substring.irctc.dto.TrainDTO;
import com.substring.irctc.entity.ImageMetaData;
import com.substring.irctc.entity.Train;
import com.substring.irctc.service.FileUploadService;
import com.substring.irctc.service.TrainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController //Controller + ResponseBody = RestController
@RequestMapping("trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private FileUploadService fileUploadService;


    //creating api to upload file
    @PostMapping("/photo")
    public ImageMetaData uploadTrainUpload(
            @RequestParam("file") MultipartFile file //fetching the data from form. deserialization is only in json
            ) throws IOException {

        ImageMetaData imageMetaData =  fileUploadService.upload(file);

        //using repository save this to database
        return imageMetaData;
    }



    //get all
    //@RequestMappin(value="/", method=RequestMethod.GET)
    @GetMapping
    public PagedResponse<TrainDTO > all(
            //using pagination and sorting
            @RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size,
            @RequestParam(value="sortBy", defaultValue = "name") String sortBy,
            @RequestParam(value="sortDir", defaultValue = "asc") String sortDir
    )  {

        return this.trainService.all(page, size, sortBy, sortDir);

        //System.out.println("Getting all trains");
        //Thread.sleep(400);
    }

    //get single
    //trains/123
    // trains/1234

//    @GetMapping("/{trainNo}/{trainName}")
//    public Train get(@PathVariable("trainNo") String trainNo, @PathVariable String trainName){
//        return this.trainService.get(trainNo);
    //}//model attribute is only used in form not here


    @GetMapping("/{trainNo}")
    public ResponseEntity<TrainDTO> get(@PathVariable("trainNo") String trainNo) {
        return new ResponseEntity<>(this.trainService.get(trainNo), HttpStatus.OK);

    }

    //add train
    @PostMapping
    public ResponseEntity<TrainDTO> add(@Valid @RequestBody TrainDTO trainDTO) {


        return new ResponseEntity<>(this.trainService.add(trainDTO), HttpStatus.CREATED );
    }



    @DeleteMapping("/{trainNo}")
    public void delete(@PathVariable String trainNo){
       this.trainService.delete(trainNo);
    }

//    //it it GET method by default
//    @RequestMapping("/all")
//    @ResponseBody
//    //since we are returning train, the return type should be train
//    public List<Train> listTrain(){
//        System.out.println("Test");
//        Train train1 = new Train();
//        train1.setTrainNo("1234");
//        train1.setName("Syangja Train");
//        train1.setCoches(10);
//
//        Train train2 = new Train();
//        train2.setTrainNo("1234");
//        train2.setName("Monroe Railway");
//        train2.setCoches(12);
//
//        List<Train> trainList = new ArrayList<>();
//        trainList.add(train2);
//        trainList.add(train1);
//
//
//        //this is page. we don't have to return page, we have to return data
//        return trainList;
//    }
//
//    @RequestMapping("/get-one")
//    @ResponseBody
//    public Train getTrain(){
//        Train train2 = new Train();
//        train2.setTrainNo("1234");
//        train2.setName("Monroe Railway");
//        train2.setCoches(12);
//
//        return train2;
//    }
//
//
//This will work only for this controller, if we create for global, it will work for every exception it finds
    //for exception handling in controller level
//    @ExceptionHandler(NoSuchElementException.class)
//public ErrorResponse handleNoSuchException(NoSuchElementException exception){
//
//        ErrorResponse response = new ErrorResponse("Train not found!!" + exception.getMessage(), "404", false);
//        return response;
//}
}



