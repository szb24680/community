package com.southwind.community.api.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TEmployeeSales implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 员工销售id
     */
    private Integer esId;

    /**
     * 销售人员姓名ID
     */
    private Integer eId;

    /**
     * 全店ID
     */
    private Integer wsId;
    
    /**
     * 员工销售日期
     */
    private Date esDate;

    /**
     * 员工销售数量
     */
    private Integer esNumber;

    /**
     * 员工销售数量占比
     */
    private BigDecimal esNumberRatio;

    /**
     * 员工销售额
     */
    private BigDecimal esAmount;

    /**
     * 员工销售额占比
     */
    private BigDecimal esAmountRatio;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * @return 员工销售id
     */
    public Integer getEsId() {
        return esId;
    }

    /**
     * @param esId 
	 *            员工销售id
     */
    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    /**
     * @return 销售人员姓名ID
     */
    public Integer geteId() {
        return eId;
    }

    /**
     * @param eId 
	 *            销售人员姓名ID
     */
    public void seteId(Integer eId) {
        this.eId = eId;
    }

    /**
     * @return 全店ID
     */
    public Integer getWsId() {
        return wsId;
    }

    /**
     * @param wsId 
	 *            全店ID
     */
    public void setWsId(Integer wsId) {
        this.wsId = wsId;
    }

    /**
     * @return 员工销售数量
     */
    public Integer getEsNumber() {
        return esNumber;
    }

    /**
     * @param esNumber 
	 *            员工销售数量
     */
    public void setEsNumber(Integer esNumber) {
        this.esNumber = esNumber;
    }

    /**
     * @return 员工销售数量占比
     */
    public BigDecimal getEsNumberRatio() {
        return esNumberRatio;
    }

    /**
     * @param esNumberRatio 
	 *            员工销售数量占比
     */
    public void setEsNumberRatio(BigDecimal esNumberRatio) {
        this.esNumberRatio = esNumberRatio;
    }

    /**
     * @return 员工销售额
     */
    public BigDecimal getEsAmount() {
        return esAmount;
    }

    /**
     * @param esAmount 
	 *            员工销售额
     */
    public void setEsAmount(BigDecimal esAmount) {
        this.esAmount = esAmount;
    }

    /**
     * @return 员工销售额占比
     */
    public BigDecimal getEsAmountRatio() {
        return esAmountRatio;
    }

    /**
     * @param esAmountRatio 
	 *            员工销售额占比
     */
    public void setEsAmountRatio(BigDecimal esAmountRatio) {
        this.esAmountRatio = esAmountRatio;
    }

    /**
     * @return 员工销售日期
     */
    public Date getEsDate() {
        return esDate;
    }

    /**
     * @param esDate 
	 *            员工销售日期
     */
    public void setEsDate(Date esDate) {
        this.esDate = esDate;
    }

    /**
     * @return 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate 
	 *            创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return 修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate 
	 *            修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser 
	 *            创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return 修改人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser 
	 *            修改人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}