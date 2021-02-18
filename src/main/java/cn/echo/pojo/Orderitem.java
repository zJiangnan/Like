package cn.echo.pojo;

public class Orderitem {
    private Integer id;

    private Integer productid;

    private String productname;

    private Float productprice;

    private Integer amount;

    private Integer orderid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Float getProductprice() {
        return productprice;
    }

    public void setProductprice(Float productprice) {
        this.productprice = productprice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}