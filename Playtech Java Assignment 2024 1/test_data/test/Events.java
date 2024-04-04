package test_data.test;

public class Events {
    private int transactionId;
    private String status;
    private String message;

    // Konstruktor
    public Events(int parts, String status, String message) {
        this.transactionId = parts;
        this.status = status;
        this.message = message;
    }

    public Events(String string, String status2, String message2) {
        //TODO Auto-generated constructor stub
    }

    // Getterid ja setterid
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
