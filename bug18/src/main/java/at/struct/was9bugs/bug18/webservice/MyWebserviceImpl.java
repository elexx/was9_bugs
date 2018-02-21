package at.struct.was9bugs.bug18.webservice;

import at.struct.was9bugs.bug18.principal.MyPrincipal;
import at.struct.was9bugs.bug18.mywebservice.MyWebservice;
import at.struct.was9bugs.bug18.mywebservice.MyWebserviceRequest;
import at.struct.was9bugs.bug18.mywebservice.MyWebserviceResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(
        targetNamespace = "http://was9bugs.struct.at/Webservice/MyWebservice/",
        endpointInterface = "at.struct.was9bugs.bug18.mywebservice.MyWebservice",
        serviceName = "myWebservice",
        portName = "MyWebservicePort"
)
public class MyWebserviceImpl implements MyWebservice {

    @Inject
    private MyPrincipal principal;

    @Override
    public MyWebserviceResponse webserviceMethod(MyWebserviceRequest request) {
        MyWebserviceResponse response = new MyWebserviceResponse();
        response.setRequest(request.getRequest());
        response.setPrincipalName(principal.getUsername());

        return response;
    }
}
