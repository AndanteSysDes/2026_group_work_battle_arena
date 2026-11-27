package game;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
    GAME_START("1",  "1. Starta spelet"),
    SHOW_HISTORY("2",  "2. Visa spelhistoriken"),
    END_SYSTEM("0", "0. Avsluta spelet.");

    private String inputValue;
    private String displayName;

    private static final Map<String, Menu> MENU_OPTIONS = createMenuOptions();

    Menu( String inputValue, String displayName) {
        this.inputValue = inputValue;
        this.displayName = displayName;
    }

    private static Map<String, Menu> createMenuOptions() {
        Map<String, Menu> menuOptions = new HashMap<>();
        for (Menu menu : Menu.values()) {
            menuOptions.put(menu.getInputValue(), menu);
        }
        return menuOptions;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getInputValue() {
        return inputValue;
    }

    public static boolean containsMenuOption(String inputValue) {
        return MENU_OPTIONS.containsKey(inputValue);
    }


}
