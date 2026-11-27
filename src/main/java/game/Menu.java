package game;

public enum Menu {
    GAME_START("1",  "1. Starta spelet"),
    SHOW_HISTORY("2",  "2. Visa spelhistoriken"),
    END_SYSTEM("0", "0. Avsluta spelet.");

    private String inputValue;
    private String displayName;

    Menu( String inputValue, String displayName) {
        this.inputValue = inputValue;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getInputValue() {
        return inputValue;
    }

    public static boolean containsMenuOption(String inputValue) {
        boolean result = false;
        for (Menu menu : Menu.values()) {
            if (menu.getInputValue().equals(inputValue)) {
                result = true;
            }
        }

        return result;
    }


}
