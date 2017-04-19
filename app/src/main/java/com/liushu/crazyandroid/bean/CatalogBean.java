package com.liushu.crazyandroid.bean;

import java.util.List;

/**
 * Created by liushu on 2017/2/4.
 */

public class CatalogBean {


    private List<ChaptersBean> chapters;

    public List<ChaptersBean> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChaptersBean> chapters) {
        this.chapters = chapters;
    }

    public static class ChaptersBean {
        /**
         * chapterName : 2.1界面编程
         * paragraphs : [{"paragraphName":"333"},{"paragraphName":"111"},{"paragraphName":"222"}]
         */

        private String chapterName;
        private List<ParagraphsBean> paragraphs;

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public List<ParagraphsBean> getParagraphs() {
            return paragraphs;
        }

        public void setParagraphs(List<ParagraphsBean> paragraphs) {
            this.paragraphs = paragraphs;
        }

        public static class ParagraphsBean {
            /**
             * paragraphName : 333
             */

            private String paragraphName;

            public String getParagraphName() {
                return paragraphName;
            }

            public void setParagraphName(String paragraphName) {
                this.paragraphName = paragraphName;
            }
        }
    }
}
