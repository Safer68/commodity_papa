package by.nenartovich.controller.manager;


import by.nenartovich.controller.manager.impl.CatalogCommand;
import by.nenartovich.controller.manager.impl.OrderCommand;

public enum CommandEnum {
    ORDERS("Orders", "WEB-INF/pages/orders.jsp", new OrderCommand()),
    CATALOG("Catalog", "catalog.jsp", new CatalogCommand());
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
