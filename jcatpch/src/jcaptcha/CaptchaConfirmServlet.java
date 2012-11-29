package jcaptcha;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octo.captcha.service.CaptchaServiceException;


@SuppressWarnings("serial")
public class CaptchaConfirmServlet extends HttpServlet{
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

    }


    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

    	Boolean isResponseCorrect =Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = httpServletRequest.getSession().getId();
        //retrieve the response
        String captResponse = httpServletRequest.getParameter("j_captcha_response");
        // Call the Service method
         try {
             isResponseCorrect = CaptchaServiceSingleton.getInstance().validateResponseForID(captchaId,
            		 captResponse);
         } catch (CaptchaServiceException e) {
              //should not happen, may be thrown if the id is not valid
         }

//do something according to the result!
         String jcaptResult="It's not correct try again with valid value!";
         if(isResponseCorrect) {
        	 System.out.println("Response is correct");
        	 jcaptResult = "It's correct!";
         }
         
         httpServletResponse.getWriter().write(jcaptResult);

        
    }
}
