package cn.echo.pojo;

import java.util.Date;

public class Productinfo {
    private Integer id;

    private String name;

    private String description;

    private Date createtime;

    private Double marketprice;

    private Double sellprice;

    private Integer categoryid;

    private Integer categoryinfoid;

    private Boolean commend;

    private Integer sellcount;

    private Integer productount;

    private Integer shopid;

    public Productinfo() {
    }

    public Productinfo(Integer id, String name, String description, Date createtime, Double marketprice, Double sellprice, Integer categoryid, Integer categoryinfoid, Boolean commend, Integer sellcount, Integer productount, Integer shopid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createtime = createtime;
        this.marketprice = marketprice;
        this.sellprice = sellprice;
        this.categoryid = categoryid;
        this.categoryinfoid = categoryinfoid;
        this.commend = commend;
        this.sellcount = sellcount;
        this.productount = productount;
        this.shopid = shopid;
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
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Double marketprice) {
        this.marketprice = marketprice;
    }

    public Double getSellprice() {
        return sellprice;
    }

    public void setSellprice(Double sellprice) {
        this.sellprice = sellprice;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getCategoryinfoid() {
        return categoryinfoid;
    }

    public void setCategoryinfoid(Integer categoryinfoid) {
        this.categoryinfoid = categoryinfoid;
    }

    public Boolean getCommend() {
        return commend;
    }

    public void setCommend(Boolean commend) {
        this.commend = commend;
    }

    public Integer getSellcount() {
        return sellcount;
    }

    public void setSellcount(Integer sellcount) {
        this.sellcount = sellcount;
    }

    public Integer getProductount() {
        return productount;
    }

    public void setProductount(Integer productount) {
        this.productount = productount;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    @Override
    public String toString() {
        return "Productinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createtime=" + createtime +
                ", marketprice=" + marketprice +
                ", sellprice=" + sellprice +
                ", categoryid=" + categoryid +
                ", categoryinfoid=" + categoryinfoid +
                ", commend=" + commend +
                ", sellcount=" + sellcount +
                ", productount=" + productount +
                ", shopid=" + shopid +
                '}';
    }
}