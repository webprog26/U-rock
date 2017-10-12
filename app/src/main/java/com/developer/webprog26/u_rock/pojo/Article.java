package com.developer.webprog26.u_rock.pojo;

/**
 * Single article POJO class
 */

public class Article {

    private long articleId;
    private String articleTitle;
    private int articleCategoryId;
    private String articleMainImageUrl;
    private String articleAuthor;
    private String dateArticlePublished;
    private boolean isArticleFavourite;

    public Article(long articleId,
                   String articleTitle,
                   int articleCategoryId,
                   String articleMainImageUrl,
                   String articleAuthor,
                   String dateArticlePublished,
                   boolean isArticleFavourite) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleCategoryId = articleCategoryId;
        this.articleMainImageUrl = articleMainImageUrl;
        this.articleAuthor = articleAuthor;
        this.dateArticlePublished = dateArticlePublished;
        this.isArticleFavourite = isArticleFavourite;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public int getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(int articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public String getArticleMainImageUrl() {
        return articleMainImageUrl;
    }

    public void setArticleMainImageUrl(String articleMainImageUrl) {
        this.articleMainImageUrl = articleMainImageUrl;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getDateArticlePublished() {
        return dateArticlePublished;
    }

    public void setDateArticlePublished(String dateArticlePublished) {
        this.dateArticlePublished = dateArticlePublished;
    }

    public boolean isArticleFavourite() {
        return isArticleFavourite;
    }

    public void setArticleFavourite(boolean articleFavourite) {
        isArticleFavourite = articleFavourite;
    }
}
