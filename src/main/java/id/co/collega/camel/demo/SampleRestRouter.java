package id.co.collega.camel.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * Created on 25/08/2017.
 */
@Component
public class SampleRestRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        rest("/say")
                .get("/hello").to("direct:hello").produces("text/plain")
                .get("/bye").consumes("application/json").to("direct:bye")
                .post("/bye").to("mock:update");

        from("direct:hello")
                .transform().constant("Hello World");
        from("direct:bye")
                .transform().constant("Bye World");
    }
}
