package library.items

import grails.rest.*

@Resource(uri='/article')
class Article {

    static belongsTo = [category:Category]
    String title
    String author
    String description
    String content
    Date createDate =  new Date()

    static constraints = {
        title blank: false
        author blank: false
        description blank: false
        content blank: false
    }
}