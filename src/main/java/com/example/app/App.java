package com.example.app;

public class App
{

    private final String message = "Hello TAPD!";
    int a = 0;
    int b = 1;
    public App() {}

    public static void main(String[] args) {
        System.out.println(new App().getMessage());
    }

    private final String getMessage() {
    	int c = b/a;
    	System.out.println("this is my test");
    	System.out.println("this is my test");
        return message;
    }

}
