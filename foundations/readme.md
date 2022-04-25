# Foundations

These modules are the core of the application. They are used throughout your code base. They should abstract the implementations of the libraries they are using in order to reduce changes throughout the application when something changes.

For example, we should not expose the Interceptor class from OkHttp, but instead expose our own approach to adding interceptors. This means if we convert from OkHttp to another networking library the rest of the application does not change.