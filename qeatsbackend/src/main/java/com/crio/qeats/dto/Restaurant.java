
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.dto;

// import com.fasterxml.jackson.annotation.JsonIgnore;
import java.net.URI;
import java.time.LocalTime;
import java.util.ArrayList;
// import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Restaurant class.
// Complete the class such that it produces the following JSON during serialization.
// {
//  "restaurantId": "10",
//  "name": "A2B",
//  "city": "Hsr Layout",
//  "imageUrl": "www.google.com",
//  "latitude": 20.027,
//  "longitude": 30.0,
//  "opensAt": "18:00",
//  "closesAt": "23:00",
//  "attributes": [
//    "Tamil",
//    "South Indian"
//  ]
// }
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private String restaurantId;
    private String name;
    private String city;
    private URI imageUrl;
    private Double latitude;
    private Double longitude;
    private String opensAt;
    private String closesAt;
    private ArrayList<String> attributes;

}

