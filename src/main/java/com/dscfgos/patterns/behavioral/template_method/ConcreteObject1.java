package com.dscfgos.patterns.behavioral.template_method;

public class ConcreteObject1 extends TemplateClass{
    @Override
    public void buildStep1() {
        System.out.println("ConcreteObject1 :: Doing things in step 1.");
    }

    @Override
    public void buildStep2() {
        System.out.println("ConcreteObject1 :: Doing things in step 2.");
    }

    @Override
    public void buildStep3() {
        System.out.println("ConcreteObject1 :: Doing things in step 3.");
    }
}
