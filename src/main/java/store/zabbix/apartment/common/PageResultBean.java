package store.zabbix.apartment.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * description: 分页返回统一
 *
 * @author eyck.cui update: 2019-07-25 01:11
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class PageResultBean<T> extends ResultBean<List<T>> implements Serializable {

    /**
     * 总记录数
     */
    private long totalRecord;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 当前页码
     */
    private int pageNo;

    private List<T> data;

    /**
     * 当前页的记录数量
     */
    private int pageSize;

    public PageResultBean(Page<T> page) {
        int size = page.getPageable().getPageSize();
        long total = page.getTotalElements();
        this.setPageNo(page.getPageable().getPageNumber())
                .setPageSize(size)
                .setTotalRecord(total)
                .setPageCount(page.getTotalPages());
        this.setData(page.getContent());
    }

    @Override
    public String toString() {
        return "PageResulBean{" +
                "totalRecord=" + totalRecord +
                ", pageCount=" + pageCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                "}";
    }

    public PageResultBean setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        return this;
    }

    public PageResultBean setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public PageResultBean setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public PageResultBean setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public List<T> getData() {
        return data;
    }
    @Override
    public PageResultBean setData(List<T> data) {
        this.data = data;
        return this;
    }
}
