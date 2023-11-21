package com.example.demo;

import io.sentry.SentryEvent;
import io.sentry.SentryOptions;
import io.sentry.TypeCheckHint;
import io.sentry.Breadcrumb;
import io.sentry.Hint;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomBeforeSendCallback implements SentryOptions.BeforeBreadcrumbCallback{
  @Override
  public Breadcrumb execute(Breadcrumb breadcrumb, Hint hint) {
    if (breadcrumb.getCategory().equals("http")) {
        HttpRequest request = (HttpRequest) hint.get(TypeCheckHint.SPRING_REQUEST_INTERCEPTOR_REQUEST);
        breadcrumb.setData("request.headers", request.getHeaders());
    }			
    return breadcrumb;
  }
}