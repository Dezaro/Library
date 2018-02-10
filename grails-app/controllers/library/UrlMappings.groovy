package library

class UrlMappings {

    static mappings = {
//        "/$controller/$action?/$id?(.$format)?" {
//            constraints {
//                // apply constraints here
//            }
//        }

        "/book"(controller:"book", action: "index", method:"GET")
        "/"(view: "/index")
//        "500"(view: '/error')
//        "404"(view: '/notFound')
    }
}
