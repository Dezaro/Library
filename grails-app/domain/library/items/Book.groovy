package library.items

import grails.rest.*

import javax.persistence.Table

@Table(name="Book")
@Resource(uri='/book', formats=['json', 'xml'])
class Book {

    Long id
    String label

    static constraints = {
        id blank:false
        label blank: false
    }
}
