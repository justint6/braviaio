package com.tayhantechnologies.braviaio.Controllers;

import com.tayhantechnologies.braviaio.WakeOnLan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class APIController {

    @Autowired
    WakeOnLan wakeOnLan;

    @RequestMapping(value = "/TurnOn", method = RequestMethod.GET)
    String turnOn() throws Exception {

        wakeOnLan.wol();
        return "Ok";
    }

    @RequestMapping(value = "/TurnOff", method = RequestMethod.GET)
    String turnOff() throws Exception {
        String xmlString = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAQAAAAEAAAAvAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";

        RestTemplate restTemplate =  new RestTemplate();
        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("X-Auth-PSK", "1234");
        headers.add("SOAPACTION", "\"urn:schemas-sony-com:service:IRCC:1#X_SendIRCC\"");
        headers.add("Content-Type", "text/xml; charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

        final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);




        return "Ok";
    }

    @RequestMapping(value = "/hdmi3", method = RequestMethod.GET)
    String hdmi3() throws Exception {
        String xmlString = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAgAAABoAAABcAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";

        RestTemplate restTemplate =  new RestTemplate();
        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("X-Auth-PSK", "1234");
        headers.add("SOAPACTION", "\"urn:schemas-sony-com:service:IRCC:1#X_SendIRCC\"");
        headers.add("Content-Type", "text/xml; charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

        wakeOnLan.wol();
        final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);




        return "Ok";
    }


    @RequestMapping(value = "/TVInput", method = RequestMethod.GET)
    String tvInput() throws Exception {
        String xmlStringH1 = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAgAAABoAAABaAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";

        String xmlStringInput = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAQAAAAEAAAAlAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";

        String xmlStringUp = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAQAAAAEAAAB0Aw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";

        RestTemplate restTemplate =  new RestTemplate();
        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("X-Auth-PSK", "1234");
        headers.add("SOAPACTION", "\"urn:schemas-sony-com:service:IRCC:1#X_SendIRCC\"");
        headers.add("Content-Type", "text/xml; charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<String>(xmlStringH1, headers);
        HttpEntity<String> request2 = new HttpEntity<String>(xmlStringInput, headers);
        HttpEntity<String> request3 = new HttpEntity<String>(xmlStringUp, headers);


        final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);
        Thread.sleep(1000);
        final ResponseEntity<String> response2 = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request2, String.class);
        Thread.sleep(1000);
        final ResponseEntity<String> response3 = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request3, String.class);




        return "Ok";
    }

    @RequestMapping(value = "/Channel94", method = RequestMethod.GET)
    String channel94() throws Exception {
        String xmlString9 = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAQAAAAEAAAAIAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";

        String xmlString4 = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAQAAAAEAAAADAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";


        wakeOnLan.wol();
        Thread.sleep(1000);
        RestTemplate restTemplate =  new RestTemplate();
        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("X-Auth-PSK", "1234");
        headers.add("SOAPACTION", "\"urn:schemas-sony-com:service:IRCC:1#X_SendIRCC\"");
        headers.add("Content-Type", "text/xml; charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<String>(xmlString9, headers);
        HttpEntity<String> request2 = new HttpEntity<String>(xmlString4, headers);



        final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);
        Thread.sleep(500);
        final ResponseEntity<String> response2 = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request2, String.class);





        return "Ok";
    }

    @RequestMapping(value = "/Channel22", method = RequestMethod.GET)
    String channel22() throws Exception {
        String xmlString2 = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAQAAAAEAAAABAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";





        RestTemplate restTemplate =  new RestTemplate();
        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("X-Auth-PSK", "1234");
        headers.add("SOAPACTION", "\"urn:schemas-sony-com:service:IRCC:1#X_SendIRCC\"");
        headers.add("Content-Type", "text/xml; charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<String>(xmlString2, headers);



        wakeOnLan.wol();
        final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);
        Thread.sleep(500);
        final ResponseEntity<String> response2 = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);





        return "Ok";
    }

    @RequestMapping(value = "/Channel33", method = RequestMethod.GET)
    String channel33() throws Exception {
        String xmlString2 = "<s:Envelope" +
                "    xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "    <s:Body>\n" +
                "        <u:X_SendIRCC xmlns:u=\"urn:schemas-sony-com:service:IRCC:1\">\n" +
                "            <IRCCCode>AAAAAQAAAAEAAAACAw==</IRCCCode>\n" +
                "        </u:X_SendIRCC>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";





        RestTemplate restTemplate =  new RestTemplate();
        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("X-Auth-PSK", "1234");
        headers.add("SOAPACTION", "\"urn:schemas-sony-com:service:IRCC:1#X_SendIRCC\"");
        headers.add("Content-Type", "text/xml; charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<String>(xmlString2, headers);



        wakeOnLan.wol();
        final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);
        Thread.sleep(500);
        final ResponseEntity<String> response2 = restTemplate.postForEntity("http://192.168.0.93/sony/IRCC", request, String.class);





        return "Ok";
    }

    @RequestMapping(value = "/TvStatus", method = RequestMethod.GET)
    String tvStatus() throws Exception {
        String jsonString2 = "{\n" +
                "    \"id\": 20,\n" +
                "    \"method\": \"getSystemInformation\",\n" +
                "    \"params\": [\"\"],\n" +
                "    \"version\": \"1.0\"\n" +
                "}";
        String jsonString = "{\n" +
                "    \"id\": 20,\n" +
                "    \"method\": \"getPowerStatus\",\n" +
                "    \"params\": [\"\"],\n" +
                "    \"version\": \"1.0\"\n" +
                "}";
        String jsonString3 = "{\n" +
                "    \"method\": \"getPlayingContentInfo\",\n" +
                "    \"id\": 103,\n" +
                "    \"params\": [],\n" +
                "    \"version\": \"1.0\"\n" +
                "}";




        RestTemplate restTemplate =  new RestTemplate();
        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("X-Auth-PSK", "1234");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<String>(jsonString, headers);
        HttpEntity<String> request2 = new HttpEntity<String>(jsonString2, headers);
        HttpEntity<String> request3 = new HttpEntity<String>(jsonString3, headers);


        //wakeOnLan.wol();
        final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.0.93/sony/system", request, String.class);
        Thread.sleep(500);
        final ResponseEntity<String> responseTvDetails = restTemplate.postForEntity("http://192.168.0.93/sony/system", request2, String.class);

        final ResponseEntity<String> responseAV = restTemplate.postForEntity("http://192.168.0.93/sony/avContent", request3, String.class);


        System.out.println(response);
        System.out.println(responseTvDetails);
        System.out.println(responseAV);

        return "Ok";
    }


    @RequestMapping(value="/Chrome", method = RequestMethod.GET)
    String chrome() throws Exception {
        try {
            String[] env = {"PATH=/bin:/usr/bin/"};
            //Process p = Runtime.getRuntime().exec("\"/Program Files (x86)/Google/Chrome/Application/chrome.exe\"");
            Process p = Runtime.getRuntime().exec("/opt/braviaio/bin/launchChrome.sh", env);
            p.waitFor();
            System.out.println("Google Chrome launched!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ok";
    }

}
