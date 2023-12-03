package com.cee.tech.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BuildInfo {
  @Produces
  double buildNumber = 2.1;


  @Produces
  List<String> developers(){
    List<String> devs = new ArrayList<>();

    devs.add("Mahrez");
    devs.add("Musili");

    return devs;
  };


}
