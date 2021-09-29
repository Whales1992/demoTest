package com.example.demo.services;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService{

   @Autowired
   UserRepository userRepository;

    public List<UserDto> getUsers(){

        List<UserDto> userDtoList = userRepository.findAll();

        if(!userDtoList.isEmpty()) return userDtoList;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Object[].class);

        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        userDtoList = Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, UserDto.class))
                .collect(Collectors.toList());

        userRepository.saveAll(userDtoList);

        return userDtoList;
   }


}
