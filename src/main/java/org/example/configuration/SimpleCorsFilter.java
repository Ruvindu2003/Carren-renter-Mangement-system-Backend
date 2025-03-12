package org.example.configuration;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Allow requests from a specific origin (e.g., Angular app running on localhost:4200)
        String origin = httpRequest.getHeader("Origin");

        // Set CORS headers
        if (origin != null) {
            httpResponse.setHeader("Access-Control-Allow-Origin", origin); // Or a fixed origin if required
        } else {
            httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:4200"); // Use a specific URL if no origin is found
        }

        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With"); // Better to list headers explicitly
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Max-Age", "3600"); // Cache preflight response for 1 hour

        // Handle preflight requests
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK); // Respond with 200 OK for OPTIONS requests
        } else {
            // Pass the request down the filter chain
            chain.doFilter(request, response);
        }
    }
}
