package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  private static final String ADAPTER_COMMON_TEST_DIRECTORY = "C:\\BlaBlaCar\\busfor-tt2\\adapter-common-test";
  private static final String MAVEN_EXECUTABLE_DIRECTORY = "C:\\Program Files\\apache-maven-3.8.3\\bin\\mvn.cmd";

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(15);
    executor.invokeAll(createCallables());
  }

  private static List<Callable<Process>> createCallables() {
    List<Callable<Process>> callableList = new ArrayList<>();
    callableList.add(() -> launchTest("2022-03-25"));
    callableList.add(() -> launchTest("2022-03-26"));
    callableList.add(() -> launchTest("2022-03-27"));
    callableList.add(() -> launchTest("2022-03-28"));
    callableList.add(() -> launchTest("2022-03-29"));
    callableList.add(() -> launchTest("2022-03-30"));
    callableList.add(() -> launchTest("2022-03-31"));
    callableList.add(() -> launchTest("2022-04-01"));
    callableList.add(() -> launchTest("2022-04-02"));
    callableList.add(() -> launchTest("2022-04-03"));
    callableList.add(() -> launchTest("2022-04-04"));
    callableList.add(() -> launchTest("2022-04-05"));
    callableList.add(() -> launchTest("2022-04-06"));
    callableList.add(() -> launchTest("2022-04-07"));
    callableList.add(() -> launchTest("2022-04-08"));
    callableList.add(() -> launchTest("2022-04-09"));
    callableList.add(() -> launchTest("2022-04-10"));
    callableList.add(() -> launchTest("2022-04-11"));
    callableList.add(() -> launchTest("2022-04-12"));
    callableList.add(() -> launchTest("2022-04-13"));
    callableList.add(() -> launchTest("2022-04-14"));
    callableList.add(() -> launchTest("2022-04-15"));
    callableList.add(() -> launchTest("2022-04-16"));
    callableList.add(() -> launchTest("2022-04-17"));
    callableList.add(() -> launchTest("2022-04-18"));
    return callableList;
  }

  private static Process launchTest(String date) {
    ProcessBuilder builder = new ProcessBuilder();
    builder.directory(new File(ADAPTER_COMMON_TEST_DIRECTORY));
    builder.command(
        MAVEN_EXECUTABLE_DIRECTORY,
        "test",
        "-Dtest.baseURI=http://localhost:8080",
        "-Dtest.configurationId=r246",
        "-Dtest=TestAdapterAllPossibleTrips",
        "-DsearchTripSync=false",
        "-Dbindings=true",
        "-Dseatmap=false",
        "-Ddate=" + date);
    builder.inheritIO(); // sends process output to Java parent process output

    try {
      return builder.start();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
