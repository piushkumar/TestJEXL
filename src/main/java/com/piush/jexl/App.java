package com.piush.jexl;

import org.apache.commons.jexl3.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        JexlEngine jexl = new JexlBuilder().cache(512).strict(true).silent(false).create();
        // Assuming we have a JexlEngine instance initialized in our class named 'jexl':
        // Create an expression object for our calculation
        String calculateTax = "((G1 + G2 + G3) * 0.1) + G4";
        JexlExpression e = jexl.createExpression(calculateTax);

        // populate the context
        JexlContext context = new MapContext();
        context.set("G1", 2300);
        context.set("G2", -1);
        context.set("G3", 4);
        context.set("G4", -12);
        // ...

        // work it out
        Number result = (Number) e.evaluate(context);
        System.out.println(result);
    }
}
