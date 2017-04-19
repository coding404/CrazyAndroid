package com.liushu.crazyandroid.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 * 用来存放小节目录
 */

public class CatalogBeantest {
    private String chapterName;
    private int totalExample;
    private List<paragraphBean> paragraphs;
    public static class paragraphBean implements Serializable{
        private String paragraphName;

        public String getParagraphName() {
            return paragraphName;
        }

        public void setParagraphName(String paragraphName) {
            this.paragraphName = paragraphName;
        }
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getTotalExample() {
        return totalExample;
    }

    public void setTotalExample(int totalExample) {
        this.totalExample = totalExample;
    }

    public List<paragraphBean> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<paragraphBean> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public String toString() {
        return "CatalogBeantest{" +
                "chapterName='" + chapterName + '\'' +
                ", totalExample='" + totalExample + '\'' +
                ", paragraphs=" + paragraphs +
                '}';
    }
}
