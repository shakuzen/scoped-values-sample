package com.example.demo.unstructured;

import com.example.demo.framework.Application;
import com.example.demo.framework.Framework;
import com.example.demo.framework.Request;
import com.example.demo.framework.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UnstructuredConcurrencyApplication implements Application {

    ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    @Override
    public void handle(Request request, Response response) {
        Future<String> a = executorService.submit(() -> getA(request));
        Future<String> b = executorService.submit(() -> getB(request));
        try {
            writeToResponse(a.get(), b.get(), response);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private String getA(Request request) {
        return Framework.readKey("a");
    }

    private String getB(Request request) {
        return Framework.readKey("b");
    }

    private void writeToResponse(String a, String b, Response response) {
    }

}
