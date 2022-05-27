package enums;

public enum  Color {

    RED("rgba(217, 83, 79, 0.4)", "red"),
    GREEN("rgba(92, 184, 92, 0.5)", "green");

    private final String rgba;

    private final String colorName;

    Color(String rgba, String colorName) {
        this.rgba = rgba;
        this.colorName = colorName;
    }

    public String getRgba() {
        return rgba;
    }

    public String getColorName() {
        return colorName;
    }
}
