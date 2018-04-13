/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonasi;

import static java.lang.System.out;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Akshaya
 */
@WebService(serviceName = "fibonasiWebServices")
public class fibonasiWebServices {

    /**
     * This is a sample web service operation
     * @param size
     * @return 
     */
    @WebMethod(operationName = "getFibo")
    public int[] getFibo(@WebParam(name = "size") int size) {
       int arr[] = new int[size];
       arr[0]= 0;
       arr[1]=1;       
       for(int i =2;i<size;i++)
       {
           arr[i] = arr[i-1]+arr[i-2];
       }
       return arr;
    }
}
