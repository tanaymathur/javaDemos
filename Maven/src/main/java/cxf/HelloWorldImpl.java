
package cxf;

import javax.jws.WebService;

@WebService(endpointInterface = "cxf.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

