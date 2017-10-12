package com.developer.webprog26.u_rock.pojo;

/**
 * Created by webprog26 on 12.10.17.
 */

public class FullArticle extends Article {

    public FullArticle(long articleId,
                       String articleTitle,
                       int articleCategoryId,
                       String articleMainImageUrl,
                       String articleAuthor,
                       String dateArticlePublished,
                       boolean isArticleFavourite) {
        super(articleId,
                articleTitle,
                articleCategoryId,
                articleMainImageUrl,
                articleAuthor,
                dateArticlePublished,
                isArticleFavourite);
    }
}
