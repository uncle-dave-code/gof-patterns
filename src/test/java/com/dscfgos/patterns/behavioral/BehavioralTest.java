package com.dscfgos.patterns.behavioral;

import com.dscfgos.patterns.behavioral.chain_responsibility.ChainResponsibility;
import com.dscfgos.patterns.behavioral.chain_responsibility.Request;
import com.dscfgos.patterns.behavioral.command.OperationA;
import com.dscfgos.patterns.behavioral.command.OperationB;
import com.dscfgos.patterns.behavioral.interpreter.utils.ExpressionUtils;
import com.dscfgos.patterns.behavioral.iterator.CustomCollection;
import com.dscfgos.patterns.behavioral.iterator.Item;
import com.dscfgos.patterns.behavioral.mediator.*;
import com.dscfgos.patterns.behavioral.memento.UserCaretaker;
import com.dscfgos.patterns.behavioral.memento.UserOriginator;
import com.dscfgos.patterns.behavioral.observer.*;
import com.dscfgos.patterns.behavioral.state.Context;
import com.dscfgos.patterns.behavioral.state.StateA;
import com.dscfgos.patterns.behavioral.state.StateB;
import com.dscfgos.patterns.behavioral.state.StateC;
import com.dscfgos.patterns.behavioral.strategy.AddStrategy;
import com.dscfgos.patterns.behavioral.strategy.StrategyContext;
import com.dscfgos.patterns.behavioral.strategy.SubstractStrategy;
import com.dscfgos.patterns.behavioral.template_method.ConcreteObject1;
import com.dscfgos.patterns.behavioral.template_method.ConcreteObject2;
import com.dscfgos.patterns.behavioral.template_method.TemplateClass;
import com.dscfgos.patterns.behavioral.visitor.*;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BehavioralTest {

    Logger logger = Logger.getLogger(BehavioralTest.class.getName());

    @org.junit.jupiter.api.Test
    void testChainOfResponsibility() {
        ChainResponsibility chainResponsibility = new ChainResponsibility();

        assertAll(
                () -> assertEquals(Request.DO_FIRST, chainResponsibility.processChain(Request.DO_FIRST)),
                () -> assertEquals(Request.DO_SECOND, chainResponsibility.processChain(Request.DO_SECOND)),
                () -> assertEquals(Request.DO_THIRD, chainResponsibility.processChain(Request.DO_THIRD)),
                () -> assertThrows(RuntimeException.class, () -> chainResponsibility.processChain(Request.DO_FOURTH))
        );
    }

    @org.junit.jupiter.api.Test
    void testCommand() {
        var operations = List.of(
                new OperationA("1"),
                new OperationB("1"),
                new OperationA("2"),
                new OperationB("2"),
                new OperationA("3"),
                new OperationB("4")
        );

        for (var operation : operations) {
            operation.execute();
        }
    }

    @org.junit.jupiter.api.Test
    void testIterator() {
        var items = new Item[]{
                new Item("code1", "name1"),
                new Item("code2", "name2"),
                new Item("code3", "name3")};

        CustomCollection<Item> itemsCollection = new CustomCollection<>(items);

        var iterator = itemsCollection.getIterator();
        while (iterator.hasNext()) {
            var item = iterator.next();
            System.out.printf("Code %s : Name: %s%n", item.getCode(), item.getName());
        }
    }

    @org.junit.jupiter.api.Test
    void testMediator() {

        Mediator<String> mediator = new ConcreteMediator();

        Colleague<String> colleague1 = new ConcreteColleage("1", mediator);
        Colleague<String> colleague2 = new ConcreteColleage("2", mediator);
        Colleague<String> colleague3 = new ConcreteColleage("3", mediator);
        Colleague<String> colleague4 = new ConcreteColleage("4", mediator);
        Colleague<String> colleague5 = new ConcreteColleage("5", mediator);

        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);
        mediator.addColleague(colleague3);
        mediator.addColleague(colleague4);
        mediator.addColleague(colleague5);

        colleague1.send(new Message<>("2", "Hello 2"));
        colleague2.send(new Message<>("3", "Hello 3"));
        colleague3.send(new Message<>("1", "Hello 1"));
        colleague4.send(new Message<>("5", "Hello 5"));
        colleague5.send(new Message<>("4", "Hello 4"));

        assertThrows(RuntimeException.class, () -> colleague5.send(new Message<>("8", "Hello 4")));
    }

    @org.junit.jupiter.api.Test
    void testMemento() {
        var caretaker = new UserCaretaker();
        var user = new UserOriginator(1L, "uncledavecode@gmail.com", "Uncle", "Dave Code");

        System.out.println(user);

        caretaker.add(user.createMemento());

        user.setName("Uncle 2");

        System.out.println(user);

        user.restore(caretaker.get(0));

        System.out.println(user);
    }

    @org.junit.jupiter.api.Test
    void testObserver() {
        var subject = new Subject<String>();

        subject.addEventListener(new Observer1());
        subject.addEventListener(new Observer2());
        subject.addEventListener(new Observer3());

        subject.dispatchEvent(new CustomEvent<>("Hello"));
    }

    @org.junit.jupiter.api.Test
    void testState() {
        var stateContext = new Context();

        var stateA = new StateA();
        stateA.handle(stateContext);

        System.out.println(stateContext.getState().toString());

        var stateB = new StateB();
        stateB.handle(stateContext);

        System.out.println(stateContext.getState().toString());

        var stateC = new StateC();
        stateC.handle(stateContext);

        System.out.println(stateContext.getState().toString());
        System.out.println(stateContext.getState().toString());

    }

    @org.junit.jupiter.api.Test
    void testTemplateMethod() {
        TemplateClass obj1 = new ConcreteObject1();
        TemplateClass obj2 = new ConcreteObject2();

        obj1.buildAll(true);
        obj2.buildAll(false);
    }

    @org.junit.jupiter.api.Test
    void testVisitor() {
        Visitor visitor = new ConcreteVisitor();

        Element concreteElementA = new ConcreteElementA();
        Element concreteElementB = new ConcreteElementB();
        concreteElementA.accept(visitor);
        concreteElementB.accept(visitor);

    }

    @org.junit.jupiter.api.Test
    void testInterpreter() {
        ExpressionUtils expressionUtils = new ExpressionUtils();
        assertAll(
                () -> assertEquals("3.0", expressionUtils.evaluateExpression("1+2")),
                () -> assertEquals("8.0", expressionUtils.evaluateExpression("10-2")),
                () -> assertEquals("36.0", expressionUtils.evaluateExpression("12*3")),
                () -> assertEquals("4.0", expressionUtils.evaluateExpression("20/5")),
                () -> assertEquals("-2.0", expressionUtils.evaluateExpression("2+4-2*20/5"))
        );
        System.out.println(expressionUtils.evaluateExpression("1+2"));
        System.out.println(expressionUtils.evaluateExpression("10-2"));
        System.out.println(expressionUtils.evaluateExpression("12*3"));
        System.out.println(expressionUtils.evaluateExpression("20/5"));
        System.out.println(expressionUtils.evaluateExpression("2+4-2*20/5"));

    }

    @org.junit.jupiter.api.Test
    void testStrategy() {
        StrategyContext context = new StrategyContext(new AddStrategy());
        assertEquals(3.0, context.executeStrategy(1.0, 2.0));
        System.out.println(context.executeStrategy(1.0, 2.0));

        context = new StrategyContext(new SubstractStrategy());
        assertEquals(4.0, context.executeStrategy(5.0, 1.0));
        System.out.println(context.executeStrategy(5.0, 1.0));

    }
}