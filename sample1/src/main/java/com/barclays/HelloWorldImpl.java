
package com.barclays;

import javax.jws.WebService;

@WebService(endpointInterface = "com.barclays.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

