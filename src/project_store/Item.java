package project_store;


public class Item {
    private Integer txtNo;
    private String txtName;
    private Integer txtPrice;
    private Integer txtQuntity;
    private Integer comboCurrancy;
    private Integer txtTotal;
    private String txtURL;
    
    public Item(){
      
    }
   public Item(Integer txtNo,String txtName,Integer txtPrice,
                    Integer txtQuntity,Integer comboCurrancy ,Integer txtTotal,String txtURL){
        this.txtNo=txtNo;
        this.txtName=txtName;
        this.txtPrice=txtPrice;
        this.txtQuntity=txtQuntity;
        this.comboCurrancy=comboCurrancy;
        this.txtTotal=txtTotal;
        this.txtURL=txtURL;
    }
 
    @Override
    public String toString(){
      return "Student( textNo = "+getTxtNo()+",textName = "+getTxtName()+",textPrice = "+getTxtPrice()+
              ",textQ = "+getTxtQuntity()+",comboCurrancy = "+getComboCurrancy() + ",textTotal = "+getTxtTotal()+",txtURL = "+getTxtURL();
    }  

    /**
     * @return the txtNo
     */
    public Integer getTxtNo() {
        return txtNo;
    }

    /**
     * @param txtNo the txtNo to set
     */
    public void setTxtNo(Integer txtNo) {
        this.txtNo = txtNo;
    }

    /**
     * @return the txtName
     */
    public String getTxtName() {
        return txtName;
    }

    /**
     * @param txtName the txtName to set
     */
    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    /**
     * @return the txtPrice
     */
    public Integer getTxtPrice() {
        return txtPrice;
    }

    /**
     * @param txtPrice the txtPrice to set
     */
    public void setTxtPrice(Integer txtPrice) {
        this.txtPrice = txtPrice;
    }

    /**
     * @return the txtQuntity
     */
    public Integer getTxtQuntity() {
        return txtQuntity;
    }

    /**
     * @param txtQuntity the txtQuntity to set
     */
    public void setTxtQuntity(Integer txtQuntity) {
        this.txtQuntity = txtQuntity;
    }

    /**
     * @return the comboCurrancy
     */
    public Integer getComboCurrancy() {
        return comboCurrancy;
    }

    /**
     * @param comboCurrancy the comboCurrancy to set
     */
    public void setComboCurrancy(Integer comboCurrancy) {
        this.comboCurrancy = comboCurrancy;
    }

    /**
     * @return the txtTotal
     */
    public Integer getTxtTotal() {
        return txtTotal;
    }

    /**
     * @param txtTotal the txtTotal to set
     */
    public void setTxtTotal(Integer txtTotal) {
        this.txtTotal = txtTotal;
    }

    /**
     * @return the txtURL
     */
    public String getTxtURL() {
        return txtURL;
    }

    /**
     * @param txtURL the txtURL to set
     */
    public void setTxtURL(String txtURL) {
        this.txtURL = txtURL;
    }
}
