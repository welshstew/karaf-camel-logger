package com.nullendpoint.fuse

import org.apache.camel.Exchange
import org.apache.camel.Processor

/**
 * Created by swinchester on 18/7/17.
 */
class GroovyProcessor implements Processor{
    @Override
    void process(Exchange exchange) throws Exception {
        exchange.in.body = "henlo"
    }
}
