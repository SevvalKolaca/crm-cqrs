package crm.cqrs.crm.cqrs.core.web;

import org.apache.catalina.Pipeline;

public class BaseController {
    protected final Pipeline pipeline;

    public BaseController(Pipeline pipeline){
        this.pipeline = pipeline;
    }
}
