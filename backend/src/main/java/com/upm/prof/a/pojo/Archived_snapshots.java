package com.upm.prof.a.pojo;

public class Archived_snapshots {
    private Closest closest;

    public Closest getClosest() {
        return closest;
    }

    public void setClosest(Closest closest) {
        this.closest = closest;
    }

    public Archived_snapshots(Closest closest) {
        this.closest = closest;
    }

    public Archived_snapshots(){

    }

    @Override
    public String toString() {
        return "archived_snapshots{" +
                "closest=" + closest +
                '}';
    }
}