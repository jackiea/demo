package com.youkol.demo.java.nashorn.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 参考教程
 * <ul>
 * <li><a href="https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/nashorn/">官方参考UR</a>
 * <li><a href="https://www.cnblogs.com/top8/p/6207945.html">Java 8 的 Nashorn 脚本引擎教程</a>
 * <li><a href="https://www.cnblogs.com/tian830937/p/4459383.html">java调用JavaScript脚本</a>
 * <li><a href="https://blog.csdn.net/inthat/article/details/94554957">java 1.8 脚本引擎执行javascript脚本</a>
 * </ul>
 * 
 * @author jackiea
 */
public class SimpleDemo {

    /**
     * For example, output:
     * <p> Hello World
     * 
     * @throws ScriptException
     */
    public void helloWord() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello World')");
    }

    /**
     * 
     * @throws ScriptException
     * @throws FileNotFoundException
     * @throws NoSuchMethodException
     */
    public void invokeJsFile() throws ScriptException, FileNotFoundException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        FileReader reader = new FileReader("script/script.js");
        engine.eval(reader);
        // output:
        // I am in script.js

        // Java调用Javascript 函数
        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("fun1", "Peter Parker");
        System.out.println("result: " + result);
        System.out.println("result class: " +result.getClass());
        // output:
        // Hi there from Javascript, Peter Parker
        // result: greetings from javascript
        // result class: class java.lang.String

        invocable.invokeFunction("fun2", new Date());
        invocable.invokeFunction("fun2", LocalDateTime.now());
        invocable.invokeFunction("fun2", new Person());
        // output:
        // JS class Definition: [object java.util.Date]
        // JS class Definition: [object java.time.LocalDateTime]
        // JS class Definition: [object com.youkol.demo.java.nashorn.demo.Person]

        // 在 JavaScript 端调用 Java 方法
        invocable.invokeFunction("fun3");
        // output:
        // Hi there from Java, John Doe
        // Greetings from JAVA
    }

    /**
     * js中调用此方法，需要把该方法定义为public
     * 
     * @param name 名称
     * @return 结果
     */
    public static String forJsInvoke(String name) {
        System.out.format("Hi there from Java, %s%n", name);
        return "Greetings from JAVA";
    }

    /**
     * For example, output:
     * <p> Name: Oracle Nashorn
     * <p> Version: 1.8.0_262
     * <p> Language name: ECMAScript
     * <p> Language version: ECMA - 262 Edition 5.1
     * <p> Extensions: [js]
     * <p> Mime types: [application/javascript, application/ecmascript, text/javascript, text/ecmascript]
     * <p> Names: [nashorn, Nashorn, js, JS, JavaScript, javascript, ECMAScript, ecmascript]
     * 
     */
    public void listScriptEngineInfo() {
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        factories.forEach(t -> {
            System.out.printf("Name: %s %n", t.getEngineName());
            System.out.printf("Version: %s %n", t.getEngineVersion());
            System.out.printf("Language name: %s %n", t.getLanguageName());
            System.out.printf("Language version: %s %n", t.getLanguageVersion());
            System.out.printf("Extensions: %s %n", t.getExtensions());
            System.out.printf("Mime types: %s %n", t.getMimeTypes());
            System.out.printf("Names: %s %n", t.getNames());
        });
    }

    public static void main(String[] args) {
        try {
            SimpleDemo demo = new SimpleDemo();
            demo.listScriptEngineInfo();

            demo.helloWord();

            demo.invokeJsFile();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}
