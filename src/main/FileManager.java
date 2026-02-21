package main;


import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import program.Program;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

public class FileManager {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    Document document;

    public FileManager(){
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void readXML(String filename){
        File file = new File(filename);
        StringBuilder xmlContent = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                xmlContent.append(scanner.nextLine());
                xmlContent.append("\n");
            }
            } catch (FileNotFoundException e) {
                Program.inout.write("Файл с таким названием не был найден, поэтому данные не были загружены. Во время save данные будут выгружены в новый, указанный вами файл.");
            }

                String xmlString = xmlContent.toString();
                InputStream is = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8));

                try {
                    document = builder.parse(is);

                    NodeList entries = document.getElementsByTagName("entry");
                    parserXML(entries);
                } catch (Exception e) {
                    Program.inout.write("В файле не было найдено данных");
                }





    }



    public void writeXML(String filename){
        document = builder.newDocument();
        Element Collection = document.createElement("labWorks");
        document.appendChild(Collection);
        parseMyElements(document, Collection);
        saveCollectionToFile(filename, document);
    }


    private void parseMyElements(Document document, Element Collection){
        for (int i: Program.colman.getLabWork().keySet()){
            Element entry = document.createElement("entry");
            Collection.appendChild(entry);

            Element keyElement = document.createElement("key");
            keyElement.setTextContent(String.valueOf(i));
            entry.appendChild(keyElement);

            LabWork labwork = Program.colman.getLabWork().get(i);
            Element LabWorkElement = document.createElement("LabWork");
            entry.appendChild(LabWorkElement);

            addTextElement(LabWorkElement,"id",labwork.getId(), document);
            addTextElement(LabWorkElement,"nameLabWork",labwork.getName(), document);

            Element coordinatesElement = document.createElement("coordinates");
            LabWorkElement.appendChild(coordinatesElement);
            addTextElement(coordinatesElement,"X",labwork.getCoordinates().getX(), document);
            addTextElement(coordinatesElement,"Y",labwork.getCoordinates().getY(), document);

            addTextElement(LabWorkElement,"date",labwork.getCreationDate(), document);

            addTextElement(LabWorkElement,"minimalPoint",labwork.getMinimalPoint(), document);

            addTextElement(LabWorkElement,"difficulty",labwork.getDifficulty(), document);

            Element pesonElement = document.createElement("Person");
            LabWorkElement.appendChild(pesonElement);

            addTextElement(pesonElement,"nameAuthor",labwork.getAuthor().getName(), document);
            addTextElement(pesonElement,"height",labwork.getAuthor().getHeight(), document);
            addTextElement(pesonElement,"weight",labwork.getAuthor().getWeight(), document);
            addTextElement(pesonElement,"passportNumber",labwork.getAuthor().getPassportID(), document);
        }
    }

    private void addTextElement(Element parent, String tag, Object value, Document document) {
        Element elem = document.createElement(tag);
        elem.setTextContent(String.valueOf(value));
        parent.appendChild(elem);
    }


    public void saveCollectionToFile(String filename,Document document) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            String xmlString = writer.toString();

            try (FileWriter fileWriter = new FileWriter(filename)) {
                fileWriter.write(xmlString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void parserXML(NodeList entries){
        for (int i = 0; i < entries.getLength(); i++) {
            Element entry = (Element) entries.item(i);

            Integer key = Integer.parseInt(entry.getElementsByTagName("key").item(0).getTextContent());

            Element labElem = (Element) entry.getElementsByTagName("LabWork").item(0);

            String idStr = labElem.getElementsByTagName("id").item(0).getTextContent();
            Integer id = Integer.parseInt(idStr);

            String name = labElem.getElementsByTagName("nameLabWork").item(0).getTextContent();

            Element coordsElem = (Element) labElem.getElementsByTagName("coordinates").item(0);
            String xStr = coordsElem.getElementsByTagName("X").item(0).getTextContent();
            Float x = Float.parseFloat(xStr);
            String yStr = coordsElem.getElementsByTagName("Y").item(0).getTextContent();
            Long y = Long.parseLong(yStr);
            Coordinates cor = new Coordinates(x, y);

            String dateStr = labElem.getElementsByTagName("date").item(0).getTextContent();
            LocalDate date = LocalDate.parse(dateStr);

            String minStr = labElem.getElementsByTagName("minimalPoint").item(0).getTextContent();
            Double minPoint = Double.parseDouble(minStr);

            String diffStr = labElem.getElementsByTagName("difficulty").item(0).getTextContent();
            Difficulty diff = Difficulty.valueOf(diffStr);

            Element personElem = (Element) labElem.getElementsByTagName("Person").item(0);

            String nameAuthor = personElem.getElementsByTagName("nameAuthor").item(0).getTextContent();

            String heightStr = personElem.getElementsByTagName("height").item(0).getTextContent();
            Double height = Double.parseDouble(heightStr);

            String weightStr = personElem.getElementsByTagName("weight").item(0).getTextContent();
            Double weight = Double.parseDouble(weightStr);

            String passport = personElem.getElementsByTagName("passportNumber").item(0).getTextContent();

            Person author = new Person(nameAuthor, height, weight, passport);

            LabWork labWork = new LabWork(id, name, cor, date, minPoint, diff, author);
            Program.colman.getLabWork().put(key, labWork);
        }
    }

}
