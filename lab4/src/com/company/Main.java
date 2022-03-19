package com.company;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.admin.Admin;
import com.company.admin.SortByGas;
import com.company.cars.Taxi;
import com.company.cars.Type;
import com.company.parser.Parser;

import java.io.*;
import java.util.Scanner;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.*;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Main {
    static Logger Log;
    public static void main(String[] args) throws Exception {
        // validation xml
        final File schemaFile = new File("./files/Taxi.xsd");
        final Source xmlFile = new StreamSource("./files/yandex.xml");
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Car> cars;
        // parsing
        final String fileName = "./files/yandex.xml";
        Parser parser = new Parser();
        cars = parser.CreateCarFromXml(fileName);
        cars.add(new Taxi(1000, 20.9, 370, Type.BUSINESS));
        cars.add(new Taxi(200, 30.4, 200, Type.STANDART));
        cars.add(new Taxi(500, 24.7, 260, Type.COMFORT));

        Admin admin = new Admin();
        admin.SortByGas(cars); // comparator

        // serialization
        String filePath = "./files/cars.json";

        BufferedWriter inFile = new BufferedWriter(new FileWriter(filePath));
        for (Car car:cars
        ) {
            inFile.write(JSON.toJSONString(car) + "\n");
        }
        inFile.flush();
        inFile.close();

        // deserialization

        cars.clear();
        try(BufferedReader outFile = new BufferedReader(new FileReader(filePath)))
        {
            while(true)
            {
                String str = outFile.readLine();
                if (str == null)
                {
                    break;
                }
                System.out.println(str);
                cars.add(JSON.parseObject(str, Taxi.class));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("--------After Deserialization----------");
        for (Car car: cars) {
            System.out.println(car);
        }
        System.out.println("--------Streaming API----------");
        cars.stream().filter(e -> e.getPrice() < 500).forEach(e -> System.out.println(e));
    }
}
