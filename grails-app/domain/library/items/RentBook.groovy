package library.items
import grails.rest.*

import javax.persistence.Table

@Table(name="RentBook")
@Resource(uri='/rentBook', formats=['json', 'xml'])
class RentBook {

    static belongsTo = [readerCards: ReaderCard, books: Book]
    Long id
    Date rentDate
    Date returnBeforeDate
    Date returnDate
    boolean isReturn = Boolean.FALSE

    static constraints = {
        id nullable: false, unique: true
        rentDate nullable: false
        returnBeforeDate nullable: false
    }
}
