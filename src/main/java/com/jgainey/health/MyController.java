package com.jgainey.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class MyController {

    Random random = new Random();


    @RequestMapping(method = RequestMethod.GET, value = "/health-random-fail", produces = "application/json")
    public ResponseEntity<String> health(){

        int num = random.nextInt(5);

        if(num == 3){
            return new ResponseEntity<>("400", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/health-print-ip", produces = "application/json")
    public ResponseEntity<String> getIP(HttpServletRequest request) {

        String ipAddress = request.getRemoteAddr();
        Utils.logInfo("IPADDRESS:"+ipAddress);

        return new ResponseEntity<>("IPADDRESS:"+ipAddress, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/health-print-all", produces = "application/json")
    public ResponseEntity<String> getALL(HttpServletRequest request) {

        Map<String, String> result = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }

        for (Map.Entry<String, String> entry : result.entrySet()) {
            sb.append(entry+"\n");
        }

        String all = sb.toString();

        Utils.logInfo(all);

        return new ResponseEntity<>(all, HttpStatus.OK);
    }


}
