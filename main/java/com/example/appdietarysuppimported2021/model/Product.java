package com.example.appdietarysuppimported2021.model;

import com.example.appdietarysuppimported2021.R;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private int image;
    private String name;
    private long price;
    private float saleOff;

    public Product(int id, int image, String name, long price, float saleOff) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.saleOff = saleOff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public float getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(float saleOff) {
        this.saleOff = saleOff;
    }

    public static List<Product> getMockListProduct(){
    List<Product> listProduct = new ArrayList<>();
    listProduct.add(new Product(1, R.drawable.hinh_cosamin_230_us,"Cosamin USA", 1250000, 10.0f));
    listProduct.add(new Product(2, R.drawable.hinh_cxk_schitnew_dt1_ger,"Schitnew Đức", 400000, 0.0f));
    listProduct.add(new Product(3, R.drawable.hinh_doppel_glucosamin800_ger,"Doppel Đức", 270000, 0.0f));
    listProduct.add(new Product(4, R.drawable.hinh_gelenk1200_ger,"Gelenk Đức", 350000, 5.0f));
    listProduct.add(new Product(5, R.drawable.hinh_kirkland_220_us,"KirkLand 220 USA", 500000, 5.0f));
    listProduct.add(new Product(6, R.drawable.hinh_kirkland_375_us,"KirkLand 375 USA", 550000, 0.0f));
    listProduct.add(new Product(7, R.drawable.hinh_kirkland_coq10_us,"KirkLand CoQ10 USA", 560000, 5.0f));
    listProduct.add(new Product(8, R.drawable.hinh_osteo_bi_flex_us,"Osteo Bi Flex USA", 680000, 0.0f));
    listProduct.add(new Product(9, R.drawable.hinh_puritans_pride_aus,"Puritans Pride Úc", 550000, 5.0f));
    listProduct.add(new Product(10, R.drawable.hinh_shark_cartilage_365_aus,"Shark Cartilage 365 Úc", 670000, 0.0f));

    return listProduct;
    }
    @Override
    public String toString(){
        return "Product{" +
                "id=" + id +
                ", image=" + image +
                ", name=" + name + '\'' +
                ", price=" + price +
                ", saleOff=" + saleOff +
                '}';
    }

}