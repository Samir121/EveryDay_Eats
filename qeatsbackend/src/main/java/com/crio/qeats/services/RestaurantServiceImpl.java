
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakHoursServingRadiusInKms = 3.0;
  private final Double normalHoursServingRadiusInKms = 5.0;
  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;


  // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement findAllRestaurantsCloseby.
  // Check RestaurantService.java file for the interface contract.
  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(
      GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime) {
    List<Restaurant> restaurantsList = new ArrayList<Restaurant>();
    Double servingRadius = checkRadius(currentTime);
    
    restaurantsList = restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(),
                      getRestaurantsRequest.getLongitude(),currentTime,servingRadius);

    GetRestaurantsResponse getRestaurantsResponse = new GetRestaurantsResponse(restaurantsList);
    return getRestaurantsResponse;
  }

  public Double checkRadius(LocalTime currentTime){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
    Boolean flag = 
    //   (currTime.isAfter(LocalTime.parse("7:59:59",formatter)) && currTime.isBefore(LocalTime.parse("10:00:01",formatter))) ||
    //   (currTime.isAfter(LocalTime.parse("12:59:59",formatter)) && currTime.isBefore(LocalTime.parse("14:00:01",formatter))) ||
    //   (currTime.isAfter(LocalTime.parse("18:59:59",formatter)) && currTime.isBefore(LocalTime.parse("21:00:01")))
    // );

    (currentTime.isAfter(LocalTime.parse("07:59:59", formatter)) && currentTime.isBefore(LocalTime.parse("10:00:01", formatter)))
    || (currentTime.isAfter(LocalTime.parse("12:59:59", formatter)) && currentTime.isBefore(LocalTime.parse("14:00:01", formatter)))
    || (currentTime.isAfter(LocalTime.parse("18:59:59", formatter)) && (currentTime.isBefore(LocalTime.parse("21:00:01", formatter))));
    if(flag == true){
      return peakHoursServingRadiusInKms;
    }
    return normalHoursServingRadiusInKms;
  }


}

