package com.demo.practice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sys {

    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}
