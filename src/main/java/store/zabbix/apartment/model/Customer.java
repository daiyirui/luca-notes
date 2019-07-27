package store.zabbix.apartment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "re_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Traceability{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    private Integer months;

    private String address;

    @Column(name = "start_time")
    private Long startTime;

    private Integer times;

    private String remark;

    @Column(name = "update_time")
    private Long updateTime;

    @Column(name = "room_status")
    private Boolean roomStatus;

    private Integer speator;

    private String[] type;

}
