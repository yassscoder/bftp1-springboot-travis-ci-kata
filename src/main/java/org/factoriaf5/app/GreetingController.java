package org.factoriaf5.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class GreetingRequest {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}

class GreetingResponse {

    private final String response;

    public GreetingResponse() {
        this.response = "hello to you";
    }

    public GreetingResponse(String name) {
        this.response = "hello, " + name;
    }

    public String getResponse() {
        return response;
    }
}

@RestController
public class GreetingController {
    @GetMapping("/hello")
    public GreetingResponse sayHello() {
        return new GreetingResponse();
    }


    @PostMapping("/hello")
    public GreetingResponse sayHello(@RequestBody GreetingRequest request) {

        return new GreetingResponse(request.getName());
    }
}
