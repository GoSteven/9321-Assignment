package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Generic interface for a command
 * @author  yunki
 */
public interface Command {
	
	String execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
	
}
