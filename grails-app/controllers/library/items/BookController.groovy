package library.items

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BookController {

    BookService bookService

    static allowedMethods = [index: "GET", save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
//        Book book = new Book(id: 1, label: "delo")
        Book book = new Book()
        respond book.findById(1)
    }

    def show(Long id) {
        respond bookService.get(id)
    }

    def create() {
        respond new Book(params)
    }

    def save(Book book) {
        if (book == null) {
            notFound()
            return
        }

        try {
            bookService.save(book)
        } catch (ValidationException e) {
            respond book.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*' { respond book, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bookService.get(id)
    }

    def update(Book book) {
        if (book == null) {
            notFound()
            return
        }

        try {
            bookService.save(book)
        } catch (ValidationException e) {
            respond book.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*'{ respond book, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bookService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'book.label', default: 'Book'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
