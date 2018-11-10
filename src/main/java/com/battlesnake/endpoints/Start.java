package com.battlesnake.endpoints;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battlesnake.game.snake.Snake;

/**
 * This is the servlet that is hit when triggering the /start endpoint.
 *
 * @author Tony
 * @author Jaxson Van Doorn
 */
@WebServlet("/start")
public class Start extends Endpoint {
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        respond(Snake.startResponse().toJson(), response);
    }
}