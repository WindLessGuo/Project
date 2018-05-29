package com.wind.project.wind;

import java.util.List;

public class MainBean {

    private String message;
    private String status;
    private List<ResultDataBean> resultData;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultDataBean> getResultData() {
        return resultData;
    }

    public void setResultData(List<ResultDataBean> resultData) {
        this.resultData = resultData;
    }

    public static class ResultDataBean {

        private int id;
        private String pCode;
        private String name;
        private String description;
        private String imagePath;
        private Object detailPath;
        private int pType;
        private int stockType;
        private Object supplier;
        private Object brandId;
        private String brandName;
        private Object pComment;
        private int largeCatagoryId;
        private Object middleCatagoryId;
        private int smallCatagoryId;
        private Object keywords;
        private Object available;
        private double salePrice;
        private double marketPrice;
        private Object specId;
        private Object pLabel;
        private Object qrcodeBig;
        private Object qrcodeMiddle;
        private Object qrcodeSmall;
        private Object creDate;
        private Object updateDate;
        private Object deleted;
        private int quantity;
        private Object unitId;
        private Object unitName;
        private Object shelfLife;
        private Object pWeight;
        private String mallCode;
        private int online;
        private int safeQuantity;
        private int qtyStatus;
        private int pSendType;
        private Object tagList;
        private Object saleNum;
        private String favouriteProductId;
        private Object discount;
        private Object promotionLabel;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPCode() {
            return pCode;
        }

        public void setPCode(String pCode) {
            this.pCode = pCode;
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

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public Object getDetailPath() {
            return detailPath;
        }

        public void setDetailPath(Object detailPath) {
            this.detailPath = detailPath;
        }

        public int getPType() {
            return pType;
        }

        public void setPType(int pType) {
            this.pType = pType;
        }

        public int getStockType() {
            return stockType;
        }

        public void setStockType(int stockType) {
            this.stockType = stockType;
        }

        public Object getSupplier() {
            return supplier;
        }

        public void setSupplier(Object supplier) {
            this.supplier = supplier;
        }

        public Object getBrandId() {
            return brandId;
        }

        public void setBrandId(Object brandId) {
            this.brandId = brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public Object getPComment() {
            return pComment;
        }

        public void setPComment(Object pComment) {
            this.pComment = pComment;
        }

        public int getLargeCatagoryId() {
            return largeCatagoryId;
        }

        public void setLargeCatagoryId(int largeCatagoryId) {
            this.largeCatagoryId = largeCatagoryId;
        }

        public Object getMiddleCatagoryId() {
            return middleCatagoryId;
        }

        public void setMiddleCatagoryId(Object middleCatagoryId) {
            this.middleCatagoryId = middleCatagoryId;
        }

        public int getSmallCatagoryId() {
            return smallCatagoryId;
        }

        public void setSmallCatagoryId(int smallCatagoryId) {
            this.smallCatagoryId = smallCatagoryId;
        }

        public Object getKeywords() {
            return keywords;
        }

        public void setKeywords(Object keywords) {
            this.keywords = keywords;
        }

        public Object getAvailable() {
            return available;
        }

        public void setAvailable(Object available) {
            this.available = available;
        }

        public double getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(double salePrice) {
            this.salePrice = salePrice;
        }

        public double getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(double marketPrice) {
            this.marketPrice = marketPrice;
        }

        public Object getSpecId() {
            return specId;
        }

        public void setSpecId(Object specId) {
            this.specId = specId;
        }

        public Object getPLabel() {
            return pLabel;
        }

        public void setPLabel(Object pLabel) {
            this.pLabel = pLabel;
        }

        public Object getQrcodeBig() {
            return qrcodeBig;
        }

        public void setQrcodeBig(Object qrcodeBig) {
            this.qrcodeBig = qrcodeBig;
        }

        public Object getQrcodeMiddle() {
            return qrcodeMiddle;
        }

        public void setQrcodeMiddle(Object qrcodeMiddle) {
            this.qrcodeMiddle = qrcodeMiddle;
        }

        public Object getQrcodeSmall() {
            return qrcodeSmall;
        }

        public void setQrcodeSmall(Object qrcodeSmall) {
            this.qrcodeSmall = qrcodeSmall;
        }

        public Object getCreDate() {
            return creDate;
        }

        public void setCreDate(Object creDate) {
            this.creDate = creDate;
        }

        public Object getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Object updateDate) {
            this.updateDate = updateDate;
        }

        public Object getDeleted() {
            return deleted;
        }

        public void setDeleted(Object deleted) {
            this.deleted = deleted;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Object getUnitId() {
            return unitId;
        }

        public void setUnitId(Object unitId) {
            this.unitId = unitId;
        }

        public Object getUnitName() {
            return unitName;
        }

        public void setUnitName(Object unitName) {
            this.unitName = unitName;
        }

        public Object getShelfLife() {
            return shelfLife;
        }

        public void setShelfLife(Object shelfLife) {
            this.shelfLife = shelfLife;
        }

        public Object getPWeight() {
            return pWeight;
        }

        public void setPWeight(Object pWeight) {
            this.pWeight = pWeight;
        }

        public String getMallCode() {
            return mallCode;
        }

        public void setMallCode(String mallCode) {
            this.mallCode = mallCode;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public int getSafeQuantity() {
            return safeQuantity;
        }

        public void setSafeQuantity(int safeQuantity) {
            this.safeQuantity = safeQuantity;
        }

        public int getQtyStatus() {
            return qtyStatus;
        }

        public void setQtyStatus(int qtyStatus) {
            this.qtyStatus = qtyStatus;
        }

        public int getPSendType() {
            return pSendType;
        }

        public void setPSendType(int pSendType) {
            this.pSendType = pSendType;
        }

        public Object getTagList() {
            return tagList;
        }

        public void setTagList(Object tagList) {
            this.tagList = tagList;
        }

        public Object getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(Object saleNum) {
            this.saleNum = saleNum;
        }

        public String getFavouriteProductId() {
            return favouriteProductId;
        }

        public void setFavouriteProductId(String favouriteProductId) {
            this.favouriteProductId = favouriteProductId;
        }

        public Object getDiscount() {
            return discount;
        }

        public void setDiscount(Object discount) {
            this.discount = discount;
        }

        public Object getPromotionLabel() {
            return promotionLabel;
        }

        public void setPromotionLabel(Object promotionLabel) {
            this.promotionLabel = promotionLabel;
        }
    }
}
