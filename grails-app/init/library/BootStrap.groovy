package library

import library.items.*;

class BootStrap {

    def init = { servletContext ->
        def category = new Category(catName:"Programming")
                .addToArticles(new Article(title:"How to Create Grails Web Application",author:"Didin J.",description:"Step by step tutorial on how to create Grails web application from scratch",content:"Step by step tutorial on how to create Grails web application from scratch"))
                .save(flush:true)
    }
    def destroy = {
    }
}
