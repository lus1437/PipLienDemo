package com.example.app;

public class App
{

    private final String message = "Hello TAPD!";
    int a = 0;
    int b = 1;
    String string = new String();
    public App() {}

    public static void main(String[] args) {
        System.out.println(new App().getMessage());
    }

    private final String getMessage() {
    	int d = b/a;
    	System.out.println(string.length());
    	System.out.println("this is my test");
    	System.out.println("this is my test");
        return message;
    }

}
