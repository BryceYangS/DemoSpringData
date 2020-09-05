package me.whiteship.demospringdata;

public class Hosuk {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hosuk{" +
                "name='" + name + '\'' +
                '}';
    }
}
