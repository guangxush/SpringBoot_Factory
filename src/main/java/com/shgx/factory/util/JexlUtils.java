package com.shgx.factory.util;


import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
public class JexlUtils {
    private static final JexlEngine jexlEngine = new JexlBuilder().create();

    public static boolean executeBoolean(String script, JexlContext context) {
        JexlExpression expression = jexlEngine.createExpression(script);
        Boolean execute = (Boolean) expression.evaluate(context);
        if (execute == null) {
            return false;
        }
        return execute.booleanValue();
    }
}
