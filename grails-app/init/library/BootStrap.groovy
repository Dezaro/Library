package library

import library.items.*;

class BootStrap {

    def init = { servletContext ->
        new Book(id: 1, label: "delo").save()
        new Book(id: 1, label: "new2").save()
    }
    def destroy = {
    }
}
