package com.upm.prof.a.pojo;

public class Busqueda {

    private String url;

    private Archived_snapshots archived_snapshots;

    public Busqueda(){
    }

    public Busqueda(String url, Archived_snapshots archived_snapshots) {
        this.url = url;
        this.archived_snapshots = archived_snapshots;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Archived_snapshots getArchived_snapshots() {
        return archived_snapshots;
    }

    public void setArchived_snapshots(Archived_snapshots archived_snapshots) {
        this.archived_snapshots = archived_snapshots;
    }

    @Override
    public String toString() {
        return "Busqueda{" +
                "url='" + url + '\'' +
                ", archived_snapshots=" + archived_snapshots +
                '}';
    }
}
