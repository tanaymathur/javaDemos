
package Demo-Maven;

import javax.jws.WebService;

@WebService(endpointInterface = "Demo-Maven.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

