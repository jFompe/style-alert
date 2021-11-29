package com.upm.prof.a.pojo;

public class Closest {
    private boolean available;
    private String url;
    private String timestamp;
    private String status;

    public Closest(boolean available, String url, String timestamp, String status) {
        this.available = available;
        this.url = url;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Closest(){}

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "closest{" +
                "available=" + available +
                ", url='" + url + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}