/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Akshaya
 */
@WebService(serviceName = "calcWS")
public class calcWS {

    @WebMethod(operationName = "calculator")
      public double calculator(@WebParam(name = "num1") double num1,@WebParam(name = "num2") double num2,@WebParam(name = "opt") String op) {
        
        double d = 0;
        if("+".equals(op))
            d=num1+num2;
        else if("-".equals(op))
            d=num1-num2;
        else if("*".equals(op))
            d=num1*num2;
        else if("/".equals(op))
            d=num1/num2;
        return d;
           
    }
}
