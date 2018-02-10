package library.items

import grails.rest.*

import javax.persistence.Table

@Table(name="Category")
@Resource(uri='/category', formats=['json', 'xml'])
class Category {

    static hasMany = [books:Book]
    Long id
    String categoryName

    static constraints = {
        categoryName nullable: false, blank: false
    }
}
