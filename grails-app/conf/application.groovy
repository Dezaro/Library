grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails {
    plugin {
        springsecurity {
            securityConfigType = "InterceptUrlMap"
            userLookup {
                userDomainClassName = 'library.items.User'
                authorityJoinClassName = 'library.items.UserSecurityRole'
            }
            authority {
                className = 'library.items.SecurityRole'
            }
            filterChain {
                chainMap = [
                        [pattern: '/api/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],
                        [pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
                ]
            }
            interceptUrlMap = [
                    [pattern: '/', access: ['permitAll']],
                    [pattern: '/dbconsole/**', access: ['permitAll']],
                    [pattern: '/error', access: ['permitAll']],
                    [pattern: '/index', access: ['permitAll']],
                    [pattern: '/index.gsp', access: ['permitAll']],
                    [pattern: '/shutdown', access: ['permitAll']],
                    [pattern: '/assets/**', access: ['permitAll']],
                    [pattern: '/**/js/**', access: ['permitAll']],
                    [pattern: '/**/css/**', access: ['permitAll']],
                    [pattern: '/**/images/**', access: ['permitAll']],
                    [pattern: '/**/favicon.ico', access: ['permitAll']],
                    [pattern: '/login/**', access: ['permitAll']],
                    [pattern: '/logout', access: ['permitAll']],
                    [pattern: '/logout/**', access: ['permitAll']],
                    [pattern: '/announcement', access: ['ROLE_BOSS', 'ROLE_EMPLOYEE']],
                    [pattern: '/announcement/index', access: ['ROLE_BOSS', 'ROLE_EMPLOYEE']],
                    [pattern: '/announcement/create', access: ['ROLE_BOSS']],
                    [pattern: '/announcement/save', access: ['ROLE_BOSS']],
                    [pattern: '/announcement/update', access: ['ROLE_BOSS']],
                    [pattern: '/announcement/delete/*', access: ['ROLE_BOSS']],
                    [pattern: '/announcement/edit/*', access: ['ROLE_BOSS']],
                    [pattern: '/announcement/show/*', access: ['ROLE_BOSS', 'ROLE_EMPLOYEE']],
                    [pattern: '/api/login', access: ['ROLE_ANONYMOUS']],
                    [pattern: '/oauth/access_token', access: ['ROLE_ANONYMOUS']],
                    [pattern: '/api/announcements', access: ['ROLE_BOSS'], httpMethod: 'GET'],
                    [pattern: '/api/announcements/*', access: ['ROLE_BOSS'], httpMethod: 'GET'],
                    [pattern: '/api/announcements/*', access: ['ROLE_BOSS'], httpMethod: 'DELETE'],
                    [pattern: '/api/announcements', access: ['ROLE_BOSS'], httpMethod: 'POST'],
                    [pattern: '/api/announcements/*', access: ['ROLE_BOSS'], httpMethod: 'PUT']
            ]
        }
    }
}