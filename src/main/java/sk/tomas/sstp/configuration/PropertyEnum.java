package sk.tomas.sstp.configuration;

/**
 * Created by Tomas Pachnik on 28-Apr-17.
 */
public enum PropertyEnum {
    FONT_SIZE("fontsize"),
    COLUMNS("columns"),
    ROWS("rows"),
    INVERT_COLORS("invertColors");

    public String getName() {
        return name;
    }

    private String name;

    PropertyEnum(String name) {
        this.name = name;
    }
}
