package br.com.arcelino.validadorapi.api;

public class Response {
    private String message;
    private boolean valid;

    public Response(String message, boolean valid) {
        this.message = message;
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public boolean isValid() {
        return valid;
    }
}
