package store.zabbix.wheather.model;

import lombok.Data;
import org.springframework.util.StringUtils;
import store.zabbix.wheather.util.DateUtils;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class Traceability implements Serializable {

    /**
     * 创建时间
     **/
    @Column(name = "create_date")
    private Long createDate;

    /**
     * 更新时间
     **/
    @Column(name = "update_date")
    private Long updateDate;

    /**
     * 创建人员
     **/
    private String createBy;

    /**
     * 更新人员
     **/
    private String updateBy;


    /**
     * 自动设置 createBy,updateBy,createDt,updateDt
     * 标记对象可追溯信息,时间,操作人
     *
     * @param isCreate 是否为创建当前对象
     */
    public Traceability trace(boolean isCreate) {
        String defaultOperator = "system";
        Date now = new Date();
        if (isCreate) {
            if (StringUtils.isEmpty(this.createBy)) {
                this.createBy = defaultOperator;
            }
        } else {
            this.createBy = null;
        }
        this.createDate = DateUtils.getTimestamp(now);
        if (StringUtils.isEmpty(this.updateBy)) {
            this.updateBy = defaultOperator;
        }
        this.updateDate = DateUtils.getTimestamp(now);
        return this;
    }

}