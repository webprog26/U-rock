package com.developer.webprog26.u_rock.pojo;

/**
 * Created by webprog26 on 12.10.17.
 */

public class FullArticle extends Article {

    public FullArticle(long articleId,
                       String articleTitle,
                       String articleText,
                       int articleCategoryId,
                       long articleServerId,
                       String articleMainImageUrl,
                       String articleAuthor,
                       String dateArticlePublished,
                       boolean isArticleFavourite) {
        super(articleId,
                articleTitle,
                articleText,
                articleCategoryId,
                articleServerId,
                articleMainImageUrl,
                articleAuthor,
                dateArticlePublished,
                isArticleFavourite);
    }
}
