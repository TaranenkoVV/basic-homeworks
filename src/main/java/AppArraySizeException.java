public class AppArraySizeException extends RuntimeException{
    private String format;
    public String getFormat() {
        return format;
    }
    public AppArraySizeException(String message, String format) {
        super("Ошибка! Некорректный размер массива: " + format);
        this.format = format;
    }
}
