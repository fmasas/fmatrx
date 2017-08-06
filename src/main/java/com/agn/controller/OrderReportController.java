package com.agn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reporteordenes")
public class OrderReportController {
 
      @RequestMapping(method = RequestMethod.GET)
        public String getIndexPage() {
            return "reporteordenes";
        }
 
}

