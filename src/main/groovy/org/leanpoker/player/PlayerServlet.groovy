package org.leanpoker.player

import groovy.json.JsonSlurper

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/")
class PlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.writer.print("Groovy player is running, version: $Player.VERSION")
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter('action') == 'bet_request') {
            def gameState = req.getParameter('game_state')

			resp.writer.print(Player.betRequest(new JsonSlurper().parseText(gameState)))
		}
        if (req.getParameter('action') == 'showdown') {
            def gameState = req.getParameter('game_state')

			Player.showdown(new JsonSlurper().parseText(gameState))
		}
        if (req.getParameter('action') == 'version') {
            resp.writer.print(Player.VERSION)
		}
    }
}
