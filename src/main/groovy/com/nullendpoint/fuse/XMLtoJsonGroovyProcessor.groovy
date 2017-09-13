package com.nullendpoint.fuse

import groovy.json.JsonOutput
import org.apache.camel.Exchange
import org.apache.camel.Processor

class XMLtoJsonGroovyProcessor implements Processor {
    @Override
    void process(Exchange exchange) throws Exception {
        def slurp = new XmlSlurper().parseText(exchange.in.body)
        def json = [groupid: slurp.groupId.toString(), artifactId:slurp.artifactId.toString()] as Map

        exchange.in.body = JsonOutput.toJson(json)
    }
}
