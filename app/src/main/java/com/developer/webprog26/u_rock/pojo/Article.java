package com.developer.webprog26.u_rock.pojo;

/**
 * Single article POJO class
 */

public class Article {

    private long articleId;
    private String articleTitle;
    private int articleCategoryId;
    private long articleServerId;
    private String articleMainImageUrl;
    private String articleText;
    private String articleAuthor;
    private String dateArticlePublished;
    private boolean isArticleFavourite;

    public Article(long articleId,
                   String articleTitle,
                   String articleText,
                   int articleCategoryId,
                   long articleServerId,
                   String articleMainImageUrl,
                   String articleAuthor,
                   String dateArticlePublished,
                   boolean isArticleFavourite) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleText = articleText;
        this.articleCategoryId = articleCategoryId;
        this.articleServerId = articleServerId;
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

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public int getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(int articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public long getArticleServerId() {
        return articleServerId;
    }

    public void setArticleServerId(long articleServerId) {
        this.articleServerId = articleServerId;
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
