package com.example.demo.structured;

import com.example.demo.framework.Application;
import com.example.demo.framework.Framework;
import com.example.demo.framework.Request;
import com.example.demo.framework.Response;

import java.util.concurrent.StructuredTaskScope;

import static java.util.concurrent.StructuredTaskScope.Joiner.allSuccessfulOrThrow;

@SuppressWarnings("preview")
public class StructuredConcurrencyApplication implements Application {

    @Override
    public void handle(Request request, Response response) {
        try (var scope = StructuredTaskScope.open(allSuccessfulOrThrow())) {
            var a = scope.fork(() -> getA(request));
            var b = scope.fork(() -> getB(request));
            scope.join();
            writeToResponse(a.get(), b.get(), response);
        } catch (InterruptedException e) {
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
