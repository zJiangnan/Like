package cn.echo.pojo;

/**
 * @Package: cn.echo.pojo
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/27 11:30
 * @Description:
 **/
public class CategoryInfo {
    private Integer cinfoid;
    private String cinfoname;
    private Integer pid;

    public CategoryInfo() {
    }

    public CategoryInfo(Integer cinfoid, String cinfoname, Integer pid) {
        this.cinfoid = cinfoid;
        this.cinfoname = cinfoname;
        this.pid = pid;
    }

    public Integer getCinfoid() {
        return cinfoid;
    }

    public void setCinfoid(Integer cinfoid) {
        this.cinfoid = cinfoid;
    }

    public String getCinfoname() {
        return cinfoname;
    }

    public void setCinfoname(String cinfoname) {
        this.cinfoname = cinfoname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "cinfoid=" + cinfoid +
                ", cinfoname='" + cinfoname + '\'' +
                ", pid=" + pid +
                '}';
    }
}
