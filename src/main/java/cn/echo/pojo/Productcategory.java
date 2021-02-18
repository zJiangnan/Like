package cn.echo.pojo;

public class Productcategory {
    private Integer id;

    private String name;

    public Productcategory() {
    }

    public Productcategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Productcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}