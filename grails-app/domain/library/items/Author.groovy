package library.items
import grails.rest.*

import javax.persistence.Table

@Table(name="Author")
@Resource(uri='/author', formats=['json', 'xml'])
class Author {

    static hasMany = [books:Book]
    String authorName

    static constraints = {
        authorName nullable: false, blank: false
    }
}
