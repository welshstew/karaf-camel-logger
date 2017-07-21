package com.nullendpoint.fuse;


import org.apache.camel.builder.RouteBuilder;

/**
 * Created by swinchester on 14/7/17.
 */
public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://henlo?period=10000").routeId("henlo-logger").process(new GroovyProcessor()).log("${body}");
    }
}
