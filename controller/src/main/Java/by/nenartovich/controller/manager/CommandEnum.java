package by.nenartovich.controller.manager;


import by.nenartovich.controller.manager.impl.CatalogCommand;

import by.nenartovich.controller.manager.impl.NewOrderCommand;
import by.nenartovich.controller.manager.impl.OrderCommand;
import by.nenartovich.controller.manager.impl.OrdersCommand;

public enum CommandEnum {
    ORDERS("Orders", "WEB-INF/pages/orders.jsp", new OrdersCommand()),
    ORDER("Order", "WEB-INF/pages/order.jsp", new OrderCommand()),
    NEW_ORDER("newOrder", "WEB-INF/pages/new_order.jsp", new NewOrderCommand()),
    CATALOG("Catalog", "WEB-INF/pages/catalog.jsp", new CatalogCommand());
    private String pageName;
    private final String pagePath;
    private Command command;

    CommandEnum(String pageName, String pagePath, Command command) {
        this.pageName = pageName;
        this.pagePath = pagePath;
        this.command = command;
    }

    public static CommandEnum selectCommand(String pageName) {
        for (CommandEnum type : CommandEnum.values()) {
            if (type.pageName.equalsIgnoreCase(pageName)) {
                return type;
            }
        }
        return ORDERS;
    }

    public String getPageName() {
        return pageName;
    }


    public String getPagePath() {
        return pagePath;
    }

    public Command getCommand() {
        return command;
    }
}
