package sk.tomas.sstp.configuration;

/**
 * Created by tomas on 4/28/17.
 */
public enum MessagesEnum {
    SECOND_SCREEN_NOT_FOUND("Nenasiel sa druhy monitor!"),
    CONFIGURATION_ERROR("Chyba v konfiguracnom subore!");

    private String text;

    MessagesEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
