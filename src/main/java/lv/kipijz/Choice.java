package lv.kipijz;

public enum Choice {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    public static Choice map(String text) {
        for (Choice value : Choice.values()) {
            if (text.equalsIgnoreCase(value.toString())) {
                return value;
            }
        }
        return null;
    }
}
