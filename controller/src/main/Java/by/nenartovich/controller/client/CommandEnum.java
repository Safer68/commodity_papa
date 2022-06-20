package by.nenartovich.controller.client;


import by.nenartovich.controller.client.impl.CatalogCommand;
import by.nenartovich.controller.client.impl.OrdersCommand;


public enum CommandEnum {
    ORDERS("Orders", "WEB-INF/client/pages/orders.jsp", new OrdersCommand()),
    CATALOG("Catalog", "WEB-INF/client/pages/catalog.jsp", new CatalogCommand());
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
        return CATALOG;
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
