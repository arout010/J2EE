
package newpackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "NewWebService")
public class NewWebService {

    @WebMethod(operationName = "checkPrime")
    public boolean checkPrime(@WebParam(name = "n") int n) {
        int i=0,flag= 0;
        for(i=2;i<n/2;i++)
        {
            if(n%i==0)
            {
                flag=1;
                return false;
            }
        }
         return true;
    }
}
