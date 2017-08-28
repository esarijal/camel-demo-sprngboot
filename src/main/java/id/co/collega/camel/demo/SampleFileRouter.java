package id.co.collega.camel.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created on 25/08/2017.
 */
@Component
public class SampleFileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:target/input?noop=true")
                .to("file:target/output");
    }
}
