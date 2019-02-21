package it.unifi.rc.httpserver.m5793664.http_protocol;

/**
 * Functional Interface that wrap a method that could call an exception. This
 * interface is used for manage exceptions into streams
 *
 * @author Gabriele Bertini, 5793664
 */

@FunctionalInterface
public interface CheckProtocolExeption<T, R, E extends Exception> {
	R apply(T t) throws E;
}