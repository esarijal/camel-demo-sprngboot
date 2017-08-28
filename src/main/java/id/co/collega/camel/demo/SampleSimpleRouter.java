package id.co.collega.camel.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created on 25/08/2017.
 */
@Component
public class SampleSimpleRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{timer.period}}")
                .transform(method("myBean", "saySomething"))
                .to("stream:out");
    }
}
