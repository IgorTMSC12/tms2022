package eshop.commands;

import eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface BaseCommand {

    String execute(HttpServletRequest request) throws CommandException;
}
