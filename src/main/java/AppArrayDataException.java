public class AppArrayDataException extends NumberFormatException{
    private String format;
    public String getFormat() {
        return format;
    }
    public AppArrayDataException(String message, String format) {
        super("Ошибка! Некорректный формат элемента: " + format);
        this.format =  format;
    }
}
