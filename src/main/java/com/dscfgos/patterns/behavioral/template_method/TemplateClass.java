package com.dscfgos.patterns.behavioral.template_method;

public abstract class TemplateClass {

    abstract void buildStep1();
    abstract void buildStep2();
    abstract void buildStep3();

    public void buildAll(boolean doStep2){
        this.buildStep1();
        if(doStep2){
            this.buildStep2();
        }
        this.buildStep3();
    }
}
