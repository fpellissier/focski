package org.franck.focski.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AccueilAdminCtrl implements Controller {
  
  private static final Logger logger = Logger.getLogger(AccueilAdminCtrl.class);
  
  public ModelAndView handleRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    return new ModelAndView("admin-adhesion");
  }
}
