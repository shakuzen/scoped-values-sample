package com.example.demo.structured;

import com.example.demo.framework.Application;
import com.example.demo.framework.Framework;
import com.example.demo.framework.Request;
import com.example.demo.framework.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class StructuredConcurrencyApplication implements Application {

    @Override
    public void handle(Request request, Response response) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<String> a = scope.fork(() -> getA(request));
            Supplier<String> b = scope.fork(() -> getB(request));
            scope.join().throwIfFailed();
            writeToResponse(a.get(), b.get(), response);
        } catch (ExecutionException | InterruptedException e) {
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
        response.write("a = %s, b = %s".formatted(a, b));
    }

}
