package com.nullendpoint.fuse;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by swinchester on 14/7/17.
 */
public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://henlo?period=10000").routeId("henlo-logger").process(new GroovyProcessor()).log("${body}");

        from("timer://xmlThing?period=30000")
                .to("language:constant:resource:classpath:myxml.xml")
                .convertBodyTo(String.class)
                .process(new XMLtoJsonGroovyProcessor())
                .log("${body}");


        from("timer://stuff1?period=30000")
                .setBody(simple("${date:now:yyyy-MM-dd'T'HH:mm:ss'Z'}"))
                .log("${body}");
    }
}
