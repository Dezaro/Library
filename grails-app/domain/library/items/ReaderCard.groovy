package library.items
import grails.rest.*

import javax.persistence.Table

@Table(name="ReaderCard")
@Resource(uri='/readerCard', formats=['json', 'xml'])
class ReaderCard {

    Long id
    Long cardNumber
    String reader_name
    Date dateOfBirth
    String address
    String phone
    Date registerDate
    String email
    boolean isActive = Boolean.TRUE

    static constraints = {
        id nullable: false
        cardNumber nullable: false, unique: true
        reader_name nullable: false
        dateOfBirth nullable: false
        phone nullable: false
        registerDate nullable: false
        email email: true
    }
}
