print('I am in script.js');

var fun1 = function(name) {
    print('Hi there from Javascript, ' + name);
    return "greetings from javascript";
}

var fun2 = function(obj) {
    print("JS class Definition: " + Object.prototype.toString.call(obj));
}

var fun3 = function() {
    var myJavaClass = Java.type('com.youkol.demo.java.nashorn.demo.SimpleDemo');
    var result = myJavaClass.forJsInvoke('John Doe');
    print(result);
}
