package com.company.parser;

import com.company.Car;
import com.company.cars.Bus;
import com.company.cars.Taxi;
import com.company.cars.Type;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Parser // stax
{
    public ArrayList<Car> CreateCarFromXml(String fileName)
    {
        ArrayList<Car> cars = null;
        Car car = null;
        String field;
        try {
            XMLEventReader xmlr = XMLInputFactory.newInstance().createXMLEventReader(fileName, new FileInputStream(fileName));
            while (xmlr.hasNext()) {
                XMLEvent event = xmlr.nextEvent();
                if (event.isStartElement()) {
                    StartElement start = event.asStartElement();
                    field = start.getName().getLocalPart();
                    event = xmlr.nextEvent();
                    switch (field)
                    {
                        case "Cars":
                            cars = new ArrayList<Car>();
                            break;
                        case "Taxi":
                            car = new Taxi();
                            break;
                        case "Bus":
                            car = new Bus();
                            break;
                        case "price":
                            car.setPrice(Integer.parseInt(event.asCharacters().getData()));
                            break;
                        case "gas":
                            car.setGas(parseDouble(event.asCharacters().getData()));
                            break;
                        case "speed":
                            car.setSpeed(parseInt(event.asCharacters().getData()));
                            break;
                        case "type":
                            Taxi car1 = (Taxi) car;
                            car1.setType(event.asCharacters().getData());
                            car = car1;
                            break;
                        case "passangers":
                            Bus car2 = (Bus) car;
                            car2.setPassangers(parseInt(event.asCharacters().getData()));
                            car = car2;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: ");
                    }
                }
                if (event.isEndElement())
                {
                    EndElement endElement = event.asEndElement();
                    switch(endElement.getName().getLocalPart())
                    {
                        case "Taxi":
                        case "Bus":
                            cars.add(car);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException | NumberFormatException ex) {
            ex.printStackTrace();
        }
        return cars;
    }
}