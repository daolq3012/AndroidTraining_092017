package com.example.sony.training;

/**
 * Created by Administrator on 11/08/17.
 */

public class datashop {
    private int hinhanh;
    private  String txtname;
    private  String txtprice;

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTxtname() {
        return txtname;
    }

    public void setTxtname(String txtname) {
        this.txtname = txtname;
    }

    public String getTxtprice() {
        return txtprice;
    }

    public void setTxtprice(String txtprice) {
        this.txtprice = txtprice;
    }

    public datashop(int hinhanh, String txtname, String txtprice) {
        this.hinhanh = hinhanh;
        this.txtname = txtname;
        this.txtprice = txtprice;

    }
}
