package com.substring.irctc.service;

import com.substring.irctc.dto.PagedResponse;
import com.substring.irctc.dto.TrainDTO;
import com.substring.irctc.entity.Train;
import com.substring.irctc.exceptions.ResourceNotFoundException;
import com.substring.irctc.repositories.TrainRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

  //  List<Train> trainList = new ArrayList<>();
    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private ModelMapper modelMapper;

  public TrainService(TrainRepository trainRepository, ModelMapper modelMapper) {
    this.trainRepository = trainRepository;
    this.modelMapper = modelMapper;
  }

  public TrainService(){

    }
    //add train method
    public TrainDTO add(TrainDTO trainDTO){


      //convert dto to entity so that we can pass the train in repository
//      Train train = new Train();
//
//      train.setTrainNo(trainDTO.getTrainNo());
//      train.setName(trainDTO.getName());
//      train.setRouteName(trainDTO.getRouteName());

      Train train =  modelMapper.map(trainDTO, Train.class);

        //saving the train using JPARepository
        Train savedTrain = trainRepository.save(train);

        //convert entity into dto

//      TrainDTO dto = new TrainDTO();
//      dto.setTrainNo(savedTrain.getTrainNo());
//      dto.setName(savedTrain.getName());
//      dto.setRouteName(savedTrain.getRouteName());

     TrainDTO dto = modelMapper.map(savedTrain, TrainDTO.class);

        //convert into DTO
        return dto;

    }

    //getting all trains, these are APIs
    public PagedResponse<TrainDTO> all(int page, int size, String sortBy, String sortDir){
    //here we will be implementing pagination

      //sorting
      Sort sort = sortBy.trim().toLowerCase().equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
      Pageable pageable = PageRequest.of(page, size, sort);

      //sort is ready, and we have to prepare pagination/paging
      //we have to write code logic to fetch data from db: like getting train from database

      //returning all train
      Page<Train> trainPage = trainRepository.findAll(pageable);

      //list of train to list of train dtos
      Page<TrainDTO> trainDTOPage = trainPage.map(train-> modelMapper.map(train, TrainDTO.class));
      return PagedResponse.fromPage(trainDTOPage);

//
//      List<Train> all = trainPage.getContent();
//
//      List<TrainDTO> trainDTOS = all.stream()
//              .map(train -> modelMapper.map(train, TrainDTO.class)).
//              toList();
//      return trainDTOS;



    }

    //getting only one train
    public TrainDTO get(String trainNo){

    Train train = trainRepository.findById(trainNo).orElseThrow(()-> new ResourceNotFoundException("Train not found"));
  return modelMapper.map(train, TrainDTO.class);
    }
    //detele train
    public void delete(String trainNo){

      Train train = trainRepository.findById(trainNo).orElseThrow(()-> new ResourceNotFoundException("Train not found"));
      trainRepository.delete(train);
 

    }
}
