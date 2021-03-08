package com.example.demo.pojos;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;



/**
 * The Result class was created to illustrate result of parsing
 * and converting of files with different extentions(csv, json).
 */
@Service
public class Result {
    private int lineOrder = 1;


    /* The method below will read csv file and send the result
    to be printed */
    public void readCSV(String fileName) throws Exception{
        List<String[]> result;
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
        try(CSVReader reader = new CSVReaderBuilder(
            new FileReader(fileName))
            .withCSVParser(csvParser)
            .withSkipLines(1) //skip header columns of csv file
            .build())
        {
            printResult(reader.readAll(), fileName);
        }

    }


    /*
        The method will print the sent result of a csv file
     */
    public void printResult(List<String[]> csvResult, String filename){
        lineOrder = 1;
        csvResult
        .stream()
        .parallel()
        .map(value->value[0].split(","))
        .forEachOrdered(a-> {
                        try {
                            Double.parseDouble(a[1]);
                            System.out.println(
                                    "{ " +
                                    "id:" + a[0]
                                     + ", amount:" + Double.parseDouble(a[1])
                                     + ", comment:" + a[3]
                                     + ", filename " + filename
                                     + ", line:" + lineOrder++
                                     + ", result: OK"
                                     + " }");
                        } catch (NumberFormatException e) {
                            a[1] = "Not a Number";
                            System.out.println(
                                    "{ " +
                                    "id:" + a[0]
                                    + ", amount:" + a[1]
                                    + ", comment:" + a[3]
                                    + ", filename " + filename
                                    + ", line:" + lineOrder++
                                    + ", result: WRONG, NumberFormatException in amount field"
                                    + " }");
                        }
                    });
    }


    /*
    *
    * The method parse a json file and print the parsed result
    * */
    public void parseAnalizeJson(String filename){
        lineOrder = 1;
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filename))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            employeeList.parallelStream()
                    .forEachOrdered( emp ->
                            { JSONObject object = (JSONObject)emp;
                                try {
                                    System.out.println(
                                    "{ " +
                                    "id:" + object.get("orderId")
                                    + ", amount:" + Double.parseDouble(object.get("amount").toString())
                                    + ", comment:" + object.get("comment")
                                    + ", filename " + filename
                                    + ", line:" + lineOrder++
                                    + ", result: OK"
                                    + " }"
                                    );
                                }catch (NumberFormatException e){
                                    System.out.println(
                                    "{ " +
                                    "id:" + object.get("orderId")
                                    + ", amount:" + "Not a Number"
                                    + ", comment:" + object.get("comment")
                                    + ", filename " + filename
                                    + ", line:" + lineOrder++
                                    + ", result: WRONG, NumberFormatException in amount field"
                                    + " }"
                                    );
                                }

                            }
                    );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
