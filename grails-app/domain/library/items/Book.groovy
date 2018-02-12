package library.items

import grails.rest.*

import javax.persistence.Table

@Table(name="Book")
@Resource(uri='/api/book', formats=['json', 'xml'])
class Book {

    static belongsTo = [category: Category, author: Author]
    Long id
    String title
    Date publishedDate
    String isbn
    String description
    String publisher
    boolean isAvailable = Boolean.TRUE


    static constraints = {
        id nullable: false, blank:false
        title nullable: false, blank: false
        isbn unique: true, nullable: false
    }
}
